package com.asad.taleembazar.fragments;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.asad.taleembazar.R;
import com.asad.taleembazar.activities.HomeActivity;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

/**
 *
 * A simple {@link Fragment} subclass.
 *
 */
public class SecondFrgamnet extends Fragment {
//partial registeration without email done
public EditText cnfrm,password;
   public Button btn;
    String value,ema;
    public SecondFrgamnet() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.layout_registertwo,container, false);
        Toolbar toolbar = (Toolbar) getActivity().findViewById(R.id.toolbar_fragment);
        toolbar.setTitle("Register");
        value = getArguments().getString("Name");
        ema=getArguments().getString("Email");
      cnfrm=(EditText) view.findViewById(R.id.cnfrm);
        password=(EditText)view.findViewById(R.id.password_register_edittext);
        btn=(Button) view.findViewById(R.id.register_btn_for_register);
       btn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               String a=password.getText().toString();
               String b=cnfrm.getText().toString();
if (a.equals(b))
{
    RegisterUser obj=new RegisterUser();
    obj.execute(value,ema,password.getText().toString());
}
else
{
    Snackbar.make(btn,"Password Does not Match",Snackbar.LENGTH_LONG).show();
}


           }
       });
        return view;
    }

    private class RegisterUser extends AsyncTask<String, Void, String>
    {
        StringBuilder sb=new StringBuilder();
        String url="http://taleembazaar.com/AndroidRegistration.php";
        String nme;
        String eme;
        String pass;
        ProgressDialog progressDialog=new ProgressDialog(getContext());

        @Override
        protected void onPreExecute()
        { progressDialog.setMessage("Checking signup please wait");
            progressDialog.setIndeterminate(true);
            progressDialog.setCancelable(false);
            progressDialog.show();
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... params) {

            try {

                nme=params[0];
                eme=params[1];
                pass=params[2];
                URL u = new URL(url);
                HttpURLConnection con = (HttpURLConnection) u.openConnection();
                con.setDoOutput(true);

                con.setRequestMethod("POST");

                OutputStream os = con.getOutputStream();
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
                String data = URLEncoder.encode("username", "UTF-8") + "=" + URLEncoder.encode(nme, "UTF-8") + "&" +
                        URLEncoder.encode("userpass", "UTF-8") + "=" + URLEncoder.encode(pass, "UTF-8") + "&" +
                        URLEncoder.encode("useremail", "UTF-8") + "=" + URLEncoder.encode(eme, "UTF-8");

                bw.write(data);
                bw.flush();
                bw.close();
                InputStream is = con.getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(is,"iso-8859-1"));
                String line = "";
                while ((line = br.readLine()) != null) {
                    sb.append(line);
                }
                String m=sb.toString();

                return sb.toString();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }



            return null;
        }

        @Override
        protected void onPostExecute(String s) {

            if(s.equals("Registered Successsfully"))
            {

                progressDialog.dismiss();
                Intent i=new Intent(getContext(), HomeActivity.class);
                startActivity(i);

            }
            else
            {
                progressDialog.dismiss();
                Snackbar.make(btn, s, Snackbar.LENGTH_LONG).show();
            }
        }
    }

}

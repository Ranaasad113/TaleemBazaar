package com.asad.taleembazar.fragments;


import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.asad.taleembazar.R;

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

public EditText email,password;
   public Button btn;
    String value;
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
      email=(EditText) view.findViewById(R.id.email_register_edittext);
        password=(EditText)view.findViewById(R.id.password_register_edittext);
        btn=(Button) view.findViewById(R.id.register_btn_for_register);
       btn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               String e = email.getText().toString();
               if (e.contains("@uog.edu.pk")) {
                   checkuser obj = new checkuser();
                   obj.execute(e);
               } else {
Toast.makeText(getContext(),"Please Specify Your Uog Email Address",Toast.LENGTH_LONG).show();
               }
           }
       });
        return view;
    }
    private class checkuser extends AsyncTask<String, Void, String>
    {
        StringBuilder sb=new StringBuilder();
        String url="http://taleembazaar.com/AndroidCheckUser.php";
        String em;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... params) {

            try {

                em=params[0];
                URL u = new URL(url);
                HttpURLConnection con = (HttpURLConnection) u.openConnection();
                con.setDoOutput(true);

                con.setRequestMethod("POST");

                OutputStream os = con.getOutputStream();
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
                String data = URLEncoder.encode("useremail", "UTF-8") + "=" + URLEncoder.encode(em, "UTF-8");
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

            if(s.equals("User Exist"))
            {

                Toast.makeText(getContext(),"User with that Email Already Exist",Toast.LENGTH_LONG).show();
            }
            else
            {
                RegisterUser obj=new RegisterUser();
                obj.execute(value,email.getText().toString(),password.getText().toString());
            }
        }
    }
    private class RegisterUser extends AsyncTask<String, Void, String>
    {
        StringBuilder sb=new StringBuilder();
        String url="http://taleembazaar.com/AndroidRegistration.php";
        String nme;
        String eme;
        String pass;

        @Override
        protected void onPreExecute() {
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

                Toast.makeText(getContext(),"User is Registered",Toast.LENGTH_LONG).show();
            }
            else
            {
                Toast.makeText(getContext(), s, Toast.LENGTH_LONG).show();
            }
        }
    }

}

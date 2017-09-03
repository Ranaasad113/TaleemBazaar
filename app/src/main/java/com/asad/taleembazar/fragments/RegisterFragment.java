package com.asad.taleembazar.fragments;


import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

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
 * A simple {@link Fragment} subclass.
 */
public class RegisterFragment extends Fragment implements View.OnClickListener {
    public interface Communication {
        public void accept(int i);
    }
    private Bundle savedState = null;
    private Button btn;
    private Toolbar toolbar ;
    private Communication communication;
    private static int VALUE;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private static Context CONTEXT;
    private static String TYPE;
    private EditText fname,email;


    public RegisterFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
            View view = inflater.inflate(R.layout.layout_for_register, container, false);
        fname=(EditText)view.findViewById(R.id.first_name_register_edittext);
        email=(EditText)view.findViewById(R.id.email_register_edittext);
        btn = (Button) view.findViewById(R.id.next_btn_for_register);
            btn.setOnClickListener(this);
            toolbar = (Toolbar) getActivity().findViewById(R.id.toolbar_fragment);
            toolbar.setTitle("Register");
            return view;
    }
    @Override
    public void onAttach(Activity a) {
        super.onAttach(a);
        communication = (Communication) a;
    }

    @Override
    public void onClick(View v) {
        communication.accept(2);
        if(fname.getText().toString().isEmpty() && email.getText().toString().isEmpty()) {
            Snackbar.make(btn,"Please Specify Your Username and Email Address",Snackbar.LENGTH_LONG).show();
        }
        else {
            String e=email.getText().toString();
            if (e.contains("@uog.edu.pk")) {
                checkuser obj = new checkuser();
                obj.execute(e);
            } else {
                Snackbar.make(btn,"Please Specify Your Uog Email Address",Snackbar.LENGTH_LONG).show();
            }

        }
    }
    public void acceptValueActivity(int value, Context context,String type)
    {   VALUE=0;
        this.VALUE=value;
        CONTEXT=context;
        TYPE=type;
    }

    private class checkuser extends AsyncTask<String, Void, String>
    {
        StringBuilder sb=new StringBuilder();
        String url="http://taleembazaar.com/AndroidCheckUser.php";
        String em;
        ProgressDialog progressDialog=new ProgressDialog(getContext());

        @Override
        protected void onPreExecute() {
            progressDialog.setMessage("Checking Email please wait");
            progressDialog.setIndeterminate(true);
            progressDialog.setCancelable(false);
            progressDialog.show();

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

                progressDialog.dismiss();
                Snackbar.make(btn,"User with that Email Already Exist",Snackbar.LENGTH_SHORT).show();
            }
            else
            {
                progressDialog.dismiss();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                SecondFrgamnet fragmentscend=new SecondFrgamnet();

                String a = fname.getText().toString();
                Bundle args = new Bundle();
                args.putString("Name", a);
                args.putString("Email",em);
                fragmentscend.setArguments(args);
                fragmentTransaction.replace(R.id.coordinatelayout, fragmentscend);
                fragmentTransaction.addToBackStack("Fragment_2");
                fragmentTransaction.commit();
                getActivity().getFragmentManager().popBackStack();
            }
        }
    }

}

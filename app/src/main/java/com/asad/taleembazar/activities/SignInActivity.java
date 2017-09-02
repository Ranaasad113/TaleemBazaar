package com.asad.taleembazar.activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.preference.Preference;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.asad.taleembazar.CommonConstant;
import com.asad.taleembazar.R;
import com.asad.taleembazar.fragments.RegisterFragment;

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

public class SignInActivity extends AppCompatActivity implements RegisterFragment.Communication {
  private Toolbar mToolbar;
    EditText user,pass;
   private Button sign;
    private String username;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_in_layout);
        mToolbar = (Toolbar) findViewById(R.id.toolbar_fragment);
        user=(EditText)findViewById(R.id.username);
        pass=(EditText)findViewById(R.id.editText3);
        sign=(Button)findViewById(R.id.signbtn);

        settingToolbar();//Here's Toolbar of that Activity Set
        TextView no_account = (TextView) findViewById(R.id.no_account_register_textview);
        no_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickOnNoAccountTextview();
            }
        });
    sign.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String name=user.getText().toString();
            String p=pass.getText().toString();
            username=name;
            signin obj=new signin();
            obj.execute(name,p);
        }
    });
    }

    private void settingToolbar() {
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("Sign In ");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    private int clickOnNoAccountTextview()//This Function  is onclick listener for the textview on no account
    {
        int value=4219;
        String type=null;
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        RegisterFragment fragmentUsage = new RegisterFragment();
        fragmentTransaction.add(R.id.coordinatelayout, fragmentUsage);
        mToolbar.setTitle("Register");
        fragmentUsage.acceptValueActivity(value,this,type);
        fragmentTransaction.addToBackStack("Fragment_1");
        fragmentTransaction.commit();
        return 0;
    }

    @Override
    public void accept(int i) {

    }
    private class signin extends AsyncTask<String, Void, String>
    {
        StringBuilder sb=new StringBuilder();
        String url="http://taleembazaar.com/Androidlogin.php";
        String nme;
        String password;
        ProgressDialog progressDialog=new ProgressDialog(SignInActivity.this);


        @Override
        protected void onPreExecute() {
            progressDialog.setMessage("Checking login please wait");
            progressDialog.setIndeterminate(true);
            progressDialog.setCancelable(false);
            progressDialog.show();

            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... params) {

                try {

                    nme = params[0];
                    password = params[1];
                    URL u = new URL(url);
                    HttpURLConnection con = (HttpURLConnection) u.openConnection();
                    con.setDoOutput(true);

                    con.setRequestMethod("POST");

                    OutputStream os = con.getOutputStream();
                    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
                    String data = URLEncoder.encode("username", "UTF-8") + "=" + URLEncoder.encode(nme, "UTF-8") + "&" +
                            URLEncoder.encode("userpass", "UTF-8") + "=" + URLEncoder.encode(password, "UTF-8");
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

            if(s.equals("Login Successful"))
            {


               progressDialog.dismiss();
                Toast.makeText(getApplicationContext(),s,Toast.LENGTH_LONG).show();
                            }
            else
            {
                progressDialog.dismiss();
                Snackbar.make(sign,"There is an error",Snackbar.LENGTH_SHORT).show();
            }
        }
    }
}

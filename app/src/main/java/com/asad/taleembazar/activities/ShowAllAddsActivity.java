package com.asad.taleembazar.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.asad.taleembazar.CallBack;
import com.asad.taleembazar.R;
import com.asad.taleembazar.adpaters.ShowAllAddsAdapter;
import com.asad.taleembazar.model.DataModelAdds;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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
import java.util.ArrayList;

public class ShowAllAddsActivity extends AppCompatActivity implements CallBack, ClickCallback {
    // Hashmap for ListView
    ArrayList<DataModelAdds> contactList;
    private RecyclerView recyclerView;
    private String cat;
    private RecyclerView.Adapter showAllAddsAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private ProgressBar progressBar;
    private JSONArray contacts = null;
    String un;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_alladds_layout);
        progressBar = (ProgressBar) findViewById(R.id.progressbaradds);
        contactList = new ArrayList<DataModelAdds>();
        SharedPreferences my=ShowAllAddsActivity.this.getSharedPreferences("LoginInfo.tb",MODE_PRIVATE);
        un=my.getString("useremail","");
        Intent i=getIntent();
        Bundle b=i.getExtras();
        cat=b.getString("Categorie");
        if(cat.equals(un))
        {
getpostbymyadds obj1=new getpostbymyadds();
           obj1.setCallback1(this);
            obj1.execute();
        }
        else {
            getpostbycategories obj = new getpostbycategories();
            obj.setCallback(this);
            obj.execute();
        }
    }

    @Override
    public void getValue(Boolean bol) {
        if (bol) {
            progressBar.setVisibility(View.GONE);
            //Toast.makeText(getApplicationContext(), contactList.size(), Toast.LENGTH_SHORT).show();
            setAdapter();
        }
    }

    private void setAdapter() {
        recyclerView = (RecyclerView) findViewById(R.id.recyclerviewallads);
        layoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        showAllAddsAdapter = new ShowAllAddsAdapter(this, contactList, this);
        recyclerView.setAdapter(showAllAddsAdapter);
    }

    @Override
    public void takeValue(DataModelAdds dataModelAdds) {
        String data = new Gson().toJson(dataModelAdds);
        DataModelAdds dataModelAdds1 = dataModelAdds;
        Intent intent = new Intent(ShowAllAddsActivity.this, ShowAddActivity.class);
        intent.putExtra("object", data);
        startActivity(intent);


    }

    private class getpostbycategories extends AsyncTask<String, Void, String> {
        StringBuilder sb = new StringBuilder();
        String url = "http://taleembazaar.com/getpostbycategories.php";
        CallBack mcallBack;


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... params) {

            try {

                URL u = new URL(url);
                HttpURLConnection con = (HttpURLConnection) u.openConnection();
                con.setDoOutput(true);
                OutputStream os = con.getOutputStream();
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
                String data = URLEncoder.encode("cid", "UTF-8") + "=" + URLEncoder.encode(cat, "UTF-8");
                bw.write(data);
                bw.flush();
                bw.close();
                InputStream is = con.getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(is, "iso-8859-1"));
                String line = "";
                while ((line = br.readLine()) != null) {
                    sb.append(line);
                }
                String m = sb.toString();
                Log.d("json", m);
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

            if (s != null) {
                try {
                    JSONObject jsonObj = new JSONObject(s);

                    contacts = jsonObj.getJSONArray("Post_Data");


                    for (int i = 0; i < contacts.length(); i++) {
                        JSONObject c = contacts.getJSONObject(i);

                        String cid = c.getString("cid");
                        String addtype = c.getString("adtype");
                        String adsprice = c.getString("adsprice");
                        String adsimg1 = c.getString("adsimg1");
                        String adsimg2 = c.getString("adsimg2");
                        String adsimg3 = c.getString("adsimg3");
                        String adsimg4 = c.getString("adsimg4");
                        String adsdesc = c.getString("adsdesc");
                        String mobnum = c.getString("mobnum");
                        String adsloc = c.getString("adsloc");
                        String adtitle = c.getString("adstitle");

                        String addowner = c.getString("addowner");


                        // adding each child node to HashMap key => value



                        // adding contact to contact list
                        contactList.add(new DataModelAdds(new String[]{adsimg1, adsimg2, adsimg3,
                                adsimg4}, addowner, addtype, adtitle, adsprice, adsdesc, adsloc, mobnum));


                    }
                    mcallBack.getValue(true);
                } catch (JSONException e) {
                    e.printStackTrace();
                }


            } else {
                Toast.makeText(getApplicationContext(), "Json is Empty", Toast.LENGTH_LONG).show();
            }



        }
        public void setCallback(CallBack callback)
        {


            mcallBack=callback;
        }
    }
    private class getpostbymyadds extends AsyncTask<String, Void, String> {
        StringBuilder sb = new StringBuilder();
        String url = "http://taleembazaar.com/getmyadds.php";
        CallBack mcallBack;


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... params) {

            try {

                URL u = new URL(url);
                HttpURLConnection con = (HttpURLConnection) u.openConnection();
                con.setDoOutput(true);
                OutputStream os = con.getOutputStream();
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
                String data = URLEncoder.encode("useremail", "UTF-8") + "=" + URLEncoder.encode(cat, "UTF-8");
                bw.write(data);
                bw.flush();
                bw.close();
                InputStream is = con.getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(is, "iso-8859-1"));
                String line = "";
                while ((line = br.readLine()) != null) {
                    sb.append(line);
                }
                String m = sb.toString();
                Log.d("json", m);
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

            if (s != null) {
                try {
                    JSONObject jsonObj = new JSONObject(s);

                    contacts = jsonObj.getJSONArray("Post_Data");


                    for (int i = 0; i < contacts.length(); i++) {
                        JSONObject c = contacts.getJSONObject(i);

                        String cid = c.getString("cid");
                        String addtype = c.getString("adtype");
                        String adsprice = c.getString("adsprice");
                        String adsimg1 = c.getString("adsimg1");
                        String adsimg2 = c.getString("adsimg2");
                        String adsimg3 = c.getString("adsimg3");
                        String adsimg4 = c.getString("adsimg4");
                        String adsdesc = c.getString("adsdesc");
                        String mobnum = c.getString("mobnum");
                        String adsloc = c.getString("adsloc");
                        String adtitle = c.getString("adstitle");

                        String addowner = c.getString("addowner");


                        // adding each child node to HashMap key => value



                        // adding contact to contact list
                        contactList.add(new DataModelAdds(new String[]{adsimg1, adsimg2, adsimg3,
                                adsimg4}, addowner, addtype, adtitle, adsprice, adsdesc, adsloc, mobnum));


                    }
                    mcallBack.getValue(true);
                } catch (JSONException e) {
                    e.printStackTrace();
                }


            } else {
                Toast.makeText(getApplicationContext(), "Json is Empty", Toast.LENGTH_LONG).show();
            }



        }
        public void setCallback1(CallBack callback)
        {


            mcallBack=callback;
        }
    }

}

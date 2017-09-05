package com.asad.taleembazar.activities;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.asad.taleembazar.CallBack;
import com.asad.taleembazar.R;

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
import java.util.HashMap;

public class ShowAllAddsActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
String cat;
    JSONArray contacts = null;

    // Hashmap for ListView
    ArrayList<HashMap<String, String>> contactList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_alladds_layout);
        contactList = new ArrayList<HashMap<String, String>>();
        Intent i=getIntent();
        Bundle b=i.getExtras();
        cat=b.getString("Categorie");
getpostbycategories obj=new getpostbycategories();
        obj.execute();

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

                    // looping through All Contacts
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

                        String addowner = c.getString("addowner");
                        HashMap<String, String> contact = new HashMap<String, String>();

                        // adding each child node to HashMap key => value
                        contact.put("cid", cid);
                        contact.put("addtype", addtype);
                        contact.put("adsprice", adsprice);
                        contact.put("adsimg1", adsimg1);
                        contact.put("adsimg2", adsimg2);

                        contact.put("adsimg3", adsimg3);
                        contact.put("adsimg4", adsimg4);

                        contact.put("adsdesc", adsdesc);
                        contact.put("mobnum", mobnum);
                        contact.put("adsloc", adsloc);
                        contact.put("addowner", addowner);


                        // adding contact to contact list
                        contactList.add(contact);


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

}

package com.asad.taleembazar.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.asad.taleembazar.CallBack;
import com.asad.taleembazar.R;
import com.asad.taleembazar.adpaters.RecyclerviewForHome;
import com.asad.taleembazar.model.DataModelAdds;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;


public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, CallBack, ClickCallback {
    private static NavigationView navigationView;
    JSONArray contacts = null;
    // Hashmap for ListView
    ArrayList<DataModelAdds> contactList;
    String username, useremail;
    private DrawerLayout drawer;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private FloatingActionButton submitaddbutton;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //ranaarsi

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        progressBar = (ProgressBar) findViewById(R.id.progressbar);
        setSupportActionBar(toolbar);
        //initializeSources();
        contactList = new ArrayList<DataModelAdds>();
        getpost obj=new getpost();
        obj.setCallback(this);
        obj.execute();


        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        submitaddbutton = (FloatingActionButton) findViewById(R.id.submitadd_toggle_button);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.getMenu().getItem(0).setChecked(true);
        textviewOfHeader();

        //rana arslan
        submitaddbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submitAdd();
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.search_menu, menu);
        SearchView mSearchView = (SearchView) menu.findItem(R.id.action_search).getActionView();


        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
        if (getSupportFragmentManager().findFragmentByTag("fragment_1") != null) {
            getSupportFragmentManager().popBackStackImmediate("fragment_1", 0);
        }


    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.nav_myaccount: {
                Intent intent = new Intent(getApplicationContext(), MyAccountActivity.class);
                intent.putExtra("PictureUploadingforMAC", "From My Account");
                startActivity(intent);
                break;
            }
            case R.id.nav_about_us: {
                Intent intent = new Intent(HomeActivity.this, AboutusActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.nav_help: {
                Intent intent = new Intent(HomeActivity.this, ContactusActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.nav_term_privacy: {
                Intent intent = new Intent(HomeActivity.this, TermsandPrivacyActivity.class);
                startActivity(intent);
            }
            case R.id.nav_search: {
                Intent intent = new Intent(HomeActivity.this, SearchActivity.class);
                startActivity(intent);
            }
            case R.id.nav_myadd: {
                SharedPreferences my=HomeActivity.this.getSharedPreferences("LoginInfo.tb",MODE_PRIVATE);
                username=my.getString("username","");
                useremail=my.getString("useremail","");
                if (username.equals("")) {
                    Toast.makeText(getApplicationContext(), "You Must Have to Login First", Toast.LENGTH_LONG).show();

                    Intent intent = new Intent(getApplicationContext(), SignInActivity.class);

                    startActivity(intent);

                } else {


                    Intent intent = new Intent(getApplicationContext(), ShowAllAddsActivity.class);
                    intent.putExtra("Categorie", useremail);
                    startActivity(intent);

                }
                break;
            }


            default: {
                Toast.makeText(getApplicationContext(), "Unable to start", Toast.LENGTH_LONG).show();
            }
        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private int textviewOfHeader() {
        View header_nav = navigationView.getHeaderView(0);
        TextView textView = (TextView) header_nav.findViewById(R.id.Sign_in);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SignInActivity.class);
                startActivity(intent);
            }
        });
        return 0;

    }

    private void homeItems() {
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview_for_home);
        layoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        adapter = new RecyclerviewForHome(this, contactList, this);
        recyclerView.setAdapter(adapter);

    }

    private void submitAdd() {
        Intent intent = new Intent(this, SubmitAddActivity.class);
        startActivity(intent);
    }




    @Override
    public void getValue(Boolean bol) {
        if (bol) {
            progressBar.setVisibility(View.GONE);
            homeItems();
        }
    }

    @Override
    public void takeValue(DataModelAdds dataModelAdds) {
        String data = new Gson().toJson(dataModelAdds);
        DataModelAdds dataModelAdds1 = dataModelAdds;
        Intent intent = new Intent(HomeActivity.this, ShowAddActivity.class);
        intent.putExtra("object", data);
        startActivity(intent);
    }

    private class getpost extends AsyncTask<String, Void, String> {
        StringBuilder sb = new StringBuilder();
        String url = "http://taleembazaar.com/getposts.php";
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
                        String adtitle = c.getString("adstitle");

                        String addowner = c.getString("addowner");
                        HashMap<String, String> contact = new HashMap<String, String>();

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
}
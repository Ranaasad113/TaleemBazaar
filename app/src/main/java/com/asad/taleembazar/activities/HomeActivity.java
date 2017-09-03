package com.asad.taleembazar.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.MenuInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.asad.taleembazar.R;
import com.asad.taleembazar.adpaters.RecyclerviewForHome;
import com.asad.taleembazar.model.DataSourceWrapper;

import java.util.ArrayList;



public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private static NavigationView navigationView ;
    private  DrawerLayout drawer;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private FloatingActionButton submitaddbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //ranaarsi

            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);
            initializeSources();
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
            homeItems();
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
      SearchView  mSearchView = (SearchView) menu.findItem(R.id.action_search).getActionView();


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
        }
        else {
            super.onBackPressed();
        }
        if (getSupportFragmentManager().findFragmentByTag("fragment_1") != null) {
            getSupportFragmentManager().popBackStackImmediate("fragment_1",0);
        }


    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id=item.getItemId();
        switch (id)
        {
            case R.id.nav_myaccount:
            {Intent intent=new Intent(getApplicationContext(),MyAccountActivity.class);
                intent.putExtra("PictureUploadingforMAC","From My Account");
                startActivity(intent);
                break;}


            default:
            {
                Toast.makeText(getApplicationContext(),"Unable to start",Toast.LENGTH_LONG).show();
            }
        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    private int textviewOfHeader()
    {
        View header_nav=navigationView.getHeaderView(0);
        TextView textView=(TextView)header_nav.findViewById(R.id.Sign_in);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent=new Intent(getApplicationContext(),SignInActivity.class);
              startActivity(intent);
            }
        });
        return 0;

    }
    private void homeItems()
    {
        recyclerView=(RecyclerView)findViewById(R.id.recyclerview_for_home);
        layoutManager=new GridLayoutManager(this,1);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        adapter=new RecyclerviewForHome(this);
        recyclerView.setAdapter(adapter);

    }
    private void submitAdd()
    {
        Intent intent=new Intent(this,SubmitAddActivity.class);
        startActivity(intent);
    }
    private void initializeSources()
    { ArrayList<String> arrayList=new ArrayList<>();
        arrayList.add("car");
        arrayList.add("mobiles");
        DataSourceWrapper.initDatasources(arrayList);
    }

}

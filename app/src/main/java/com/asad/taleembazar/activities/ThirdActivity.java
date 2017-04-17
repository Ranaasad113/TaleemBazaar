package com.asad.taleembazar.activities;

import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.asad.taleembazar.R;
import com.asad.taleembazar.adpaters.RecyclerAdpaterCategories;
import com.asad.taleembazar.fragments.FirstFragment;

public class ThirdActivity extends AppCompatActivity implements FirstFragment.Communication {
Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView();

    }
    public void setContentView()
    {
        setContentView(R.layout.activity_third);
        int value=4218;
        Intent intent=getIntent();
        String type=intent.getStringExtra("Check");
        toolbar = (Toolbar) findViewById(R.id.toolbar_third);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Select Category");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        FirstFragment fragmentUsage = new FirstFragment();
        fragmentTransaction.add(R.id.container_fragmentthird, fragmentUsage);
        fragmentUsage.acceptValueActivity(value,this,type);
        fragmentTransaction.commit();

    }

    @Override
    public void accept(int i) {

    }
}

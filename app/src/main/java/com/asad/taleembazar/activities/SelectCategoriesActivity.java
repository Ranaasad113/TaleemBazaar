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
import com.asad.taleembazar.fragments.RegisterFragment;

public class SelectCategoriesActivity extends AppCompatActivity implements RegisterFragment.Communication {
    private Toolbar toolbar;
    private static String TYPE;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView();

    }
    public void setContentView()
    {
        setContentView(R.layout.select_categories_from_hometextview);
        int value=4218;
        Intent intent=getIntent();
        String type=intent.getStringExtra("Check");
        toolbar = (Toolbar) findViewById(R.id.toolbar_third);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Select Category");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        RecyclerView recyclerViewforsubmitadd = (RecyclerView)findViewById(R.id.recyclerview_for_categories);
        layoutManager = new LinearLayoutManager(this);
        recyclerViewforsubmitadd.setLayoutManager(layoutManager);
        recyclerViewforsubmitadd.setHasFixedSize(true);
        adapter = new RecyclerAdpaterCategories(TYPE);
        recyclerViewforsubmitadd.setAdapter(adapter);

    }

    @Override
    public void accept(int i) {

    }
}

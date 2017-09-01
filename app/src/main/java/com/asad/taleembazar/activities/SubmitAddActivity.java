package com.asad.taleembazar.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.WindowManager;
import android.widget.Toast;

import com.asad.taleembazar.CallBack;
import com.asad.taleembazar.R;
import com.asad.taleembazar.adpaters.RecyclerAdapterForSubmitadd;

public class SubmitAddActivity extends AppCompatActivity {
private Toolbar mToolbar;
    private RecyclerView.LayoutManager mLayoutManager;
    RecyclerAdapterForSubmitadd mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.submitadd_layout);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        mToolbar = (Toolbar) findViewById(R.id.toolbar_submitadd);
        settingToolbar();
        RecyclerView recyclerViewforsubmitadd = (RecyclerView) findViewById(R.id.recyclerview_for_submitadd);
        mLayoutManager = new GridLayoutManager(this, 1);
        recyclerViewforsubmitadd.setLayoutManager(mLayoutManager);
        recyclerViewforsubmitadd.setHasFixedSize(true);
        mAdapter = new RecyclerAdapterForSubmitadd();
        recyclerViewforsubmitadd.setAdapter(mAdapter);
    }

    private void settingToolbar() {

        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("Submit Add");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }


}

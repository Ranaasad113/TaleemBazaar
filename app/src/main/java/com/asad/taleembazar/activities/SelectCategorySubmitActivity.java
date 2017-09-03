package com.asad.taleembazar.activities;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.asad.taleembazar.R;
import com.asad.taleembazar.adpaters.RecyclerAdpaterCategories;
import com.asad.taleembazar.adpaters.SelectCategorySubmitAddAdapter;

import java.util.ArrayList;

public class SelectCategorySubmitActivity extends AppCompatActivity implements com.asad.taleembazar.adpaters.callback  {
    private Toolbar toolbar;
    private static String TYPE;
    private RecyclerView recyclerView;
    private SelectCategorySubmitAddAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<String> arrayList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_category_submit);
        arrayList.add("Cars");
        arrayList.add("Mobiles");
        arrayList.add("Bags");
        RecyclerView recyclerViewforsubmitadd = (RecyclerView)findViewById(R.id.recyclerview_for_categoriessubmit);
        layoutManager = new LinearLayoutManager(this);
        recyclerViewforsubmitadd.setLayoutManager(layoutManager);
        recyclerViewforsubmitadd.setHasFixedSize(true);
        adapter = new SelectCategorySubmitAddAdapter(arrayList);
        adapter.setOnClick(this);
        recyclerViewforsubmitadd.setAdapter(adapter);
    }

    @Override
    public void onClick(int adapterPosition) {
        Intent intent=new Intent();
        intent.putExtra("result",arrayList.get(adapterPosition));
        setResult(Activity.RESULT_OK,intent);
        finish();
    }
}

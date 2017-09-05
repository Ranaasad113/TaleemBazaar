package com.asad.taleembazar.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.asad.taleembazar.R;
import com.asad.taleembazar.adpaters.ShowAddAdapter;
import com.asad.taleembazar.fragments.ImageFragmentAdapter;
import com.asad.taleembazar.model.DataModelAdds;
import com.google.gson.Gson;

import me.relex.circleindicator.CircleIndicator;

public class ShowAddActivity extends AppCompatActivity {
    private Toolbar mToolbar;
    private DataModelAdds dataModelAdds;
    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private RecyclerView.Adapter mAdapter;
    private ViewPager viewPager;
    private CircleIndicator indicator;
    private ImageFragmentAdapter fragmentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_add);
        mToolbar = (Toolbar) findViewById(R.id.toolbaradds);
        Intent getintent = getIntent();
        dataModelAdds = new Gson().fromJson(getintent.getStringExtra("object"), DataModelAdds.class);
        settingToolbar();
        setSlider();

    }

    private void settingToolbar() {
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) findViewById(R.id.collapseadd);
        viewPager = (ViewPager) findViewById(R.id.viewpagershow);
        indicator = (CircleIndicator) findViewById(R.id.indicator);

        collapsingToolbar.setTitle(dataModelAdds.getmType());
        collapsingToolbar.setCollapsedTitleTextColor(getResources().getColor(R.color.white_color));
        collapsingToolbar.setExpandedTitleColor(getResources().getColor(R.color.white_color));
        collapsingToolbar.setContentScrimColor(getResources().getColor(R.color.colorPrimary));
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerviewshowadd);
        mLayoutManager = new GridLayoutManager(this, 1);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setHasFixedSize(true);
        mAdapter = new ShowAddAdapter(dataModelAdds);
        mRecyclerView.setAdapter(mAdapter);

    }

    private void setSlider() {
        fragmentAdapter = new ImageFragmentAdapter(getSupportFragmentManager(), dataModelAdds.getmImagesUrl());
        viewPager.setAdapter(fragmentAdapter);
        indicator.setViewPager(viewPager);
    }
}

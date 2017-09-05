package com.asad.taleembazar.fragments;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by bullhead on 8/24/17.
 */

public class ImageFragmentAdapter extends FragmentPagerAdapter {
    private String[] urls;
    private DetailImageFragment[] fragments;

    public ImageFragmentAdapter(FragmentManager fm, String[] urls) {
        super(fm);
        this.urls = urls;
        fragments = new DetailImageFragment[urls.length];
    }

    @Override
    public Fragment getItem(int position) {
        fragments[position] = DetailImageFragment.newInstance(urls[position]);
        return fragments[position];
    }

    public DetailImageFragment getFragments(int position) {
        return fragments[position];
    }

    @Override
    public int getCount() {
        return urls.length;
    }
}
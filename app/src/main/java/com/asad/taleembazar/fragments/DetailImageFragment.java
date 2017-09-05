package com.asad.taleembazar.fragments;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.asad.taleembazar.R;
import com.squareup.picasso.Picasso;

/**
 * Created by bullhead on 8/24/17.
 */

public class DetailImageFragment extends Fragment {
    private String url;
    private ImageView imageView;
    private View mView;

    public static DetailImageFragment newInstance(String url) {

        Bundle args = new Bundle();

        DetailImageFragment fragment = new DetailImageFragment();
        fragment.url = url;
        fragment.setArguments(args);
        return fragment;
    }

    public View getView() {
        return mView;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_detail_image, container, false);
        imageView = (ImageView) mView.findViewById(R.id.image);
        return mView;
    }

    public void blur() {
        mView.setDrawingCacheEnabled(true);
        mView.buildDrawingCache();
        Bitmap bm = mView.getDrawingCache();
        imageView.setVisibility(View.GONE);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Picasso.with(getActivity()).load(url).into(imageView);
    }

}
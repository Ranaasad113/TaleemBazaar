package com.asad.taleembazar.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.asad.taleembazar.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SecondFrgamnet extends Fragment {


    public SecondFrgamnet() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.layout_registertwo,container, false);
        Toolbar toolbar = (Toolbar) getActivity().findViewById(R.id.toolbar_fragment);
        toolbar.setTitle("Register");
        return view;
    }

}

package com.asad.taleembazar.fragments;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.asad.taleembazar.R;
import com.asad.taleembazar.adpaters.RecyclerAdapterForSubmitadd;
import com.asad.taleembazar.adpaters.RecyclerAdpaterCategories;


/**
 * A simple {@link Fragment} subclass.
 */
public class RegisterFragment extends Fragment implements View.OnClickListener {
    public interface Communication {
        public void accept(int i);
    }
    private Bundle savedState = null;
    private Button btn;
    private Toolbar toolbar ;
    private Communication communication;
    private static int VALUE;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private static Context CONTEXT;
    private static String TYPE;


    public RegisterFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
            View view = inflater.inflate(R.layout.layout_for_register, container, false);
            btn = (Button) view.findViewById(R.id.next_btn_for_register);
            btn.setOnClickListener(this);
            toolbar = (Toolbar) getActivity().findViewById(R.id.toolbar_fragment);
            toolbar.setTitle("Register");
            return view;
    }
    @Override
    public void onAttach(Activity a) {
        super.onAttach(a);
        communication = (Communication) a;
    }

    @Override
    public void onClick(View v) {
        communication.accept(2);
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        SecondFrgamnet fragmentscend=new SecondFrgamnet();
        fragmentTransaction.replace(R.id.coordinatelayout, fragmentscend);
        fragmentTransaction.addToBackStack("Fragment_2");
        fragmentTransaction.commit();

    }
    public void acceptValueActivity(int value, Context context,String type)
    {   VALUE=0;
        this.VALUE=value;
        CONTEXT=context;
        TYPE=type;
    }



}

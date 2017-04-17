package com.asad.taleembazar.adpaters;

import android.content.Context;
import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.asad.taleembazar.R;
import com.asad.taleembazar.serlization.ArrayListData;
import com.asad.taleembazar.serlization.MyAccountData;

import java.util.ArrayList;

/**
 * Created by asad on 4/5/17.
 */

public class RecyclerAdpaterCategories extends RecyclerView.Adapter<RecyclerAdpaterCategories.Holder> {
    private ArrayList<String> arrayList=new ArrayList<>();
    private ArrayListData arrayListData;
    private String toSendDataSource;
    public RecyclerAdpaterCategories(String argu)
    {
        toSendDataSource=argu;
        arrayListData=new ArrayListData(argu);
        arrayList=arrayListData.getStringArrayList();
    }
    @Override
    public RecyclerAdpaterCategories.Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.categories_layout,parent,false);
        return new RecyclerAdpaterCategories.Holder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerAdpaterCategories.Holder holder, int position) {

            holder.tx.setText(arrayList.get(position));


    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }
    public static class Holder extends RecyclerView.ViewHolder
    {
        TextView tx;
        public Holder(View itemView) {
            super(itemView);
            tx=(TextView)itemView.findViewById(R.id.textview_categories);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Snackbar.make(view,"Clicked at position: "+getAdapterPosition(),Snackbar.LENGTH_LONG).show();
                }
            });

        }



    }


}

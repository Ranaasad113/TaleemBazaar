package com.asad.taleembazar.adpaters;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.asad.taleembazar.R;

import java.util.ArrayList;

import com.asad.taleembazar.serlization.MyAccountData;

/**
 * Created by asad on 3/9/17.
 */

public class RecyclerAdapterMyAccount extends RecyclerView.Adapter<RecyclerAdapterMyAccount.Holder>{
    ArrayList<MyAccountData> arrayList=new ArrayList<>();
    public RecyclerAdapterMyAccount(ArrayList<MyAccountData> arrayList)
    {
        this.arrayList=arrayList;
    }
    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_for_myaccount,parent,false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        if (arrayList.get(position).getimg()==0)
        {
            holder.tx.setText(arrayList.get(position).gettxt());
            holder.tx.setTextColor(Color.parseColor("#F44336"));
            holder.tx.setGravity(Gravity.CENTER);

        }
        else {
            holder.img.setImageResource(arrayList.get(position).getimg());
            holder.tx.setText(arrayList.get(position).gettxt());
        }
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }
    public static class Holder extends RecyclerView.ViewHolder
    { ImageView img;
        TextView tx;
        public Holder(View itemView) {
            super(itemView);
            img=(ImageView)itemView.findViewById(R.id.imageView_forcardview_list);
            tx=(TextView)itemView.findViewById(R.id.textview_for_cardview_list);
        }
    }



}


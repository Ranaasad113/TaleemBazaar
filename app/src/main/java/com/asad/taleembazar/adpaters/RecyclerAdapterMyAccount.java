package com.asad.taleembazar.adpaters;

import android.graphics.Color;
import android.support.v7.widget.CardView;
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
 *
 * Created by asad on 3/9/17.
 *
 */

public class RecyclerAdapterMyAccount extends RecyclerView.Adapter<RecyclerAdapterMyAccount.Holder>{
    ArrayList<MyAccountData> arrayList=new ArrayList<>();
    private callback Clicklistener;
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
    public void setOnClick(callback onClick)
    {
        Clicklistener=onClick;
    }
    @Override
    public int getItemCount() {
        return arrayList.size();
    }
    public  class Holder extends RecyclerView.ViewHolder implements  View.OnClickListener
    { ImageView img;
        TextView tx;
        CardView cardView;
        public Holder(View itemView) {
            super(itemView);
            img=(ImageView)itemView.findViewById(R.id.imageView_forcardview_list);
            tx=(TextView)itemView.findViewById(R.id.textview_for_cardview_list);
            cardView=(CardView)itemView.findViewById(R.id.card_view_for_my_account);
            cardView.setOnClickListener(this);
        }
        @Override
        public void onClick(View v) {
            Clicklistener.onClick(getAdapterPosition());
        }
    }



}


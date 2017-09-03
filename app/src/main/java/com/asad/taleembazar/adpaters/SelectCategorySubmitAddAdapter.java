package com.asad.taleembazar.adpaters;

import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.asad.taleembazar.R;

import java.util.ArrayList;

/**
 * Created by Rana Asad on 9/2/2017.
 */

public class SelectCategorySubmitAddAdapter extends RecyclerView.Adapter<SelectCategorySubmitAddAdapter.Holder> {
    private ArrayList<String> arrayList=new ArrayList<>();
    private callback Clicklistener;

    public SelectCategorySubmitAddAdapter(ArrayList<String> arrayList) {
        this.arrayList = arrayList;
    }

    @Override
    public SelectCategorySubmitAddAdapter.Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.categories_layout,parent,false);
        return new SelectCategorySubmitAddAdapter.Holder(view);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        holder.tx.setText(arrayList.get(position));
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
    {
        TextView tx;
        public Holder(View itemView) {
            super(itemView);
            tx=(TextView)itemView.findViewById(R.id.textview_categories);
            tx.setOnClickListener(this);

        }


        @Override
        public void onClick(View v) {
            Clicklistener.onClick(getAdapterPosition());
        }
    }

}

package com.asad.taleembazar.adpaters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.asad.taleembazar.R;

import java.util.ArrayList;

/**
 * Created by Rana Asad on 9/3/2017.
 *
 */

public class ShowAllAddsAdapter extends RecyclerView.Adapter<ShowAllAddsAdapter.Holder> {
    private ArrayList<String> arrayList=new ArrayList<>();
    private callback Clicklistener;

    public ShowAllAddsAdapter(ArrayList<String> arrayList) {
        this.arrayList = arrayList;
    }

    @Override
    public ShowAllAddsAdapter.Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.viewadds_layout,parent,false);
        return new ShowAllAddsAdapter.Holder(view);
    }

    @Override
    public void onBindViewHolder(ShowAllAddsAdapter.Holder holder, int position) {

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
        ImageView imageview;
        TextView usernametextview;
        TextView pricetextview;
        LinearLayout clickadd;

        public Holder(View itemView) {
            super(itemView);
            imageview=(ImageView)itemView.findViewById(R.id.imageview_showalladds);
            usernametextview=(TextView)itemView.findViewById(R.id.usernametextview_showallads);
            pricetextview=(TextView)itemView.findViewById(R.id.priceedittxt_submitadd);
            clickadd=(LinearLayout)itemView.findViewById(R.id.showalladslinear);


        }


        @Override
        public void onClick(View v) {
            Clicklistener.onClick(getAdapterPosition());
        }
    }

}

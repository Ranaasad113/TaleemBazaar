package com.asad.taleembazar.adpaters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.asad.taleembazar.R;
import java.util.ArrayList;

import com.asad.taleembazar.activities.SecondActivity;
import com.asad.taleembazar.activities.ThirdActivity;


/**
 * Created by asad on 3/15/17.
 */

public class RecyclerviewForHome extends RecyclerView.Adapter<RecyclerviewForHome.Holder>{

    private int i=0;
    private final int FIRSTCHECK=0;
    private  final int SECONDCHECK=1;
    private final int BOUND=9;
    private static final int NORMAL_VIEW=2312;
    private static final int FIRST_VIEW=42;
    private Context context;

    public RecyclerviewForHome(Context context)
    {
        this.context=context;


    }
    @Override
    public RecyclerviewForHome.Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=null;
            if(viewType==NORMAL_VIEW){
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.more_items_home, parent, false);

            }else if(viewType==FIRST_VIEW){
                view=LayoutInflater.from(parent.getContext()).inflate(R.layout.catagories_cardview,parent,false);
            }
        assert view!=null;
            return new RecyclerviewForHome.Holder(view,viewType);


    }

    @Override
    public void onBindViewHolder(RecyclerviewForHome.Holder holder, int position) {
        if(position<1 || position>=BOUND) return;
       if(position==1) {


        }


       }

    @Override
    public int getItemCount() {
        return BOUND;
    }

    @Override
    public int getItemViewType(int position) {
        if(position==0){
            return FIRST_VIEW;
        }else{
            return NORMAL_VIEW;
        }
    }

    public static class Holder extends RecyclerView.ViewHolder
    { ImageView img1,img2;
        TextView tx1,tx2,tx3,tx4;
        TextView tx1cat,tx2cat,tx3cat,tx4cat,tx5cat,tx6cat,tx7cat,tx8cat;
        Context con=itemView.getContext();
        Intent intent=new Intent(con,ThirdActivity.class);
        public Holder(final View itemView, int viewType) {
            super(itemView);
            if(viewType==FIRST_VIEW)
            { tx1cat=(TextView)itemView.findViewById(R.id.textview_cars);
            tx2cat=(TextView)itemView.findViewById(R.id.textview_mobile);
            tx3cat=(TextView)itemView.findViewById(R.id.textview_flats);
            tx4cat=(TextView)itemView.findViewById(R.id.textview_transport);
            tx5cat=(TextView)itemView.findViewById(R.id.textview_books);
            tx6cat=(TextView)itemView.findViewById(R.id.textview_fashion);
            tx7cat=(TextView)itemView.findViewById(R.id.textview_furniture);
            tx8cat=(TextView)itemView.findViewById(R.id.textview_electronics);
            tx1cat.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    intent.putExtra("Check","Cars");
                    con.startActivity(intent);
                }
            });
                tx2cat.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        intent.putExtra("Check","Mobiles");
                        con.startActivity(intent);
                    }
                });
                tx3cat.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        intent.putExtra("Check","Flats");
                        con.startActivity(intent);
                    }
                });
                tx4cat.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        intent.putExtra("Check","Transport");
                        con.startActivity(intent);
                    }
                });
                tx5cat.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        intent.putExtra("Check","Books");
                        con.startActivity(intent);
                    }
                });
                tx6cat.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        intent.putExtra("Check","Fashion");
                        con.startActivity(intent);
                    }
                });
                tx7cat.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        intent.putExtra("Check","Furniture");
                        con.startActivity(intent);
                    }
                });
                tx8cat.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        intent.putExtra("Check","Electronics");
                        con.startActivity(intent);
                    }
                });

                return;
            }
                img1 = (ImageView) itemView.findViewById(R.id.irst_imageview);
                img2 = (ImageView) itemView.findViewById(R.id.snd_imageview);
                tx1 = (TextView) itemView.findViewById(R.id.firstprice_textview);
                tx2 = (TextView) itemView.findViewById(R.id.scndprice_textview);
                tx3 = (TextView) itemView.findViewById(R.id.more_items);
                tx4 = (TextView) itemView.findViewById(R.id.item_name);





        }
    }
}

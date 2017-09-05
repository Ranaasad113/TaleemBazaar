package com.asad.taleembazar.adpaters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.asad.taleembazar.R;

import com.asad.taleembazar.activities.SelectCategoriesActivity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;


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
    private ArrayList<HashMap<String,String>> arrayList;
    private String url;

    public RecyclerviewForHome(Context context, ArrayList<HashMap<String,String>> myarraylist)
    {
        this.context=context;
        this.arrayList=myarraylist;


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
        if(position<1 || position>=arrayList.size())
        {
            for(int i=0;i<arrayList.size();i++)
            {
                HashMap<String,String> myhashmap=arrayList.get(i);
                if (i==0||i%2==0)
                {
                    holder.firstpricetx1.setText(myhashmap.get("adsprice"));
                    Picasso.with(context)
                            .load(myhashmap.get("adsimg1"))
                            .centerCrop()
                            .placeholder(R.drawable.uploadprofile)
                            .into(holder.firstimg1);
                }
                else
                {
                    holder.secondpricetx2.setText(myhashmap.get("adsprice"));
                    Picasso.with(context)
                            .load(myhashmap.get("adsimg1"))
                            .centerCrop()
                            .placeholder(R.drawable.uploadprofile)
                            .into(holder.secondimg2);

                }

            }


        }
       if(position==1) {


        }


       }

    @Override
    public int getItemCount() {
        return arrayList.size();
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
    { ImageView firstimg1,secondimg2;
        TextView firstpricetx1,secondpricetx2;
        TextView tx1cat,tx2cat,tx3cat,tx4cat,tx5cat,tx6cat,tx7cat,tx8cat;
        Context con=itemView.getContext();
        Intent intent=new Intent(con,SelectCategoriesActivity.class);
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
                    intent.putExtra("PictureUploadingforMAC","Cars");
                    con.startActivity(intent);
                }
            });
                tx2cat.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        intent.putExtra("PictureUploadingforMAC","Mobiles");
                        con.startActivity(intent);
                    }
                });
                tx3cat.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        intent.putExtra("PictureUploadingforMAC","Flats");
                        con.startActivity(intent);
                    }
                });
                tx4cat.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        intent.putExtra("PictureUploadingforMAC","Transport");
                        con.startActivity(intent);
                    }
                });
                tx5cat.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        intent.putExtra("PictureUploadingforMAC","Books");
                        con.startActivity(intent);
                    }
                });
                tx6cat.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        intent.putExtra("PictureUploadingforMAC","Fashion");
                        con.startActivity(intent);
                    }
                });
                tx7cat.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        intent.putExtra("PictureUploadingforMAC","Furniture");
                        con.startActivity(intent);
                    }
                });
                tx8cat.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        intent.putExtra("PictureUploadingforMAC","Electronics");
                        con.startActivity(intent);
                    }
                });

                return;
            }
                firstimg1 = (ImageView) itemView.findViewById(R.id.irst_imageview);
                secondimg2 = (ImageView) itemView.findViewById(R.id.snd_imageview);
                firstpricetx1 = (TextView) itemView.findViewById(R.id.firstprice_textview);
                secondpricetx2 = (TextView) itemView.findViewById(R.id.scndprice_textview);






        }
    }
}

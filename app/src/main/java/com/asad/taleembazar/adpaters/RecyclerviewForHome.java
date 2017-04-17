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
import com.asad.taleembazar.data.DataModelBooks;
import com.asad.taleembazar.data.DataModelCars;
import com.asad.taleembazar.data.DataModelElectronics;
import com.asad.taleembazar.data.DataModelFashion;
import com.asad.taleembazar.data.DataModelFlats;
import com.asad.taleembazar.data.DataModelFurniture;
import com.asad.taleembazar.data.DataModelMobiles;
import com.asad.taleembazar.data.DataModelTransport;
import com.asad.taleembazar.data.DataSourceBooks;
import com.asad.taleembazar.data.DataSourceCar;
import com.asad.taleembazar.data.DataSourceElectronics;
import com.asad.taleembazar.data.DataSourceFashion;
import com.asad.taleembazar.data.DataSourceFlats;
import com.asad.taleembazar.data.DataSourceFurniture;
import com.asad.taleembazar.data.DataSourceMobile;
import com.asad.taleembazar.data.DataSourceTranport;


/**
 * Created by asad on 3/15/17.
 */

public class RecyclerviewForHome extends RecyclerView.Adapter<RecyclerviewForHome.Holder>{
    private ArrayList<DataModelMobiles> arrayListMobile=new ArrayList<>();
    private DataSourceMobile dataSourceMobile;
    private DataModelMobiles[] dataModelMobiles=new DataModelMobiles[2];
    private ArrayList<DataModelCars> arrayListCars=new ArrayList<>();
    private DataSourceCar dataSourceCars;
    private DataModelCars[] dataModelCar=new DataModelCars[2];
    private ArrayList<DataModelFlats> arrayListFlats=new ArrayList<>();
    private DataSourceFlats dataSourceFlats;
    private DataModelFlats[] dataModelFlats=new DataModelFlats[2];
    private ArrayList<DataModelTransport> arrayListTransport=new ArrayList<>();
    private DataSourceTranport dataSourceTranport;
    private DataModelTransport[] dataModelTransport=new DataModelTransport[2];
    private ArrayList<DataModelBooks> arrayListBooks=new ArrayList<>();
    private DataSourceBooks dataSourceBooks;
    private DataModelBooks[] dataModelBooks=new DataModelBooks[2];
    private ArrayList<DataModelFashion> arrayListFashion=new ArrayList<>();
    private DataSourceFashion dataSourceFashion;
    private DataModelFashion[] dataModelFashion=new DataModelFashion[2];
    private ArrayList<DataModelFurniture> arrayListFurniture=new ArrayList<>();
    private DataSourceFurniture dataSourceFurniture;
    private DataModelFurniture[] dataModelFurniture=new DataModelFurniture[2];
    private ArrayList<DataModelElectronics> arrayListElectronics=new ArrayList<>();
    private DataSourceElectronics dataSourceElectronics;
    private DataModelElectronics[] dataModelElectronics=new DataModelElectronics[2];
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
        dataSourceMobile=new DataSourceMobile();
        dataSourceCars=new DataSourceCar();
        dataSourceFlats=new DataSourceFlats();
        dataSourceTranport=new DataSourceTranport();
        dataSourceBooks=new DataSourceBooks();
        dataSourceFashion=new DataSourceFashion();
        dataSourceFurniture=new DataSourceFurniture();
        dataSourceElectronics=new DataSourceElectronics();
          getArraylistDataSources();


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
           holder.img1.setImageResource(dataModelCar[FIRSTCHECK].getImageCar());
           holder.img2.setImageResource(dataModelCar[SECONDCHECK].getImageCar());
           holder.tx1.setText(dataModelCar[FIRSTCHECK].getPriceCar());
           holder.tx1.setTextColor(Color.parseColor("#E65100"));
           holder.tx2.setText(dataModelCar[SECONDCHECK].getPriceCar());
           holder.tx2.setTextColor(Color.parseColor("#E65100"));
           holder.tx4.setText("Cars");
           holder.tx4.setTypeface(null, Typeface.BOLD);
           holder.tx3.setText("More Items");
           holder.tx3.setTextColor(Color.parseColor("#2E7D32"));

        }
       else if(position==2) {
            holder.img1.setImageResource(dataModelMobiles[FIRSTCHECK].getImageMobile());
            holder.img2.setImageResource(dataModelMobiles[SECONDCHECK].getImageMobile());
            holder.tx1.setText(dataModelMobiles[FIRSTCHECK].getPriceMobile());
            holder.tx1.setTextColor(Color.parseColor("#E65100"));
            holder.tx2.setText(dataModelMobiles[SECONDCHECK].getPriceMobile());
            holder.tx2.setTextColor(Color.parseColor("#E65100"));
            holder.tx4.setText("Mobiles");
            holder.tx4.setTypeface(null, Typeface.BOLD);
            holder.tx3.setText("More Items");
            holder.tx3.setTextColor(Color.parseColor("#2E7D32"));

        }
      else  if(position==3) {
            holder.img1.setImageResource(dataModelFlats[FIRSTCHECK].getImageFlats());
            holder.img2.setImageResource(dataModelFlats[SECONDCHECK].getImageFlats());
            holder.tx1.setText(dataModelFlats[FIRSTCHECK].getPriceFlats());
            holder.tx1.setTextColor(Color.parseColor("#E65100"));
            holder.tx2.setText(dataModelFlats[SECONDCHECK].getPriceFlats());
            holder.tx2.setTextColor(Color.parseColor("#E65100"));
            holder.tx4.setText("Flats");
            holder.tx4.setTypeface(null, Typeface.BOLD);
            holder.tx3.setText("More Items");
            holder.tx3.setTextColor(Color.parseColor("#2E7D32"));

        }
       else if(position==4) {
            holder.img1.setImageResource(dataModelTransport[FIRSTCHECK].getImageTranport());
            holder.img2.setImageResource(dataModelTransport[SECONDCHECK].getImageTranport());
            holder.tx1.setText(dataModelTransport[FIRSTCHECK].getPriceTranport());
            holder.tx1.setTextColor(Color.parseColor("#E65100"));
            holder.tx2.setText(dataModelTransport[SECONDCHECK].getPriceTranport());
            holder.tx2.setTextColor(Color.parseColor("#E65100"));
            holder.tx4.setText("Transport");
            holder.tx4.setTypeface(null, Typeface.BOLD);
            holder.tx3.setText("More Items");
            holder.tx3.setTextColor(Color.parseColor("#2E7D32"));

        }
        else if(position==5) {
            holder.img1.setImageResource(dataModelBooks[FIRSTCHECK].getImageBooks());
            holder.img2.setImageResource(dataModelBooks[SECONDCHECK].getImageBooks());
            holder.tx1.setText(dataModelBooks[FIRSTCHECK].getPriceBooks());
            holder.tx1.setTextColor(Color.parseColor("#E65100"));
            holder.tx2.setText(dataModelBooks[SECONDCHECK].getPriceBooks());
            holder.tx2.setTextColor(Color.parseColor("#E65100"));
            holder.tx4.setText("Books");
            holder.tx4.setTypeface(null, Typeface.BOLD);
            holder.tx3.setText("More Items");
            holder.tx3.setTextColor(Color.parseColor("#2E7D32"));

        }
       else if(position==6) {
           holder.img1.setImageResource(dataModelFashion[FIRSTCHECK].getImageFashion());
           holder.img2.setImageResource(dataModelFashion[SECONDCHECK].getImageFashion());
           holder.tx1.setText(dataModelFashion[FIRSTCHECK].getPriceFashion());
           holder.tx1.setTextColor(Color.parseColor("#E65100"));
           holder.tx2.setText(dataModelFashion[SECONDCHECK].getPriceFashion());
           holder.tx2.setTextColor(Color.parseColor("#E65100"));
           holder.tx4.setText("Fashion");
           holder.tx4.setTypeface(null, Typeface.BOLD);
           holder.tx3.setText("More Items");
           holder.tx3.setTextColor(Color.parseColor("#2E7D32"));

       }
       else if(position==7) {
           holder.img1.setImageResource(dataModelFurniture[FIRSTCHECK].getImageFurniture());
           holder.img2.setImageResource(dataModelFurniture[SECONDCHECK].getImageFurniture());
           holder.tx1.setText(dataModelFurniture[FIRSTCHECK].getPriceFurniture());
           holder.tx1.setTextColor(Color.parseColor("#E65100"));
           holder.tx2.setText(dataModelFurniture[SECONDCHECK].getPriceFurniture());
           holder.tx2.setTextColor(Color.parseColor("#E65100"));
           holder.tx4.setText("Furniture");
           holder.tx4.setTypeface(null, Typeface.BOLD);
           holder.tx3.setText("More Items");
           holder.tx3.setTextColor(Color.parseColor("#2E7D32"));

       }
       else if(position==8) {
           holder.img1.setImageResource(dataModelElectronics[FIRSTCHECK].getImageElectronics());
           holder.img2.setImageResource(dataModelElectronics[SECONDCHECK].getImageElectronics());
           holder.tx1.setText(dataModelElectronics[FIRSTCHECK].getPriceElectronics());
           holder.tx1.setTextColor(Color.parseColor("#E65100"));
           holder.tx2.setText(dataModelElectronics[SECONDCHECK].getPriceElectronics());
           holder.tx2.setTextColor(Color.parseColor("#E65100"));
           holder.tx4.setText("Electronics");
           holder.tx4.setTypeface(null, Typeface.BOLD);
           holder.tx3.setText("More Items");
           holder.tx3.setTextColor(Color.parseColor("#2E7D32"));

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
    public void getArraylistDataSources()
    {
        arrayListMobile=dataSourceMobile.getDataModelMobilesArrayList();
        dataModelMobiles[FIRSTCHECK]=arrayListMobile.get(FIRSTCHECK);
        dataModelMobiles[SECONDCHECK]=arrayListMobile.get(SECONDCHECK);
        //
       arrayListCars=dataSourceCars.getDataModelCarsArrayList();
       dataModelCar[FIRSTCHECK]=arrayListCars.get(FIRSTCHECK);
       dataModelCar[SECONDCHECK]=arrayListCars.get(SECONDCHECK);
        //
        arrayListFlats=dataSourceFlats.getDataModelFlatsArrayList();
        dataModelFlats[FIRSTCHECK]=arrayListFlats.get(FIRSTCHECK);
        dataModelFlats[SECONDCHECK]=arrayListFlats.get(SECONDCHECK);
        //
        arrayListTransport=dataSourceTranport.getDataModelTransportArrayList();
        dataModelTransport[FIRSTCHECK]=arrayListTransport.get(FIRSTCHECK);
        dataModelTransport[SECONDCHECK]=arrayListTransport.get(SECONDCHECK);
        //
        arrayListBooks=dataSourceBooks.getDataModelBooksArrayList();
        dataModelBooks[FIRSTCHECK]=arrayListBooks.get(FIRSTCHECK);
        dataModelBooks[SECONDCHECK]=arrayListBooks.get(SECONDCHECK);
        //
        arrayListFashion=dataSourceFashion.getDataModelFashionArrayList();
        dataModelFashion[FIRSTCHECK]=arrayListFashion.get(FIRSTCHECK);
        dataModelFashion[SECONDCHECK]=arrayListFashion.get(SECONDCHECK);
        //
        arrayListFurniture=dataSourceFurniture.getDataModelFurnitureArrayList();
        dataModelFurniture[FIRSTCHECK]=arrayListFurniture.get(FIRSTCHECK);
        dataModelFurniture[SECONDCHECK]=arrayListFurniture.get(SECONDCHECK);
        //
        arrayListElectronics=dataSourceElectronics.getDataModelElectronicsArrayList();
        dataModelElectronics[FIRSTCHECK]=arrayListElectronics.get(FIRSTCHECK);
        dataModelElectronics[SECONDCHECK]=arrayListElectronics.get(SECONDCHECK);


}





}

package com.asad.taleembazar.adpaters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.asad.taleembazar.R;
import com.asad.taleembazar.activities.ClickCallback;
import com.asad.taleembazar.activities.ShowAllAddsActivity;
import com.asad.taleembazar.model.DataModelAdds;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;


/**
 * Created by asad on 3/15/17.
 */

public class RecyclerviewForHome extends RecyclerView.Adapter<RecyclerviewForHome.Holder>{

    private static final int NORMAL_VIEW = 2312;
    private static final int FIRST_VIEW = 42;
    private final int FIRSTCHECK=0;
    private  final int SECONDCHECK=1;
    private final int BOUND=9;
    private int i = 0;
    private Context context;
    private DataModelAdds dataModelAdds;
    private ClickCallback clickCallback;

    private ArrayList<DataModelAdds> arrayList;
    private String url;

    public RecyclerviewForHome(Context context, ArrayList<DataModelAdds> myarraylist, ClickCallback clickCallback)
    {
        this.context=context;
        this.arrayList=myarraylist;
        this.clickCallback = clickCallback;



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
        if (position == 0) {


        } else if (position > 0 && position <= arrayList.size()) {


            dataModelAdds = arrayList.get(position);
            holder.usernametxt.setText(dataModelAdds.getmOwnername());
            holder.firstpricetx1.setText(dataModelAdds.getmPrice() + " Rs");
            holder.secondpricetx2.setText(dataModelAdds.getmType());
            String[] data = dataModelAdds.getmImagesUrl();
            Picasso.with(context)
                    .load(data[0])
                    .into(holder.firstimg1, new Callback() {
                        @Override
                        public void onSuccess() {
                            Log.d("bullhead", "onSuccess: image ;oaded");
                        }

                        @Override
                        public void onError() {
                            Log.d("bullhead", "onError: fick me");
                        }
                    });


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

    public class Holder extends RecyclerView.ViewHolder implements View.OnClickListener {
        CircleImageView firstimg1;
        TextView firstpricetx1,secondpricetx2;
        TextView usernametxt;
        LinearLayout linearLayout;
        TextView tx1cat,tx2cat,tx3cat,tx4cat,tx5cat,tx6cat,tx7cat,tx8cat;
        Context con=itemView.getContext();
        Intent intent = new Intent(con, ShowAllAddsActivity.class);
        public Holder(final View itemView, int viewType) {
            super(itemView);

            if (viewType == FIRST_VIEW) {
                tx1cat = (TextView) itemView.findViewById(R.id.textview_cars);
                tx2cat = (TextView) itemView.findViewById(R.id.textview_mobile);
                tx3cat = (TextView) itemView.findViewById(R.id.textview_flats);
                tx4cat = (TextView) itemView.findViewById(R.id.textview_transport);
                tx5cat = (TextView) itemView.findViewById(R.id.textview_books);
                tx6cat = (TextView) itemView.findViewById(R.id.textview_fashion);
                tx7cat = (TextView) itemView.findViewById(R.id.textview_furniture);
                tx8cat = (TextView) itemView.findViewById(R.id.textview_electronics);
                tx1cat.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        intent.putExtra("Categorie", "Cars");
                        con.startActivity(intent);
                    }
                });
                tx2cat.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        intent.putExtra("Categorie", "Mobiles");
                        con.startActivity(intent);
                    }
                });
                tx3cat.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        intent.putExtra("Categorie", "Flats");
                        con.startActivity(intent);
                    }
                });
                tx4cat.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        intent.putExtra("Categorie", "Transport");
                        con.startActivity(intent);
                    }
                });
                tx5cat.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        intent.putExtra("Categorie", "Books");
                        con.startActivity(intent);
                    }
                });
                tx6cat.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        intent.putExtra("Categorie", "Fashion");
                        con.startActivity(intent);
                    }
                });
                tx7cat.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        intent.putExtra("Categorie", "Furniture");
                        con.startActivity(intent);
                    }
                });
                tx8cat.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        intent.putExtra("Categorie", "Electronics");
                        con.startActivity(intent);
                    }
                });

                return;
            } else if (viewType == NORMAL_VIEW) {
                firstimg1 = (CircleImageView) itemView.findViewById(R.id.irstimageview);
                usernametxt = (TextView) itemView.findViewById(R.id.firstusertextview);
                firstpricetx1 = (TextView) itemView.findViewById(R.id.firstpricetextview);
                secondpricetx2 = (TextView) itemView.findViewById(R.id.scndpricetextview);
                linearLayout = (LinearLayout) itemView.findViewById(R.id.hotadds_layout);
                linearLayout.setOnClickListener(this);

                return;
            }


        }

        @Override
        public void onClick(View v) {
            clickCallback.takeValue(arrayList.get(getAdapterPosition()));
        }
    }
}

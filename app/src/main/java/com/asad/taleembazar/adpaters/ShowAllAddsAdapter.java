package com.asad.taleembazar.adpaters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.asad.taleembazar.R;
import com.asad.taleembazar.activities.ClickCallback;
import com.asad.taleembazar.model.DataModelAdds;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Rana Asad on 9/3/2017.
 *
 */

public class ShowAllAddsAdapter extends RecyclerView.Adapter<ShowAllAddsAdapter.Holder> {
    private ArrayList<DataModelAdds> arrayList = new ArrayList<>();
    private ClickCallback clicklistener;
    private Context context;
    private DataModelAdds dataModelAdds;

    public ShowAllAddsAdapter(Context context, ArrayList<DataModelAdds> arrayList, ClickCallback clickCallback) {
        this.arrayList = arrayList;
        this.context = context;
        this.clicklistener = clickCallback;
    }

    @Override
    public ShowAllAddsAdapter.Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.viewadds_layout,parent,false);
        return new ShowAllAddsAdapter.Holder(view);
    }

    @Override
    public void onBindViewHolder(ShowAllAddsAdapter.Holder holder, int position) {


        dataModelAdds = arrayList.get(position);
        holder.usernametextview.setText(dataModelAdds.getmOwnername());
        holder.pricetextview.setText(dataModelAdds.getmPrice() + " Rs");
        Picasso.with(context)
                .load(dataModelAdds.getmImagesUrl()[0])
                .fit()
                .placeholder(R.drawable.uploadprofile)
                .into(holder.imageview);


    }


    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class Holder extends RecyclerView.ViewHolder implements View.OnClickListener {
        CircleImageView imageview;
        TextView usernametextview;
        TextView pricetextview;
        LinearLayout clickadd;

        public Holder(final View itemView) {
            super(itemView);
            imageview = (CircleImageView) itemView.findViewById(R.id.imageviewadds);
            usernametextview = (TextView) itemView.findViewById(R.id.usernameallads);
            pricetextview = (TextView) itemView.findViewById(R.id.pricealladds);
            clickadd = (LinearLayout) itemView.findViewById(R.id.showalladslinear);
            clickadd.setOnClickListener(this);


        }


        @Override
        public void onClick(View v) {
            clicklistener.takeValue(arrayList.get(getAdapterPosition()));
        }
    }

}

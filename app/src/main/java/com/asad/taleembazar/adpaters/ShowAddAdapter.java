package com.asad.taleembazar.adpaters;

import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.asad.taleembazar.R;
import com.asad.taleembazar.model.DataModelAdds;

/**
 * Created by Rana Asad on 9/5/2017.
 */

public class ShowAddAdapter extends RecyclerView.Adapter<ShowAddAdapter.Holder> {

    private DataModelAdds dataModelAdds;

    public ShowAddAdapter(DataModelAdds dataModelAdds) {
        this.dataModelAdds = dataModelAdds;

    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.addview_layout, parent, false);
        return new ShowAddAdapter.Holder(view);
    }

    @Override
    public void onBindViewHolder(ShowAddAdapter.Holder holder, int position) {
        if (position == 0) {
            holder.titlewrite.setText(dataModelAdds.getmTitle());
            holder.descriptionwrite.setText(dataModelAdds.getmDescription());

        } else if (position == 1) {
            holder.title.setText(dataModelAdds.getmOwnername());
            holder.title.setTextSize(17);
            holder.title.setTypeface(null, Typeface.NORMAL);
            holder.titlewrite.setText(dataModelAdds.getmLocation());
            holder.titlewrite.setTextSize(17);
            holder.titlewrite.setTypeface(null, Typeface.NORMAL);
            holder.description.setText(dataModelAdds.getmPrice() + " Rs");
            holder.description.setTextSize(17);
            holder.description.setTypeface(null, Typeface.NORMAL);
            holder.descriptionwrite.setText(dataModelAdds.getmMobilenum());
            holder.descriptionwrite.setTextSize(17);
            holder.descriptionwrite.setTypeface(null, Typeface.NORMAL);
        }

    }

    @Override
    public int getItemCount() {
        return 2;
    }


    public class Holder extends RecyclerView.ViewHolder {
        TextView title;
        TextView titlewrite;
        TextView description;
        TextView descriptionwrite;

        public Holder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.titleaddtextview);
            titlewrite = (TextView) itemView.findViewById(R.id.titlewritetextview);
            description = (TextView) itemView.findViewById(R.id.descriptionaddtextview);
            descriptionwrite = (TextView) itemView.findViewById(R.id.descrpitionwritetextview);
            return;

        }

    }

}

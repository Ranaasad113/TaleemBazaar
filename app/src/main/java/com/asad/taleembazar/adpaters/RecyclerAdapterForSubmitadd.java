package com.asad.taleembazar.adpaters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.asad.taleembazar.R;

/**
 * Created by asad on 3/24/17.
 */

public class RecyclerAdapterForSubmitadd extends RecyclerView.Adapter<RecyclerAdapterForSubmitadd.Holder>{
    private int i=0;
    private static final int SECOND_VIEW=43;
    private static final int FIRST_VIEW=42;
    private static final int THIRD_VIEW=44;
    private static final int FORTH_VIEW=45;

    public RecyclerAdapterForSubmitadd()
    {

    }
    @Override
    public RecyclerAdapterForSubmitadd.Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=null;
        if(viewType==SECOND_VIEW){
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_choose_category_submitadds, parent, false);

        }else if(viewType==FIRST_VIEW){
            view=LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_for_images_for_adds,parent,false);
        }
        else if(viewType==THIRD_VIEW){
            view=LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_title_decription,parent,false);
        }
        else if(viewType==FORTH_VIEW){
            view=LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_for_campus_of_uni,parent,false);
        }
        assert view!=null;
        return new RecyclerAdapterForSubmitadd.Holder(view,viewType);


    }

    @Override
    public void onBindViewHolder(RecyclerAdapterForSubmitadd.Holder holder, int position) {
        if(position<1 || position>=4) return;



    }
    @Override
    public int getItemCount() {
        return 4;
    }

    @Override
    public int getItemViewType(int position) {
        if(position==0){
            return FIRST_VIEW;
        }
        else if (position==1)
        {
            return SECOND_VIEW;
        }
        else if (position==2)
        {
            return THIRD_VIEW;
        }
        else
            return FORTH_VIEW;

    }

    public static class Holder extends RecyclerView.ViewHolder
    {

        public Holder(View itemView,int viewType) {
            super(itemView);
            if(viewType==FIRST_VIEW) return;
            if(viewType==SECOND_VIEW) return;
            if(viewType==THIRD_VIEW) return;
            if(viewType==FORTH_VIEW) return;


        }
    }


}

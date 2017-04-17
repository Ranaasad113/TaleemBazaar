package com.asad.taleembazar.data;

import com.asad.taleembazar.R;

import java.util.ArrayList;

/**
 * Created by asad on 4/4/17.
 */

public class DataSourceMobile {
    private ArrayList<DataModelMobiles> dataModelMobilesArrayList=new ArrayList<>();
    private int imageid= R.drawable.uploadprofile;
    public DataSourceMobile() {
        setDataModelMobilesArrayList();

    }



    public DataModelMobiles getDataModelMobilesInstance(int position) {
        return dataModelMobilesArrayList.get(position);
    }

    public void setDataModelMobilesArrayList() {
        for(int i=0;i<3;i++)
        dataModelMobilesArrayList.add(new DataModelMobiles("Qmobile","15000","A600","jakajakajak",imageid));

    }
    public ArrayList<DataModelMobiles> getDataModelMobilesArrayList()
    {
        return dataModelMobilesArrayList;
    }
}

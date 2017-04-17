package com.asad.taleembazar.data;

import com.asad.taleembazar.R;

import java.util.ArrayList;

/**
 * Created by asad on 4/5/17.
 */

public class DataSourceFashion {
    private ArrayList<DataModelFashion> dataModelFashionArrayList=new ArrayList<>();
    private int image1= R.drawable.uploadprofile;
    public DataSourceFashion() {
        setDataModelFashionArrayList();
    }
    public DataModelFashion getDataModelFashionInstance(int position) {
        return dataModelFashionArrayList.get(position);
    }

    public void setDataModelFashionArrayList() {
        for(int i=0;i<3;i++)
            dataModelFashionArrayList.add(new DataModelFashion(image1,"Pent Shirt","Rs 2000","Very Good Condition"));

    }
    public ArrayList<DataModelFashion> getDataModelFashionArrayList()
    {
        return dataModelFashionArrayList;
    }
}

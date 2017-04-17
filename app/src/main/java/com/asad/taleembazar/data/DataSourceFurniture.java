package com.asad.taleembazar.data;

import com.asad.taleembazar.R;

import java.util.ArrayList;

/**
 * Created by asad on 4/5/17.
 */

public class DataSourceFurniture {
    private ArrayList<DataModelFurniture> dataModelFurnitureArrayList=new ArrayList<>();
    private int image1= R.drawable.uploadprofile;
    public DataSourceFurniture() {
        setDataModelFurnitureArrayList();
    }
    public DataModelFurniture getDataModelFurnitureInstance(int position) {
        return dataModelFurnitureArrayList.get(position);
    }

    public void setDataModelFurnitureArrayList() {
        for(int i=0;i<3;i++)
            dataModelFurnitureArrayList.add(new DataModelFurniture(image1,"Bed","Rs 200000","Very Good Condition"));

    }
    public ArrayList<DataModelFurniture> getDataModelFurnitureArrayList()
    {
        return dataModelFurnitureArrayList;
    }
}

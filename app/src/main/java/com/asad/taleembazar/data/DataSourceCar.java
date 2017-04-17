package com.asad.taleembazar.data;

import com.asad.taleembazar.R;

import java.util.ArrayList;

/**
 * Created by asad on 4/5/17.
 */

public class DataSourceCar {
    private ArrayList<DataModelCars> dataModelCarArrayList=new ArrayList<>();
    private int image1=R.drawable.uploadprofile;
    public DataSourceCar() {
        setDataModelCarsArrayList();
    }
    public DataModelCars getDataModelCarsInstance(int position) {
        return dataModelCarArrayList.get(position);
    }

    public void setDataModelCarsArrayList() {
        for(int i=0;i<3;i++)
            dataModelCarArrayList.add(new DataModelCars(image1,"Mehran","Rs 200000","Suzuki","1993","Yes","Very Good Condition","20 KM/H"));

    }
    public ArrayList<DataModelCars> getDataModelCarsArrayList()
    {
        return dataModelCarArrayList;
    }
}

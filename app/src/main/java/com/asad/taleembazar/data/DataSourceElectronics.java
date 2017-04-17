package com.asad.taleembazar.data;

import com.asad.taleembazar.R;

import java.util.ArrayList;

/**
 * Created by asad on 4/5/17.
 */

public class DataSourceElectronics {
    private ArrayList<DataModelElectronics> dataModelElectronicsArrayList=new ArrayList<>();
    private int image1= R.drawable.uploadprofile;
    public DataSourceElectronics() {
        setDataModelElectronicsArrayList();
    }
    public DataModelElectronics getDataModelElectronicsInstance(int position) {
        return dataModelElectronicsArrayList.get(position);
    }

    public void setDataModelElectronicsArrayList() {
        for(int i=0;i<3;i++)
            dataModelElectronicsArrayList.add(new DataModelElectronics(image1,"Oven","Rs 2000","Very Good Condition"));

    }
    public ArrayList<DataModelElectronics> getDataModelElectronicsArrayList()
    {
        return dataModelElectronicsArrayList;
    }
}

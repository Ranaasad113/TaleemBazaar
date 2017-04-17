package com.asad.taleembazar.data;

import com.asad.taleembazar.R;

import java.util.ArrayList;

/**
 * Created by asad on 4/5/17.
 */

public class DataSourceFlats {
    private ArrayList<DataModelFlats> dataModelFlatsArrayList=new ArrayList<>();
    private int image1= R.drawable.uploadprofile;
    public DataSourceFlats() {
        setDataModelFlatsArrayList();
    }
    public DataModelFlats getDataModelFlatsInstance(int position) {
        return dataModelFlatsArrayList.get(position);
    }

    public void setDataModelFlatsArrayList() {
        for(int i=0;i<3;i++)
            dataModelFlatsArrayList.add(new DataModelFlats(image1,"Flats 2 Rooms","2 Rooms with Washroom Attach","Rs 70000/month","Hassan Chowk Gujrat"));

    }
    public ArrayList<DataModelFlats> getDataModelFlatsArrayList()
    {
        return dataModelFlatsArrayList;
    }
}

package com.asad.taleembazar.data;

import com.asad.taleembazar.R;

import java.util.ArrayList;

/**
 * Created by asad on 4/5/17.
 */

public class DataSourceBooks {
    private ArrayList<DataModelBooks> dataModelBooksArrayList=new ArrayList<>();
    private int image1= R.drawable.uploadprofile;
    public DataSourceBooks() {
        setDataModelBooksArrayList();
    }
    public DataModelBooks getDataModelBooksInstance(int position) {
        return dataModelBooksArrayList.get(position);
    }

    public void setDataModelBooksArrayList() {
        for(int i=0;i<3;i++)
            dataModelBooksArrayList.add(new DataModelBooks(image1,"Basic Electronics","Rs 200","Very Good Condition"));

    }
    public ArrayList<DataModelBooks> getDataModelBooksArrayList()
    {
        return dataModelBooksArrayList;
    }
}

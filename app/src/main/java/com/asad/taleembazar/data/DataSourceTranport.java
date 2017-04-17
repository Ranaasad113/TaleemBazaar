package com.asad.taleembazar.data;

import com.asad.taleembazar.R;

import java.util.ArrayList;

/**
 * Created by asad on 4/5/17.
 */

public class DataSourceTranport {
    private ArrayList<DataModelTransport> dataModelTransportArrayList=new ArrayList<>();
    private int image1= R.drawable.uploadprofile;
    public DataSourceTranport() {
        setDataModelTransportArrayList();
    }
    public DataModelTransport getDataModelTransportInstance(int position) {
        return dataModelTransportArrayList.get(position);
    }

    public void setDataModelTransportArrayList() {
        for(int i=0;i<3;i++)
            dataModelTransportArrayList.add(new DataModelTransport(image1,"Transport","From Gujranwala To Gujrat Marghzar Campus","Rs 3000/month"));

    }
    public ArrayList<DataModelTransport> getDataModelTransportArrayList()
    {
        return dataModelTransportArrayList;
    }
}

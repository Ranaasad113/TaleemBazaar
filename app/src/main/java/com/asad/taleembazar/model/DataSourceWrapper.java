package com.asad.taleembazar.model;

import com.asad.taleembazar.CommonConstant;
import com.asad.taleembazar.model.DataSource;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * Created by asad on 5/18/17.
 *
 */

public class DataSourceWrapper {
    private static HashMap<String,DataSource> datasorces=new HashMap<>();
    private static DataSource datasource;
    public static void  initDatasources(ArrayList<String> category)
    {
        for (String cat:category)
        {
            DataSource temp=new DataSource();
            temp.fillData(CommonConstant.URL+"?type="+cat,cat);
            datasorces.put(cat,temp);

        }
    }

    public DataSource getAddsDataSource(String Category)
    {
        DataSource dataSource=datasorces.get(Category);
        return dataSource;
    }

}

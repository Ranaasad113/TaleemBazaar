package com.asad.taleembazar.data;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Created by asad on 5/18/17.
 */

public class JsonParsing {
    private String buildjson="{\"type\":\"car\",\"title\":\"fuckfuck\",\"description\":\"motherfucker\",\"price\":\"130\"," +
            "\"properties\":[\"company\":\"honda\",\"model\":\"1925\"]}";
    private static final String TAG_TYPE="type";
    private static  final String TAG_TITLE="title";
    private static final String TAG_DESCRIPTION="description";
    private static final String TAG_PRICE="price";
    private static final String TAG_PROPERTIES="properties";
    private String mtype;
    private String mtitle;
    private String mdescription;
    private String mprice;
    private HashMap<String,String> myhashmap=new HashMap<>();
    public void jsonParse(String query)
    {
        try {
            ConnectionHandler connectionHandler = new ConnectionHandler();
            String json = connectionHandler.getJsonfromUrl(query);
            JSONObject jsonObject = new JSONObject(json);
             mtype=jsonObject.getString(TAG_TYPE);
             mtitle=jsonObject.getString(TAG_TITLE);
             mdescription=jsonObject.getString(TAG_DESCRIPTION);
             mprice=jsonObject.getString(TAG_PRICE);
            JSONArray jsonArray=jsonObject.getJSONArray(TAG_PROPERTIES);
            for(int i=0;i<jsonArray.length();i++)
            {
                JSONObject object=jsonArray.getJSONObject(i);
                Iterator keysToCopyIterator = object.keys();
                while (keysToCopyIterator.hasNext())
                {
                    String key=keysToCopyIterator.next().toString();
                    String value=object.getString(key);
                    myhashmap.put(key,value);

                }
            }

        }
        catch (Exception e)
        {}
    }
    public String getMtype() {
        return mtype;
    }

    public String getMtitle() {
        return mtitle;
    }

    public String getMdescription() {
        return mdescription;
    }

    public String getMprice() {
        return mprice;
    }

    public HashMap<String, String> getMyhashmap() {
        return myhashmap;
    }

    public ArrayList<String> getAdIdentifiers(String particularType){
        String json=ConnectionHandler.getJsonfromUrl(particularType);

    }

}

package com.asad.taleembazar.parsing;

import com.asad.taleembazar.model.DataModel;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 *
 * Created by asad on 5/18/17.
 *
 */

public class JsonParsing {
  /*  private String buildjson="{\"type\":\"car\",\"title\":\"fuckfuck\",\"description\":\"motherfucker\",\"price\":\"130\"," +
            "\"properties\":[\"company\":\"honda\",\"model\":\"1925\"]}";*/
    private static final String TAG_IMAGE_URL="img";
    private static final String TAG_TYPE="type";
    private static  final String TAG_TITLE="title";
    private static final String TAG_DESCRIPTION="description";
    private static final String TAG_PRICE="price";
    private static final String TAG_PROPERTIES="properties";
    private HashMap<String,String> myhashmap=new HashMap<>();
    private DataModel mDataModel;
    public DataModel parseAdJson(String json) throws Exception
    {
            JSONObject jsonObject = new JSONObject(json);
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
         return mDataModel=new DataModel(jsonObject.getString(TAG_IMAGE_URL),jsonObject.getString(TAG_TYPE)
                 ,jsonObject.getString(TAG_TITLE), jsonObject.getString(TAG_DESCRIPTION),
                 jsonObject.getString(TAG_PRICE),myhashmap);

    }

    public HashMap<String, String> getMyhashmap() {
        return myhashmap;
    }
        public ArrayList<String> idsParser(String json) throws Exception
        {
            ArrayList<String> arrayList=new ArrayList<>();
            JSONArray jsonArray=new JSONArray(json);
            for (int i=0;i<jsonArray.length();i++)
            {

                JSONObject jsonObject=jsonArray.getJSONObject(i);
                String id=jsonObject.getString("id");
                arrayList.add(id);

            }
            return arrayList;
        }
    }



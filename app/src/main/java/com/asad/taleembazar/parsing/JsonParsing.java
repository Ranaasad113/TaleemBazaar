package com.asad.taleembazar.parsing;

import com.asad.taleembazar.model.DataModelAdds;
import com.asad.taleembazar.model.DataModelUser;

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
    private static final String TAG_USER_IMAGE_URL="img";
    private static final String TAG_USERNAME="username";
    private static final String TAG_PHONE_NO="phoneno";
    private static  final String TAG_PASSWORD="password";
    private HashMap<String,String> myhashmap=new HashMap<>();
    private DataModelAdds mDataModelAdds;
    private DataModelUser mDataModelUser;
    public DataModelAdds parseAdJson(String json) throws Exception
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
         return mDataModelAdds =new DataModelAdds(jsonObject.getString(TAG_IMAGE_URL),jsonObject.getString(TAG_TYPE)
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
        public DataModelUser parseUserjson(String json) throws  Exception
        {
            JSONObject jsonObj=new JSONObject(json);
           return mDataModelUser=new DataModelUser(jsonObj.getString(TAG_USERNAME),jsonObj.getString(TAG_USER_IMAGE_URL),jsonObj.getString(TAG_PASSWORD),jsonObj.getString(TAG_PHONE_NO));

        }
    }



package com.asad.taleembazar.data;

import android.util.Log;

import java.util.ArrayList;

/**
 *
 * Created by asad on 5/18/17.
 *
 */

public class ServerHandler {
    private String mJson;
    private static final String TAG=ServerHandler.class.getCanonicalName();
    private JsonParsing mJsonParsing=new JsonParsing();
    public DataModel addsUrl(String query) throws Exception
    {
        DataModel dataModel;
        mJson=ConnectionHandler.getJsonfromUrl(query);
        Log.d(TAG, "addsUrl: json is: "+mJson);
        dataModel=mJsonParsing.parseAdJson(mJson);
        return dataModel;
    }
    public ArrayList<String> idsUrl(String query) throws Exception
    {
        ArrayList<String> ids;
        mJson=ConnectionHandler.getJsonfromUrl(query);
        Log.d(TAG, "idsUrl: Json is: "+mJson);
        ids=mJsonParsing.idsParser(mJson);
        return ids;
    }
}

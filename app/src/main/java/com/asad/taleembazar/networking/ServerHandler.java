package com.asad.taleembazar.networking;

import android.util.Log;

import com.asad.taleembazar.model.DataModelAdds;
import com.asad.taleembazar.model.DataModelUser;
import com.asad.taleembazar.parsing.JsonParsing;

import java.util.ArrayList;

/**
 *
 * Created by asad on 5/18/17.
 *
 */

public class ServerHandler {
    private String mJson;
    private String mJsonuser;
    private static final String TAG=ServerHandler.class.getCanonicalName();
    private JsonParsing mJsonParsing=new JsonParsing();
    public DataModelAdds addsUrl(String query) throws Exception
    {
        DataModelAdds dataModelAdds;
        mJson=ConnectionHandler.getJsonfromUrl(query);
        Log.d(TAG, "addsUrl: json is: "+mJson);
        dataModelAdds =mJsonParsing.parseAdJson(mJson);
        return dataModelAdds;
    }
    public DataModelUser userUrl(String query) throws Exception
    {
        DataModelUser dataModelUser=null;
        mJsonuser=ConnectionHandler.getJsonfromUrl(query);
        return dataModelUser;

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

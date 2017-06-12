package com.asad.taleembazar.model;

import android.os.AsyncTask;
import android.util.Log;

import com.asad.taleembazar.networking.ServerHandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Created by asad on 5/18/17.
 *
 */

public class DataSource {
    private HashMap<String,ArrayList<DataModelAdds>> myHashmap=new HashMap<>();
    private DataModelUser mdataModelUser;

    public void fillData(final String query,final String catagory){

        class FillTask extends AsyncTask<Void,Void,Boolean>{

            @Override
            protected Boolean doInBackground(Void... params) {
               ServerHandler serverHandler=new ServerHandler();
                DataModelAdds dataModelAdds;
                ArrayList<String> ids;
                try {
                    ids=serverHandler.idsUrl(query);
                    ArrayList<DataModelAdds> arrayList=new ArrayList<>();
                    for (int i = 0; i <ids.size();i++) {
                        Log.d(catagory, "doInBackground: url is: "+query+"&id="+ids.get(i));
                        dataModelAdds = serverHandler.addsUrl(query +"&id="+ ids.get(i));
                        arrayList.add(dataModelAdds);
                    }
                    myHashmap.put(catagory,arrayList);
                    return true;
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                    return false;
                }
            }

            @Override
            protected void onPostExecute(Boolean aBoolean) {
                Iterator<String> iterator=myHashmap.keySet().iterator();
                while (iterator.hasNext()){
                    String key=iterator.next();
                    Log.d(key, "onPostExecute: "+myHashmap.get(key).size());
                }
            }
        }
            new FillTask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
    }
    public void getUserData(final String query)
    {
        class UseData extends AsyncTask<Void,Void,Boolean> {
            @Override
            protected Boolean doInBackground(Void... params) {
                ServerHandler serverHandler=new ServerHandler();
                try {
                    mdataModelUser=serverHandler.userUrl(query);
                }
                catch (Exception ex)
                {
                    ex.printStackTrace();
                    return false;
                }
                return null;
            }
        }
        new UseData().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
        }
    public HashMap<String,ArrayList<DataModelAdds>> getDataModels()
    {
        return myHashmap;
    }
    public DataModelUser getDatamodeluser()
    {
        return mdataModelUser;
    }

    }


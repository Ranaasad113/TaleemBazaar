package com.asad.taleembazar.data;

import android.os.AsyncTask;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by asad on 5/18/17.
 *
 */

public class DataSource {
    private HashMap<String,ArrayList<DataModel>> myHashmap=new HashMap<>();

    public void fillData(final String query){

        class FillTask extends AsyncTask<Void,Void,Boolean>{

            @Override
            protected Boolean doInBackground(Void... params) {
                JsonParsing parsing=new JsonParsing();
                parsing.jsonParse(query);

            }
        }

    }
}

package com.asad.taleembazar.data;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by asad on 5/18/17.
 */

public class DataModel {
    private String mType;
    private String mTitle;
    private String mPrice;
    private String mDescription;
    private HashMap<String,String> mProperties=new HashMap<>();

    public DataModel(String mType, String mTitle, String mPrice, String mDescription, HashMap<String,String> mProperties) {
        this.mType = mType;
        this.mTitle = mTitle;
        this.mPrice = mPrice;
        this.mDescription = mDescription;
        this.mProperties = mProperties;
    }

    public String getmType() {
        return mType;
    }

    public String getmTitle() {
        return mTitle;
    }

    public String getmPrice() {
        return mPrice;
    }

    public String getmDescription() {
        return mDescription;
    }

    public HashMap<String, String> getmProperties() {
        return mProperties;
    }
}

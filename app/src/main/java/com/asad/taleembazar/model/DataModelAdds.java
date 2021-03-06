package com.asad.taleembazar.model;

/**
 *
 * Created by asad on 5/18/17.
 *
 */

public class DataModelAdds {
    private String mType;
    private String mTitle;
    private String mPrice;
    private String mDescription;
    private String[] mImagesUrl=new String[4];
    private String mOwnername;
    private String mLocation;
    private String mMobilenum;


    public DataModelAdds(String[] mImagesUrl, String ownername, String mType, String mTitle,
                         String mPrice, String mDescription, String location, String mobilenum) {
        this.mImagesUrl=mImagesUrl;
        this.mOwnername=ownername;
        this.mType = mType;
        this.mTitle = mTitle;
        this.mPrice = mPrice;
        this.mMobilenum = mobilenum;

        this.mLocation = location;
        this.mDescription = mDescription;

    }

    public String getmOwnername() {
        return mOwnername;
    }

    public String getmLocation() {
        return mLocation;
    }

    public String getmMobilenum() {
        return mMobilenum;
    }
    public String[] getmImagesUrl() {
        return mImagesUrl;
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


}

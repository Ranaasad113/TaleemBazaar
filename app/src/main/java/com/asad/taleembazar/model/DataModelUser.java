package com.asad.taleembazar.model;

/**
 *
 * Created by asad on 6/12/17.
 *
 */

public class DataModelUser {
    private String mUsername;
    private String mProfileimgurl;
    private String mPassword;
    private String mContactno;

    public DataModelUser(String mUsername, String mProfileimgurl, String mPassword, String mContactno) {
        this.mUsername = mUsername;
        this.mProfileimgurl = mProfileimgurl;
        this.mPassword = mPassword;
        this.mContactno = mContactno;
    }

    public String getmUsername() {
        return mUsername;
    }

    public String getmProfileimgurl() {
        return mProfileimgurl;
    }

    public String getmPassword() {
        return mPassword;
    }

    public String getmContactno() {
        return mContactno;
    }
}

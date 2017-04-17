package com.asad.taleembazar.serlization;

/**
 * Created by asad on 3/9/17.
 */

public class MyAccountData {
    private int img;
    private String txt;
    public MyAccountData(int imgs,String txt1)
    {
        setimage(imgs);
        settxxt(txt1);

    }
    public void  setimage(int img)
    {
        this.img=img;

    }
    public void settxxt(String txt)
    {
        this.txt=txt;

    }
    public int getimg()
    {
        return img;
    }
    public String gettxt()
    {
        return txt;
    }


}

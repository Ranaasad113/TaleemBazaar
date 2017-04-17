package com.asad.taleembazar.data;

/**
 * Created by asad on 4/5/17.
 */

public class DataModelTransport {
    private int imageTranport;
    private String titleTranport;
    private String descriptionTranport;
    private String priceTranport;

    public DataModelTransport(int imageTranport, String titleTranport, String descriptionTranport, String priceTranport) {
        setImageTranport(imageTranport);
        setTitleTranport(titleTranport);
        setDescriptionTranport(descriptionTranport);
        setPriceTranport(priceTranport);
    }

    public int getImageTranport() {

        return imageTranport;
    }

    public void setImageTranport(int imageTranport) {
        this.imageTranport = imageTranport;
    }

    public String getTitleTranport() {
        return titleTranport;
    }

    public void setTitleTranport(String titleTranport) {
        this.titleTranport = titleTranport;
    }

    public String getDescriptionTranport() {
        return descriptionTranport;
    }

    public void setDescriptionTranport(String descriptionTranport) {
        this.descriptionTranport = descriptionTranport;
    }

    public String getPriceTranport() {
        return priceTranport;
    }

    public void setPriceTranport(String rupeesTranport) {
        this.priceTranport = rupeesTranport;
    }
}
package com.asad.taleembazar.data;

/**
 * Created by asad on 4/5/17.
 */

public class DataModelFurniture {
    private int imageFurniture;
    private String titleFurniture;
    private String priceFurniture;
    private String descriptionFurniture;

    public DataModelFurniture(int imageFurniture, String titleFurniture, String priceFurniture, String descriptionFurniture) {
       setImageFurniture(imageFurniture);
        setTitleFurniture(titleFurniture);
        setPriceFurniture(priceFurniture);
        setDescriptionFurniture(descriptionFurniture);
    }

    public int getImageFurniture() {
        return imageFurniture;
    }

    public void setImageFurniture(int imageFurniture) {
        this.imageFurniture = imageFurniture;
    }

    public String getTitleFurniture() {
        return titleFurniture;
    }

    public void setTitleFurniture(String titleFurniture) {
        this.titleFurniture = titleFurniture;
    }

    public String getPriceFurniture() {
        return priceFurniture;
    }

    public void setPriceFurniture(String priceFurniture) {
        this.priceFurniture = priceFurniture;
    }

    public String getDescriptionFurniture() {
        return descriptionFurniture;
    }

    public void setDescriptionFurniture(String descriptionFurniture) {
        this.descriptionFurniture = descriptionFurniture;
    }
}

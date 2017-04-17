package com.asad.taleembazar.data;

/**
 * Created by asad on 4/5/17.
 */

public class DataModelFashion {
    private int imageFashion;
    private String titleFashion;
    private String priceFashion;
    private String descriptionFashion;

    public DataModelFashion(int imageFashion, String titleFashion, String priceFashion, String descriptionFashion) {
     setImageFashion(imageFashion);
        setTitleFashion(titleFashion);
        setPriceFashion(priceFashion);
        setDescriptionFashion(descriptionFashion);
    }

    public int getImageFashion() {
        return imageFashion;
    }

    public void setImageFashion(int imageFashion) {
        this.imageFashion = imageFashion;
    }

    public String getTitleFashion() {
        return titleFashion;
    }

    public void setTitleFashion(String titleFashion) {
        this.titleFashion = titleFashion;
    }

    public String getPriceFashion() {
        return priceFashion;
    }

    public void setPriceFashion(String priceFashion) {
        this.priceFashion = priceFashion;
    }

    public String getDescriptionFashion() {
        return descriptionFashion;
    }

    public void setDescriptionFashion(String descriptionFashion) {
        this.descriptionFashion = descriptionFashion;
    }
}

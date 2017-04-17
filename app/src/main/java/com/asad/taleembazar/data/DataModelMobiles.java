package com.asad.taleembazar.data;

/**
 * Created by asad on 4/4/17.
 */

public class DataModelMobiles {
    private int imageMobile;
    private String titleMobile;
    private String priceMobile;
    private String brandMobile;
    private String descriptionMobile;

    public DataModelMobiles(String titleMobile, String PriceMobile, String brandMobile, String descriptionMobile,int imageMobile) {
        setImageMobile(imageMobile);
        setBrandMobile(brandMobile);
        setDescriptionMobile(descriptionMobile);
        setPriceMobile(PriceMobile);
        setTitleMobile(titleMobile);
    }

    public String getTitleMobile() {
        return titleMobile;
    }

    public void setTitleMobile(String titleMobile) {
        this.titleMobile = titleMobile;
    }

    public String getPriceMobile() {
        return priceMobile;
    }

    public void setPriceMobile(String rupeesMobile) {
        this.priceMobile = rupeesMobile;
    }

    public String getBrandMobile() {
        return brandMobile;
    }

    public void setBrandMobile(String brandMobile) {
        this.brandMobile = brandMobile;
    }

    public String getDescriptionMobile() {
        return descriptionMobile;
    }

    public void setDescriptionMobile(String descriptionMobile) {
        this.descriptionMobile = descriptionMobile;
    }
    public int getImageMobile() {
        return imageMobile;
    }

    public void setImageMobile(int imageMobile) {
        this.imageMobile = imageMobile;
    }
}

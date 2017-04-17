package com.asad.taleembazar.data;

/**
 * Created by asad on 4/5/17.
 */

public class DataModelFlats {
    private int imageId;
    private String titileFlats;
    private String descriptionFlats;
    private String priceFlats;
    private String locationFlats;

    public DataModelFlats(int imageId, String titileFlats, String descriptionFlats, String priceFlats, String locationFlats) {
        setImageFlats(imageId);
        setTitileFlats(titileFlats);
        setDescriptionFlats(descriptionFlats);
        setPriceFlats(priceFlats);
        setLocationFlats(locationFlats);
    }

    public int getImageFlats() {
        return imageId;
    }

    public void setImageFlats(int imageId) {
        this.imageId = imageId;
    }

    public String getTitileFlats() {
        return titileFlats;
    }

    public void setTitileFlats(String titileFlats) {
        this.titileFlats = titileFlats;
    }

    public String getDescriptionFlats() {
        return descriptionFlats;
    }

    public void setDescriptionFlats(String descriptionFlats) {
        this.descriptionFlats = descriptionFlats;
    }

    public String getPriceFlats() {
        return priceFlats;
    }

    public void setPriceFlats(String rupeesFlats) {
        this.priceFlats = rupeesFlats;
    }

    public String getLocationFlats() {
        return locationFlats;
    }

    public void setLocationFlats(String locationFlats) {
        this.locationFlats = locationFlats;
    }
}

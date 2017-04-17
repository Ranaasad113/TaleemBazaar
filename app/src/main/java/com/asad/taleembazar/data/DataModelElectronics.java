package com.asad.taleembazar.data;

/**
 * Created by asad on 4/5/17.
 */

public class DataModelElectronics {
    private int imageElectronics;
    private String titleElectronics;
    private String priceElectronics;
    private String descriptionElectronics;

    public DataModelElectronics(int imageElectronics, String titleElectronics, String priceElectronics, String descriptionElectronics) {
        this.setImageElectronics(imageElectronics);
        setTitleElectronics(titleElectronics);
        setPriceElectronics(priceElectronics);
        setDescriptionElectronics(descriptionElectronics);
    }

    public int getImageElectronics() {
        return imageElectronics;
    }

    public void setImageElectronics(int imageElectronics) {
        this.imageElectronics = imageElectronics;
    }

    public String getTitleElectronics() {
        return titleElectronics;
    }

    public void setTitleElectronics(String titleElectronics) {
        this.titleElectronics = titleElectronics;
    }

    public String getPriceElectronics() {
        return priceElectronics;
    }

    public void setPriceElectronics(String priceElectronics) {
        this.priceElectronics = priceElectronics;
    }

    public String getDescriptionElectronics() {
        return descriptionElectronics;
    }

    public void setDescriptionElectronics(String descriptionElectronics) {
        this.descriptionElectronics = descriptionElectronics;
    }
}

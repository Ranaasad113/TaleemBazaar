package com.asad.taleembazar.data;

import com.asad.taleembazar.R;

/**
 * Created by asad on 4/5/17.
 */

public class DataModelCars {
    private int image1;
    private String titleCar;
    private String priceCar;
    private String brandCar;
    private String yearCar;
    private String registeredCard;
    private String descriptionCar;
    private String kmdriverCar;

    public DataModelCars(int image1, String titleCar, String priceCar, String brandCar, String yearCar, String registeredCard, String descriptionCar, String kmdriverCar) {
        setImageCar(image1);
        setTitleCar(titleCar);
        setPriceCar(priceCar);
        setBrandCar(brandCar);
        setYearCar(yearCar);
        setRegisteredCard(registeredCard);
        setKmdriverCar(kmdriverCar);
        setDescriptionCar(descriptionCar);
    }

    public int getImageCar() {
        return image1;
    }

    public void setImageCar(int image1) {
        this.image1 = image1;
    }

    public String getTitleCar() {
        return titleCar;
    }

    public void setTitleCar(String titleCar) {
        this.titleCar = titleCar;
    }

    public String getPriceCar() {
        return priceCar;
    }

    public void setPriceCar(String rupeesCar) {
        this.priceCar = rupeesCar;
    }

    public String getBrandCar() {
        return brandCar;
    }

    public void setBrandCar(String brandCar) {
        this.brandCar = brandCar;
    }

    public String getYearCar() {
        return yearCar;
    }

    public void setYearCar(String yearCar) {
        this.yearCar = yearCar;
    }

    public String getRegisteredCard() {
        return registeredCard;
    }

    public void setRegisteredCard(String registeredCard) {
        this.registeredCard = registeredCard;
    }

    public String getDescriptionCar() {
        return descriptionCar;
    }

    public void setDescriptionCar(String descriptionCar) {
        this.descriptionCar = descriptionCar;
    }

    public String getKmdriverCar() {
        return kmdriverCar;
    }

    public void setKmdriverCar(String kmdriverCar) {
        this.kmdriverCar = kmdriverCar;
    }
}

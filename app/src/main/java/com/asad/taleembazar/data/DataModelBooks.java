package com.asad.taleembazar.data;

/**
 * Created by asad on 4/5/17.
 */

public class DataModelBooks {
    private int imageBooks;
    private String titleBooks;
    private String priceBooks;

    public DataModelBooks(int imageBooks, String titleBooks, String priceBooks, String descriptioBooks) {
        setImageBooks(imageBooks);
        setTitleBooks(titleBooks);
        setPriceBooks(priceBooks);
        setDescriptioBooks(descriptioBooks);
    }

    public String getDescriptioBooks() {
        return descriptioBooks;
    }

    public void setDescriptioBooks(String descriptioBooks) {
        this.descriptioBooks = descriptioBooks;
    }

    public String getPriceBooks() {
        return priceBooks;
    }

    public void setPriceBooks(String priceBooks) {
        this.priceBooks = priceBooks;
    }

    public String getTitleBooks() {
        return titleBooks;
    }

    public void setTitleBooks(String titleBooks) {
        this.titleBooks = titleBooks;
    }

    public int getImageBooks() {
        return imageBooks;
    }

    public void setImageBooks(int imageBooks) {
        this.imageBooks = imageBooks;
    }

    private String descriptioBooks;

}

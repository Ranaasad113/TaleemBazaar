package com.asad.taleembazar.model;

import android.graphics.Bitmap;

/**
 *
 * Created by Rana Asad on 9/2/2017.
 *
 */

public class SubmitAddDataModel {
    private Bitmap[] images;
    private String title;
    private String description;
    private String category;
    private String subCatgory;
    private String location;

    public SubmitAddDataModel(Bitmap[] images, String title, String description, String category, String subCatgory, String location) {
        this.images = images;
        this.title = title;
        this.description = description;
        this.category = category;
        this.subCatgory = subCatgory;
        this.location = location;
    }

    public Bitmap[] getImages() {
        return images;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }

    public String getSubCatgory() {
        return subCatgory;
    }

    public String getLocation() {
        return location;
    }
}

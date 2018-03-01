package com.livewallpaper.rafael.livewallpaper.Model;

/**
 * Created by rafael on 27/02/18.
 */

public class BackgroundItem {
    public String imageUrl;
    public String idCategory;

    public BackgroundItem() {
    }

    public BackgroundItem(String imageUrl, String idCategory) {
        this.imageUrl = imageUrl;
        this.idCategory = idCategory;
    }


    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(String idCategory) {
        this.idCategory = idCategory;
    }
}

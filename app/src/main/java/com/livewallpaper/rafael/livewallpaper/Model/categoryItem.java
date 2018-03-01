package com.livewallpaper.rafael.livewallpaper.Model;

/**
 * Created by rafael on 24/02/18.
 */

public class categoryItem {
    public String name;
    public String imageLink;


    public categoryItem() {
    }

    public categoryItem(String name, String imageLink) {
        this.name = name;
        this.imageLink = imageLink;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }
}

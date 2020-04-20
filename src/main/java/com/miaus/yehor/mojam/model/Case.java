package com.miaus.yehor.mojam.model;

public class Case {

    private String image;
    private String type;
    private String name;
    private float price;

    public Case(String image, String type, String name) {
        this.image = image;
        this.type = type;
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}

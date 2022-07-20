package com.example.demo.Catalog;

import java.util.Random;

public class Wood {
    //Only russian name. This name displayed to site
    private String name;
    //Img patch = th:src = @{/image/...image file name...}
    private String img_patch;
    private float thickness;
    private float _long;
    private float width;
    private String sort;
    private String form;
    private int price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return img_patch;
    }

    public void setImage(String img_patch) {
        this.img_patch = img_patch;
    }

    public float getThickness() {
        return thickness;
    }

    public void setThickness(float thickness) {
        this.thickness = thickness;
    }

    public float getLong() {
        return _long;
    }

    public void setLong(float _long) {
        this._long = _long;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    public void GenerateRandomWood(String name){
        this.name = name;
        Random r = new Random();
        img_patch = "IMG_PATCH";
        thickness = r.nextFloat();
        _long = r.nextFloat();
        width = r.nextFloat();
        sort = "SORT";
        form = "FORM";
        price = r.nextInt();

    }
    public String toString(){
        return name + "; " + img_patch + "; "+thickness+"; "+_long+"; "+width+"; "+sort+"; "+form+"; "+price+";";
    }

}

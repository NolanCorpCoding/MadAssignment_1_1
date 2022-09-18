package com.example.madassignment_1_1.Restaurants;

public class Restaurant {
    private String name;
    private final int drawableID;

    public Restaurant(int drawableID, String name){
        this.drawableID = drawableID;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getDrawableID() {
        return drawableID;
    }
}

package com.example.madassignment_1_1.Meals;

public class Meal {
    private String name;
    private final int drawableID;
    private double price;

    public Meal(int drawableID, String name, Double price){
        this.drawableID = drawableID;
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {return price;}

    public int getDrawableID() {
        return drawableID;
    }
}

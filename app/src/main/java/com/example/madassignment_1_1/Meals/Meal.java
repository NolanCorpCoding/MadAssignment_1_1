package com.example.madassignment_1_1.Meals;

public class Meal {
    public final int id;
    private String name;
    private double price;
    private final int restaurantID;
    private final int drawableID;


    public Meal(int pId, String pName, Double pPrice, int pRestaurantID, int pDrawableID){
        this.id = pId;
        this.name = name;
        this.price = price;
        this.restaurantID = pRestaurantID;
        this.drawableID = pDrawableID;
    }

    public String getName() {
        return name;
    }

    public int getId() {return id;}

    public int getRestaurantID() {return restaurantID;}

    public double getPrice() {return price;}

    public int getDrawableID() {
        return drawableID;
    }

    public void setName(String name) {this.name = name;}

    public void setPrice(double price) {this.price = price;}
}

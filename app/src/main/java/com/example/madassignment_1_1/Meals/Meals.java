package com.example.madassignment_1_1.Meals;

import android.util.Log;

public class Meals
{
    public final int id;
    public String name;
    public double price;
    public int restaurantId;
    public final int drawableId;

    public static int nextId;

    public Meals(int pId, String pName, double pPrice, int pRestaurantId, int pDrawableId)
    {
        this.id = pId;
        this.name = pName;
        this.price = pPrice;
        this.restaurantId = pRestaurantId;
        this.drawableId = pDrawableId;
        nextId = pId + 1;
    }

    public Meals(String pName, double pPrice, int pRestaurantId, int pDrawableId)
    {
        this(nextId, pName, pPrice, pRestaurantId, pDrawableId); // Delegate to the other constructor
        nextId++;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public int getDrawableId() {
        return drawableId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        if(price >=0)
        {
            this.price = price;
        }
        else
        {
            Log.d("Logical Error", "Tried to set price to an invalid number (ie <0) for the " + this.name +  " meal.");
        }
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }
}

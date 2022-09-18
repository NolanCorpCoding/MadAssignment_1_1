package com.example.madassignment_1_1.Restaurants;

import com.example.madassignment_1_1.Meals.Meal;
import com.example.madassignment_1_1.Meals.MealsList;
import com.example.madassignment_1_1.R;

import java.util.Arrays;
import java.util.List;

public class Restaurant {
    private String name;
    private final int drawableID;
    private MealsList mealsList;

    public Restaurant(int drawableID, String name, MealsList list){
        this.drawableID = drawableID;
        this.name = name;
        this.mealsList = list;
    }

    public String getName() {
        return name;
    }

    public int getDrawableID() {
        return drawableID;
    }
}

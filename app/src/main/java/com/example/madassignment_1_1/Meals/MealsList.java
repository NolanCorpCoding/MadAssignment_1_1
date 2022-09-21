package com.example.madassignment_1_1.Meals;

import com.example.madassignment_1_1.R;
import com.example.madassignment_1_1.Restaurants.Restaurant;
import com.example.madassignment_1_1.Restaurants.RestaurantList;

import java.util.Arrays;
import java.util.List;

public class MealsList {

    private List<Meal> mealsList = Arrays.asList(new Meal[]{
            new Meal(R.drawable.dominos, "Dominos", 12.0),
            new Meal(R.drawable.kfc, "KFC", 10.0),
            new Meal(R.drawable.maccas, "McDonalds", 12.5),
    });


    private static MealsList instance = null;

    public static MealsList get()
    {
        if(instance == null)
        {
            instance = new MealsList();
        }
        return instance;
    }

    protected MealsList() {}

    public Meal get(int i)
    {
        return mealsList.get(i);
    }

    public int size()
    {
        return mealsList.size();
    }

    public void add(Meal s)
    {
        mealsList.add(0, s);
    }

    public void remove(int i)
    {
        mealsList.remove(i);
    }


}

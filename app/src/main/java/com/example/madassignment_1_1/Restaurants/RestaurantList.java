package com.example.madassignment_1_1.Restaurants;

import com.example.madassignment_1_1.R;

import java.util.Arrays;
import java.util.List;

public class RestaurantList {

    private List<Restaurant> restaurantList = Arrays.asList(new Restaurant[]{
            new Restaurant(R.drawable.dominos, "Dominos"),
            new Restaurant(R.drawable.kfc, "KFC"),
            new Restaurant(R.drawable.maccas, "McDonalds"),
    });

    private static RestaurantList instance = null;

    public static RestaurantList get()
    {
        if(instance == null)
        {
            instance = new RestaurantList();
        }
        return instance;
    }

    protected RestaurantList() {}

    public Restaurant get(int i)
    {
        return restaurantList.get(i);
    }

    public int size()
    {
        return restaurantList.size();
    }

    public void add(Restaurant s)
    {
        restaurantList.add(0, s);
    }

    public void remove(int i)
    {
        restaurantList.remove(i);
    }


}

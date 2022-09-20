package com.example.madassignment_1_1.Restaurants;

import android.content.Context;

import com.example.madassignment_1_1.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RestaurantList {


    private List<Restaurant> restaurants;
    RestaurantDBModel restaurantDBModel;

//    private static RestaurantList instance = null;
//
//    public static RestaurantList get()
//    {
//        if(instance == null)
//        {
//            instance = new RestaurantList();
//        }
//        return instance;
//    }

    public void load(Context context)
    {
        restaurants = new ArrayList<>();

        restaurantDBModel = new RestaurantDBModel();
        restaurantDBModel.load(context);

        restaurants = restaurantDBModel.getAllRestaurants();

        if(restaurantDBModel.getNumTuples() <= 0)
        {
            addRestaurants();
        }
    }

    private void addRestaurants()
    {
        restaurantDBModel.addRestaurant(new Restaurant("Dominos", "Address 1", R.drawable.dominos));
        restaurantDBModel.addRestaurant(new Restaurant("KFC", "Address 2", R.drawable.dominos));
        restaurantDBModel.addRestaurant(new Restaurant("McDonalds", "Address 3", R.drawable.maccas));
    }


    protected RestaurantList() {}

    public Restaurant get(int i)
    {
        return restaurants.get(i);
    }

    public int size()
    {
        return restaurants.size();
    }

    public void add(Restaurant s)
    {
        restaurants.add(0, s);
    }

    public void remove(int i)
    {
        restaurants.remove(i);
    }


}

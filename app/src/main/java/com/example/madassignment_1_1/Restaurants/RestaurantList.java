package com.example.madassignment_1_1.Restaurants;

import android.content.Context;
import android.util.Log;

import com.example.madassignment_1_1.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RestaurantList {

    private List<Restaurant> restaurants;
    RestaurantDBModel restaurantDBModel;
    RestaurantCreator restaurantCreator;

    public void load(Context context)
    {
        restaurants = new ArrayList<>();

        restaurantDBModel = new RestaurantDBModel();
        restaurantDBModel.load(context);

        restaurantCreator = new RestaurantCreator(restaurantDBModel);

        restaurants = restaurantDBModel.getAllRestaurants();

        if(restaurantDBModel.getNumTuples() <= 0)
        {
            restaurantCreator.createRestaurants();
        }
//        else
//        {
//            restaurantDBModel.getId("Dominos");
//            restaurantDBModel.getId("KFC");
//            restaurantDBModel.getId("McDonalds");
//        }
    }


//    protected RestaurantList() {}

    public Restaurant get(int i)
    {
        return restaurants.get(i);
    }

    public int size()
    {
        return restaurants.size();
    }

//    public void add(Restaurant s)
//    {
//        restaurants.add(0, s);
//    }
//
//    public void remove(int i)
//    {
//        restaurants.remove(i);
//    }


}

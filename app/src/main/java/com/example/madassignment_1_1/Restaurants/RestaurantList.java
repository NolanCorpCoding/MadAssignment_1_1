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
        else
        {
            restaurantDBModel.getId("Dominos");
            restaurantDBModel.getId("KFC");
            restaurantDBModel.getId("McDonalds");
        }
    }

    private void addRestaurants()
    {
        restaurantDBModel.addRestaurant(new Restaurant(1, "Dominos", "410/412 Albany Hwy, Victoria Park WA 6100", R.drawable.dominos));
        restaurantDBModel.addRestaurant(new Restaurant(2, "KFC", "252 Abernethy Rd, Belmont WA 6104", R.drawable.kfc));
        restaurantDBModel.addRestaurant(new Restaurant(3, "McDonalds", "224 Manning Rd, Karawara WA 6152", R.drawable.maccas));
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

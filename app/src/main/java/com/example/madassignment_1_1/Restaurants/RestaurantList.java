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
        Log.d("DEBUG", "RUNNING LOAD() Method.");

        restaurants = new ArrayList<>();

        restaurantDBModel = new RestaurantDBModel();
        restaurantDBModel.load(context);

        Log.d("DEBUG", "RUNNING MIDDLE OF LOAD() Method and so the restaurantDBModel.getNumTuples() == " + restaurantDBModel.getNumTuples() +  ".");


        restaurants = restaurantDBModel.getAllRestaurants();

        if(restaurantDBModel.getNumTuples() <= 0)
        {
            addRestaurants();
        }
        Log.d("DEBUG", "RUNNING FINISHED FOR THE LOAD() Metho dand so the restaurantDBModel.getNumTuples() == " + restaurantDBModel.getNumTuples() +  ".");

    }

    private void addRestaurants()
    {
        restaurantDBModel.addRestaurant(new Restaurant("Dominos", "410/412 Albany Hwy, Victoria Park WA 6100", R.drawable.dominos));
        restaurantDBModel.addRestaurant(new Restaurant("KFC", "252 Abernethy Rd, Belmont WA 6104", R.drawable.dominos));
        restaurantDBModel.addRestaurant(new Restaurant("McDonalds", "224 Manning Rd, Karawara WA 6152", R.drawable.maccas));
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

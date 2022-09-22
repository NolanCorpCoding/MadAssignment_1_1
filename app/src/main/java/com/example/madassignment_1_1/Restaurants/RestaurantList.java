package com.example.madassignment_1_1.Restaurants;

import android.content.Context;
import android.util.Log;

import com.example.madassignment_1_1.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RestaurantList {

    private List<Restaurant> loadedRestaurants;
    private List<Restaurant> allRestaurants;
    RestaurantDBModel restaurantDBModel;

    public void load(Context context)
    {
        //initialise the 2 restaurant lists
        loadedRestaurants = new ArrayList<>();
        allRestaurants = new ArrayList<>();

        //load in the current db for restaurants
        restaurantDBModel = new RestaurantDBModel();
        restaurantDBModel.load(context);

        //populate the 2 restaurant lists
        addRestaurants();
        loadedRestaurants = restaurantDBModel.getAllRestaurants();

        checkNewRestaurants();

//        restaurantDBModel.getId("Dominos");
//        restaurantDBModel.getId("KFC");
//        restaurantDBModel.getId("McDonalds");

    }


    protected RestaurantList() {}

    public Restaurant get(int i)
    {
        return loadedRestaurants.get(i);
    }

    public int size()
    {
        return loadedRestaurants.size();
    }

    public void addRestaurants()
    {
        allRestaurants.clear();
        allRestaurants.add(new Restaurant(1, "Dominos", "410/412 Albany Hwy, Victoria Park WA 6100", R.drawable.dominos));
        allRestaurants.add(new Restaurant(2, "KFC", "252 Abernethy Rd, Belmont WA 6104", R.drawable.kfc));
        allRestaurants.add(new Restaurant(3, "McDonalds", "224 Manning Rd, Karawara WA 6152", R.drawable.maccas));
    }


    public void checkNewRestaurants()
    {
        boolean restaurantFound = false;
        for(Restaurant definedRestaurant : allRestaurants)
        {
            for(Restaurant loadedRestaurant : loadedRestaurants)
            {
                if(definedRestaurant.getId() == loadedRestaurant.getId())
                {
                    restaurantFound = true;
                }
            }

            if(!restaurantFound)
            {
                Log.d("DEBUG", "Found a restaurant (" + definedRestaurant.getName() + "' that is not in the database");
                restaurantDBModel.addRestaurant(definedRestaurant);
            }

            restaurantFound = false;
        }
    }



}

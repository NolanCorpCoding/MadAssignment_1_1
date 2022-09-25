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
        //allRestaurants.add(new Restaurant(3, "FAKE McDonalds", "FAKE 224 Manning Rd, Karawara WA 6152", R.drawable.maccas));
        allRestaurants.add(new Restaurant(4, "Five Guys", "321 Steward St, Mandurah WA 6293", R.drawable.fiveguys));
        allRestaurants.add(new Restaurant(5, "Grill'd", "912 Langely Ct, West Perth, WA 6001", R.drawable.grilld));
        allRestaurants.add(new Restaurant(6, "Hungry Jacks", "12 Stirling Hwy, Claremont 6010", R.drawable.jacks));
        allRestaurants.add(new Restaurant(7, "Mad Mex", "51 Samuel St, Rockingham 6233", R.drawable.madmex));
        allRestaurants.add(new Restaurant(8, "Nandos", "756 Tobey Rd, Nedlands 6009", R.drawable.nandos));
        allRestaurants.add(new Restaurant(9, "Pizza Hut", "123 West Coast Blvd, Fremantle 6024", R.drawable.pizzahut));
        allRestaurants.add(new Restaurant(10, "Subway", "512 Stone Rd, Mundaring 6723", R.drawable.subway));
        allRestaurants.add(new Restaurant(11, "Taco Bell", "41 Bronze St, Northbridge 6000", R.drawable.tacobell));
        allRestaurants.add(new Restaurant(12, "Zambrero", "83 Subaru St, Osborne Park 6090", R.drawable.zamb));

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
                    if(definedRestaurant.getName().equals(loadedRestaurant.getName()))
                    {
                        if(definedRestaurant.getAddress().equals(loadedRestaurant.getAddress()))
                        {
                            if(definedRestaurant.getDrawableID() == loadedRestaurant.getDrawableID())
                            {
                                restaurantFound = true;
                            }
                        }
                    }
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

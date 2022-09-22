package com.example.madassignment_1_1.Restaurants;

import com.example.madassignment_1_1.Meals.Meal;
import com.example.madassignment_1_1.Meals.MealItemDBModel;
import com.example.madassignment_1_1.R;

public class RestaurantCreator {
    RestaurantDBModel restaurantDBModel;

    public RestaurantCreator(RestaurantDBModel pRestaurantDBModel) {
        this.restaurantDBModel = pRestaurantDBModel;
    }

    public void createRestaurants()
    {
        restaurantDBModel.addRestaurant(new Restaurant(1, "Dominos", "410/412 Albany Hwy, Victoria Park WA 6100", R.drawable.dominos));
        restaurantDBModel.addRestaurant(new Restaurant(2, "KFC", "252 Abernethy Rd, Belmont WA 6104", R.drawable.kfc));
        restaurantDBModel.addRestaurant(new Restaurant(3, "McDonalds", "224 Manning Rd, Karawara WA 6152", R.drawable.maccas));
    }

}

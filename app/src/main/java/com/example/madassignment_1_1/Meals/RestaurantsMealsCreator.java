package com.example.madassignment_1_1.Meals;

import android.util.Log;

import com.example.madassignment_1_1.R;
import com.example.madassignment_1_1.Restaurants.RestaurantDBModel;

import java.util.ArrayList;
import java.util.List;

public class RestaurantsMealsCreator {
    MealItemDBModel mealItemDBModel;
    RestaurantDBModel restaurantDBModel;

    public RestaurantsMealsCreator(MealItemDBModel pMealItemDBModel, RestaurantDBModel pRestaurantDBModel) {
        this.mealItemDBModel = pMealItemDBModel;
        this.restaurantDBModel = pRestaurantDBModel;
    }

    public List<Meals> AddMeals()
    {
        List<Meals> mealList = new ArrayList<>();

        DominosMeals(mealList);
        MaccasMeals(mealList);

        return mealList;
    }


    public List<Meals> DominosMeals(List<Meals> mealList)
    {
        int restaurantID = restaurantDBModel.getId("Dominos");

        mealList.add(new Meals(1, "Cheese Pizza", 5.20, restaurantID, R.drawable.cheesepizza));
        mealList.add(new Meals(2, "Pepperoni Pizza", 4.99, restaurantID, R.drawable.peppizza));
        mealList.add(new Meals(3, "Supreme Pizza", 6.70, restaurantID, R.drawable.suppizza));

        Log.d("DEBUG", "Added Dominos Meals");

        return mealList;
    }

    public List<Meals> MaccasMeals(List<Meals> mealList)
    {
        int restaurantID = restaurantDBModel.getId("McDonalds");

        mealList.add(new Meals(4, "McDonals Fries", 3.20, restaurantID, R.drawable.cheesepizza));
        mealList.add(new Meals(5, "Big Mac", 6.00, restaurantID, R.drawable.peppizza));
        mealList.add(new Meals(6, "20 Nuggets", 10.25, restaurantID, R.drawable.suppizza));

        Log.d("DEBUG", "Added Maccas Meals");

        return mealList;
    }

}

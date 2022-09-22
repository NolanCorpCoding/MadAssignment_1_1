package com.example.madassignment_1_1.Meals;

import android.content.Context;
import android.util.Log;

import com.example.madassignment_1_1.Restaurants.RestaurantDBModel;

import java.util.ArrayList;
import java.util.List;

public class MealsList {
    private List<Meals> currMeals;
    private List<Meals> allMeals;
    MealItemDBModel mealItemDBModel;
    RestaurantDBModel restaurantDBModel;
    RestaurantsMealsCreator restaurantsMeals;

    public void load(Context context)
    {
        currMeals = new ArrayList<>();
        allMeals = new ArrayList<>();

        mealItemDBModel = new MealItemDBModel();
        mealItemDBModel.load(context);

        restaurantDBModel = new RestaurantDBModel();
        restaurantDBModel.load(context);

        restaurantsMeals = new RestaurantsMealsCreator(mealItemDBModel, restaurantDBModel);

        allMeals = restaurantsMeals.AddMeals();
        currMeals = mealItemDBModel.getAllMealItems();

        checkNewMeals();

        Log.d("DEBUG", "MEALS...");
        for(Meals meal : currMeals)
        {
            Log.d("DEBUG", "MEAL: id:" + meal.getId() + " name:" + meal.getName() + " price:" + meal.getPrice());
        }

//        if(mealItemDBModel.getNumTuples() <= 0)
//        {
//            Log.d("DEBUG", "CREATING NEW USERS");
//            restaurantsMeals.DominosMeals();
//
//        }
//        else
//        {
//            useraccountDBModel.getId("jamescarey@gmail.com", "jamescareypassword");
//            useraccountDBModel.getId("angusbrayshaw@htomail.com", "angusbrayshawpassword");
//            useraccountDBModel.getId("jacktyson@outlook.com", "jacktysonpassword");
//        }
        Log.d("DEBUG", "FINISHED LOADING DB");

    }

    protected MealsList() {}

    public Meals get(int i)
    {
        return currMeals.get(i);
    }

    public int size()
    {
        return currMeals.size();
    }


    public void checkNewMeals()
    {
        boolean mealFound = false;
        for(Meals meal : allMeals)
        {
            for(Meals loadedMeal : currMeals)
            {
                if(meal.getId() == loadedMeal.getId())
                {
                    mealFound = true;
                }
            }

            if(!mealFound)
            {
                Log.d("DEBUG", "Found a restaurant (" + meal.getName() + "' that is not in the database");
                mealItemDBModel.addMealItem(meal);
            }

            mealFound = false;
        }
    }


}

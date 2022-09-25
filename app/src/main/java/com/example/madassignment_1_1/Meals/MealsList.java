package com.example.madassignment_1_1.Meals;

import android.content.Context;
import android.util.Log;

import com.example.madassignment_1_1.Restaurants.RestaurantDBModel;

import java.util.Random;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
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

        //Log.d("DEBUG", "MEALS...");
//        for(Meals meal : currMeals)
//        {
//            Log.d("DEBUG", "MEAL: id:" + meal.getId() + " name:" + meal.getName() + " price:" + meal.getPrice() + " restaurantid:" + meal.getRestaurantId());
//        }

    }

    public MealsList(Context pContext) {
        load(pContext);
    }

    public List<Meals> getRestaurantMeals(int resID) {
        List<Meals> resMeals = new ArrayList<>();
        for (Meals meals : currMeals){
            //Log.d("lmao", "Got meal " + meals.getName());
            if (meals.getRestaurantId() == resID){
                Log.d("testing123", "Got meal " + meals.getRestaurantId() + " vs id " + resID);
                resMeals.add(meals);
            }
        }
        return resMeals;
    }

    public Meals get(int i)
    {
        return currMeals.get(i);
    }

    public int size()
    {
        return currMeals.size();
    }

    public List<Meals> getRandomMeals(){

        Random randomGenerator = new Random();

        List<Meals> list = new ArrayList<>();

        int numElements = 12;

        for (int i = 0; i < numElements; i++)
        {
            list.add(allMeals.get(randomGenerator.nextInt(numElements)));
        }
        return list;
    }


    public void checkNewMeals()
    {
        Log.d("DEBUG", "Started Comparison");
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

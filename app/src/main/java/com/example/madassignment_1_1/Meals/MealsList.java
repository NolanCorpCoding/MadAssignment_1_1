package com.example.madassignment_1_1.Meals;

import android.content.Context;
import android.util.Log;

import com.example.madassignment_1_1.Account.UserAccount;
import com.example.madassignment_1_1.Account.UserAccountDBModel;
import com.example.madassignment_1_1.R;
import com.example.madassignment_1_1.Restaurants.Restaurant;
import com.example.madassignment_1_1.Restaurants.RestaurantDBModel;
import com.example.madassignment_1_1.Restaurants.RestaurantList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MealsList {
    private List<Meal> meals;
    MealItemDBModel mealItemDBModel;
    RestaurantDBModel restaurantDBModel;
    RestaurantsMealsCreator restaurantsMeals;

    public void load(Context context)
    {
        meals = new ArrayList<>();

        mealItemDBModel = new MealItemDBModel();
        mealItemDBModel.load(context);

        restaurantDBModel = new RestaurantDBModel();
        restaurantDBModel.load(context);

        restaurantsMeals = new RestaurantsMealsCreator(mealItemDBModel, restaurantDBModel);

        meals = mealItemDBModel.getAllUserAccounts();

        if(mealItemDBModel.getNumTuples() <= 0)
        {
            Log.d("DEBUG", "CREATING NEW USERS");
            restaurantsMeals.DominosMeals();

        }
//        else
//        {
//            useraccountDBModel.getId("jamescarey@gmail.com", "jamescareypassword");
//            useraccountDBModel.getId("angusbrayshaw@htomail.com", "angusbrayshawpassword");
//            useraccountDBModel.getId("jacktyson@outlook.com", "jacktysonpassword");
//        }
        Log.d("DEBUG", "FINISHED LOADING DB");

    }

    protected MealsList() {}

    public Meal get(int i)
    {
        return meals.get(i);
    }

    public int size()
    {
        return meals.size();
    }

    public void add(Meal s)
    {
        meals.add(0, s);
    }

    public void remove(int i)
    {
        meals.remove(i);
    }


}

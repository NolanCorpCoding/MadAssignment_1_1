package com.example.madassignment_1_1.Meals;

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

        return mealList;
    }


    public List<Meals> DominosMeals(List<Meals> mealList)
    {
        int restaurantID = restaurantDBModel.getId("Dominos");

        mealList.add(new Meals(1, "Cheese Pizza", 5.20, restaurantID, R.drawable.cheesepizza));
        mealList.add(new Meals(2, "Pepperoni Pizza", 4.99, restaurantID, R.drawable.peppizza));
        mealList.add(new Meals(3, "Supreme Pizza", 6.70, restaurantID, R.drawable.suppizza));


//        mealItemDBModel.addRestaurant(new Meal(1, "Cheese Pizza", 5.20, restaurantID, R.drawable.cheesepizza));
//        mealItemDBModel.addRestaurant(new Meal(2, "Pepperoni Pizza", 4.99, restaurantID, R.drawable.peppizza));
//        mealItemDBModel.addRestaurant(new Meal(3, "Supreme Pizza", 6.70, restaurantID, R.drawable.suppizza));

        return mealList;
    }

}

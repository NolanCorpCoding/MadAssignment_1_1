package com.example.madassignment_1_1.Meals;

import com.example.madassignment_1_1.Account.UserAccount;
import com.example.madassignment_1_1.R;
import com.example.madassignment_1_1.Restaurants.RestaurantDBModel;

public class RestaurantsMealsCreator {
    MealItemDBModel mealItemDBModel;
    RestaurantDBModel restaurantDBModel;

    public RestaurantsMealsCreator(MealItemDBModel pMealItemDBModel, RestaurantDBModel pRestaurantDBModel) {
        this.mealItemDBModel = pMealItemDBModel;
        this.restaurantDBModel = pRestaurantDBModel;
    }

    public void DominosMeals()
    {
        int restaurantID = restaurantDBModel.getId("Dominos");

        mealItemDBModel.addRestaurant(new Meal(1, "Cheese Pizza", 5.20, restaurantID, R.drawable.cheesepizza));
        mealItemDBModel.addRestaurant(new Meal(2, "Pepperoni Pizza", 4.99, restaurantID, R.drawable.peppizza));
        mealItemDBModel.addRestaurant(new Meal(3, "Supreme Pizza", 6.70, restaurantID, R.drawable.suppizza));
    }

}

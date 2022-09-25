package com.example.madassignment_1_1.Meals;

import android.content.Context;
import android.util.Log;

import com.example.madassignment_1_1.R;
import com.example.madassignment_1_1.Restaurants.RestaurantDBModel;

import java.util.ArrayList;
import java.util.List;

public class RestaurantsMealsCreator {
    MealItemDBModel mealItemDBModel;
    RestaurantDBModel restaurantDBModel;
    MealsList mealsList;

    public RestaurantsMealsCreator(MealItemDBModel pMealItemDBModel, RestaurantDBModel pRestaurantDBModel, Context context) {
        this.mealItemDBModel = pMealItemDBModel;
        this.restaurantDBModel = pRestaurantDBModel;
        mealsList = new MealsList(context);
        mealsList.load(context);
    }

    public List<Meals> AddMeals()
    {
        List<Meals> mealList = new ArrayList<>();

        DominosMeals(mealList);
        MaccasMeals(mealList);
//        KFC(mealList);
//        FiveGuys(mealList);
//        Zambrero(mealList);
//        Nandos(mealList);
//        TacoBell(mealList);
//        PizzaHut(mealList);
//        HungryJacks(mealList);
//        Subway(mealList);


        // make sure you double check the name of the restaurant ID!!!

        return mealList;
    }

    public Meals compareMeal(Meals pMeal)
    {
        Meals returningMeal = null;
        boolean found = false;

        for(Meals loopingMeal : mealsList.getAllCurrentMeals())
        {
            if((loopingMeal.getName().equals(pMeal.getName())) && (loopingMeal.getDrawableId() == pMeal.getDrawableId()) && (loopingMeal.getRestaurantId() == pMeal.getRestaurantId()) && (loopingMeal.getPrice() == pMeal.getPrice()))
            {
                found = true;
                returningMeal = loopingMeal;
            }
        }

        if(!found)
        {
            returningMeal = pMeal;
        }

        return returningMeal;

    }



    public List<Meals> DominosMeals(List<Meals> mealList)
    {
        int restaurantID = restaurantDBModel.getId("Dominos");

        mealList.add(new Meals("Small Cheese Pizza", 5.20, restaurantID, R.drawable.cheesepizza));
        mealList.add(new Meals("Small Pepperoni Pizza", 4.99, restaurantID, R.drawable.peppizza));
        mealList.add(new Meals("Small Supreme Pizza", 6.70, restaurantID, R.drawable.suppizza));
        mealList.add(new Meals("Medium Cheese Pizza", 5.20, restaurantID, R.drawable.cheesepizza));
        mealList.add(new Meals("Medium Pepperoni Pizza", 4.99, restaurantID, R.drawable.peppizza));
        mealList.add(new Meals("Medium Supreme Pizza", 6.70, restaurantID, R.drawable.suppizza));
        mealList.add(new Meals("Large Cheese Pizza", 5.20, restaurantID, R.drawable.cheesepizza));
        mealList.add(new Meals("Large Pepperoni Pizza", 4.99, restaurantID, R.drawable.peppizza));
        mealList.add(new Meals("Large Supreme Pizza", 6.70, restaurantID, R.drawable.suppizza));
        mealList.add(new Meals("XL Cheese Pizza", 5.20, restaurantID, R.drawable.cheesepizza));
        mealList.add(new Meals("XL Pepperoni Pizza", 4.99, restaurantID, R.drawable.peppizza));
        mealList.add(new Meals("XL Supreme Pizza", 6.70, restaurantID, R.drawable.suppizza));

//        mealList.add(compareMeal(new Meals("Small Cheese Pizza", 5.20, restaurantID, R.drawable.cheesepizza)));
//        mealList.add(compareMeal(new Meals("Small Pepperoni Pizza", 4.99, restaurantID, R.drawable.peppizza)));
//        mealList.add(compareMeal(new Meals("Small Supreme Pizza", 6.70, restaurantID, R.drawable.suppizza)));
//        mealList.add(compareMeal(new Meals("Medium Cheese Pizza", 5.20, restaurantID, R.drawable.cheesepizza)));
//        mealList.add(compareMeal(new Meals("Medium Pepperoni Pizza", 4.99, restaurantID, R.drawable.peppizza)));
//        mealList.add(compareMeal(new Meals("Medium Supreme Pizza", 6.70, restaurantID, R.drawable.suppizza)));
//        mealList.add(compareMeal(new Meals("Large Cheese Pizza", 5.20, restaurantID, R.drawable.cheesepizza)));
//        mealList.add(compareMeal(new Meals("Large Pepperoni Pizza", 4.99, restaurantID, R.drawable.peppizza)));
//        mealList.add(compareMeal(new Meals("Large Supreme Pizza", 6.70, restaurantID, R.drawable.suppizza)));
//        mealList.add(compareMeal(new Meals("XL Cheese Pizza", 5.20, restaurantID, R.drawable.cheesepizza)));
//        mealList.add(compareMeal(new Meals("XL Pepperoni Pizza", 4.99, restaurantID, R.drawable.peppizza)));
//        mealList.add(compareMeal(new Meals("XL Supreme Pizza", 6.70, restaurantID, R.drawable.suppizza)));
        Log.d("DEBUG", "Added Dominos Meals");

        return mealList;
    }

    public List<Meals> MaccasMeals(List<Meals> mealList)
    {
        int restaurantID = restaurantDBModel.getId("McDonalds");

        mealList.add(new Meals("Small Fries", 3.20, restaurantID, R.drawable.fries));
        mealList.add(new Meals("Small Mac", 6.00, restaurantID, R.drawable.bigmac));
        mealList.add(new Meals("5 Nuggets", 10.25, restaurantID, R.drawable.nuggets));
        mealList.add(new Meals("Medium Fries", 3.20, restaurantID, R.drawable.fries));
        mealList.add(new Meals("Medium Mac", 6.00, restaurantID, R.drawable.bigmac));
        mealList.add(new Meals("10 Nuggets", 10.25, restaurantID, R.drawable.nuggets));
        mealList.add(new Meals("Large Fries", 3.20, restaurantID, R.drawable.fries));
        mealList.add(new Meals("Big Mac", 6.00, restaurantID, R.drawable.bigmac));
        mealList.add(new Meals("20 Nuggets", 10.25, restaurantID, R.drawable.nuggets));
        mealList.add(new Meals("XL Fries", 3.20, restaurantID, R.drawable.fries));
        mealList.add(new Meals("Monster Mac", 6.00, restaurantID, R.drawable.cheeseburger));
        mealList.add(new Meals("50 Nuggets", 10.25, restaurantID, R.drawable.nuggets));
        Log.d("DEBUG", "Added Maccas Meals");

//        mealList.add(compareMeal(new Meals("Small Fries", 3.20, restaurantID, R.drawable.fries)));
//        mealList.add(compareMeal(new Meals("Small Mac", 6.00, restaurantID, R.drawable.bigmac)));
//        mealList.add(compareMeal(new Meals("5 Nuggets", 10.25, restaurantID, R.drawable.nuggets)));
//        mealList.add(compareMeal(new Meals("Medium Fries", 3.20, restaurantID, R.drawable.fries)));
//        mealList.add(compareMeal(new Meals("Medium Mac", 6.00, restaurantID, R.drawable.bigmac)));
//        mealList.add(compareMeal(new Meals("10 Nuggets", 10.25, restaurantID, R.drawable.nuggets)));
//        mealList.add(compareMeal(new Meals("Large Fries", 3.20, restaurantID, R.drawable.fries)));
//        mealList.add(compareMeal(new Meals("Big Mac", 6.00, restaurantID, R.drawable.bigmac)));
//        mealList.add(compareMeal(new Meals("20 Nuggets", 10.25, restaurantID, R.drawable.nuggets)));
//        mealList.add(compareMeal(new Meals("XL Fries", 3.20, restaurantID, R.drawable.fries)));
//        mealList.add(compareMeal(new Meals("Monster Mac", 6.00, restaurantID, R.drawable.cheeseburger)));
//        mealList.add(compareMeal(new Meals("50 Nuggets", 10.25, restaurantID, R.drawable.nuggets)));
        Log.d("DEBUG", "Added Maccas Meals");

        return mealList;
    }

//    public List<Meals> FiveGuys(List<Meals> mealList)
//    {
//        int restaurantID = restaurantDBModel.getId("Five Guys");
//
//        mealList.add(new Meals("Small Fries", 3.20, restaurantID, R.drawable.fries));
//        mealList.add(new Meals("Small Burger", 6.00, restaurantID, R.drawable.cheeseburger));
//        mealList.add(new Meals("Small Shake", 10.25, restaurantID, R.drawable.milkshake));
//        mealList.add(new Meals("Medium Fries", 3.20, restaurantID, R.drawable.fries));
//        mealList.add(new Meals("Medium Burger", 6.00, restaurantID, R.drawable.cheeseburger));
//        mealList.add(new Meals("Medium Shake", 10.25, restaurantID, R.drawable.milkshake));
//        mealList.add(new Meals("Large Fries", 3.20, restaurantID, R.drawable.fries));
//        mealList.add(new Meals("Large Burger", 6.00, restaurantID, R.drawable.cheeseburger));
//        mealList.add(new Meals("Large Shake", 10.25, restaurantID, R.drawable.milkshake));
//        mealList.add(new Meals("XL Fries", 3.20, restaurantID, R.drawable.fries));
//        mealList.add(new Meals("XL Burger", 6.00, restaurantID, R.drawable.cheeseburger));
//        mealList.add(new Meals("XL Shake", 10.25, restaurantID, R.drawable.milkshake));
//        Log.d("DEBUG", "Added 5 guys Meals");
//
//        return mealList;
//    }
//
//    public List<Meals> KFC(List<Meals> mealList)
//    {
//        int restaurantID = restaurantDBModel.getId("KFC");
//
//        mealList.add(new Meals("Small Fries", 3.20, restaurantID, R.drawable.fries));
//        mealList.add(new Meals("Small Chicken", 6.00, restaurantID, R.drawable.chicken));
//        mealList.add(new Meals("Small Nuggets", 10.25, restaurantID, R.drawable.nuggets));
//        mealList.add(new Meals("Medium Fries", 3.20, restaurantID, R.drawable.fries));
//        mealList.add(new Meals("Medium Chicken", 6.00, restaurantID, R.drawable.chicken));
//        mealList.add(new Meals("Medium Nuggets", 10.25, restaurantID, R.drawable.nuggets));
//        mealList.add(new Meals("Large Fries", 3.20, restaurantID, R.drawable.fries));
//        mealList.add(new Meals("Large Chicken", 6.00, restaurantID, R.drawable.chicken));
//        mealList.add(new Meals("Large Nuggets", 10.25, restaurantID, R.drawable.nuggets));
//        mealList.add(new Meals("XL Fries", 3.20, restaurantID, R.drawable.fries));
//        mealList.add(new Meals("XL Chicken", 6.00, restaurantID, R.drawable.chicken));
//        mealList.add(new Meals("XL Nuggets", 10.25, restaurantID, R.drawable.nuggets));
//
//        Log.d("DEBUG", "Added KFC Meals");
//
//        return mealList;
//    }
//
//    public List<Meals> HungryJacks(List<Meals> mealList)
//    {
//        int restaurantID = restaurantDBModel.getId("Hungry Jacks");
//
//        mealList.add(new Meals("Small Fries", 3.20, restaurantID, R.drawable.fries));
//        mealList.add(new Meals("Small Mac", 6.00, restaurantID, R.drawable.bigmac));
//        mealList.add(new Meals("5 Nuggets", 10.25, restaurantID, R.drawable.nuggets));
//        mealList.add(new Meals("Medium Fries", 3.20, restaurantID, R.drawable.fries));
//        mealList.add(new Meals("Medium Mac", 6.00, restaurantID, R.drawable.bigmac));
//        mealList.add(new Meals("10 Nuggets", 10.25, restaurantID, R.drawable.nuggets));
//        mealList.add(new Meals("Large Fries", 3.20, restaurantID, R.drawable.fries));
//        mealList.add(new Meals("Big Mac", 6.00, restaurantID, R.drawable.bigmac));
//        mealList.add(new Meals("20 Nuggets", 10.25, restaurantID, R.drawable.nuggets));
//        mealList.add(new Meals("XL Fries", 3.20, restaurantID, R.drawable.fries));
//        mealList.add(new Meals("Monster Mac", 6.00, restaurantID, R.drawable.cheeseburger));
//        mealList.add(new Meals("50 Nuggets", 10.25, restaurantID, R.drawable.nuggets));
//
//        Log.d("DEBUG", "Added Jacks Meals");
//
//        return mealList;
//    }
//
//    public List<Meals> Grilld(List<Meals> mealList)
//    {
//        int restaurantID = restaurantDBModel.getId("Grill'd");
//
//        mealList.add(new Meals("Small Fries", 3.20, restaurantID, R.drawable.fries));
//        mealList.add(new Meals("Small Burger", 6.00, restaurantID, R.drawable.cheeseburger));
//        mealList.add(new Meals("Small Burger2", 10.25, restaurantID, R.drawable.niceburger));
//        mealList.add(new Meals("Medium Fries", 3.20, restaurantID, R.drawable.fries));
//        mealList.add(new Meals("Medium Burger", 6.00, restaurantID, R.drawable.cheeseburger));
//        mealList.add(new Meals("Medium Burger2", 10.25, restaurantID, R.drawable.niceburger));
//        mealList.add(new Meals("Large Fries", 3.20, restaurantID, R.drawable.fries));
//        mealList.add(new Meals("Large Burger", 6.00, restaurantID, R.drawable.cheeseburger));
//        mealList.add(new Meals("Large Burger2", 10.25, restaurantID, R.drawable.niceburger));
//        mealList.add(new Meals("XL Fries", 3.20, restaurantID, R.drawable.fries));
//        mealList.add(new Meals("XL Burger", 6.00, restaurantID, R.drawable.cheeseburger));
//        mealList.add(new Meals("XL Burger2", 10.25, restaurantID, R.drawable.niceburger));
//
//        Log.d("DEBUG", "Added Grill'd Meals");
//
//        return mealList;
//    }
//
//    public List<Meals> MadMex(List<Meals> mealList)
//    {
//        int restaurantID = restaurantDBModel.getId("Mad Mex");
//
//        mealList.add(new Meals("Small Burrito", 3.20, restaurantID, R.drawable.burrito));
//        mealList.add(new Meals("Small Burrito2", 6.00, restaurantID, R.drawable.burrito2));
//        mealList.add(new Meals("Small Tacos", 10.25, restaurantID, R.drawable.taco));
//        mealList.add(new Meals("Medium Burrito", 3.20, restaurantID, R.drawable.burrito));
//        mealList.add(new Meals("Medium Burrito2", 6.00, restaurantID, R.drawable.burrito2));
//        mealList.add(new Meals("Medium Tacos", 10.25, restaurantID, R.drawable.taco));
//        mealList.add(new Meals("Large Burrito", 3.20, restaurantID, R.drawable.burrito));
//        mealList.add(new Meals("Large Burrito2", 6.00, restaurantID, R.drawable.burrito2));
//        mealList.add(new Meals("Large Tacos", 10.25, restaurantID, R.drawable.taco));
//        mealList.add(new Meals("XL Burrito", 3.20, restaurantID, R.drawable.burrito));
//        mealList.add(new Meals("XL Burrito2", 6.00, restaurantID, R.drawable.burrito2));
//        mealList.add(new Meals("XL Tacos", 10.25, restaurantID, R.drawable.taco));
//
//        Log.d("DEBUG", "Added Grill'd Meals");
//
//        return mealList;
//    }
//
//    public List<Meals> Nandos(List<Meals> mealList)
//    {
//        int restaurantID = restaurantDBModel.getId("Nandos");
//
//        mealList.add(new Meals("Small Fries", 3.20, restaurantID, R.drawable.fries));
//        mealList.add(new Meals("Small Burger", 6.00, restaurantID, R.drawable.niceburger));
//        mealList.add(new Meals("Small Chicken", 10.25, restaurantID, R.drawable.chicken));
//        mealList.add(new Meals("Medium Fries", 3.20, restaurantID, R.drawable.fries));
//        mealList.add(new Meals("Medium Burger", 6.00, restaurantID, R.drawable.niceburger));
//        mealList.add(new Meals("Medium Chicken", 10.25, restaurantID, R.drawable.chicken));
//        mealList.add(new Meals("Large Fries", 3.20, restaurantID, R.drawable.fries));
//        mealList.add(new Meals("Large Burger", 6.00, restaurantID, R.drawable.niceburger));
//        mealList.add(new Meals("Large Chicken", 10.25, restaurantID, R.drawable.chicken));
//        mealList.add(new Meals("XL Fries", 3.20, restaurantID, R.drawable.fries));
//        mealList.add(new Meals("XL Burger", 6.00, restaurantID, R.drawable.niceburger));
//        mealList.add(new Meals("XL Chicken", 10.25, restaurantID, R.drawable.chicken));
//
//        Log.d("DEBUG", "Added Nandos Meals");
//
//        return mealList;
//    }
//
//    public List<Meals> PizzaHut(List<Meals> mealList)
//    {
//        int restaurantID = restaurantDBModel.getId("Pizza Hut");
//
//        mealList.add(new Meals("Small Cheese Pizza", 5.20, restaurantID, R.drawable.cheesepizza));
//        mealList.add(new Meals("Small Pepperoni Pizza", 4.99, restaurantID, R.drawable.peppizza));
//        mealList.add(new Meals("Small Supreme Pizza", 6.70, restaurantID, R.drawable.suppizza));
//        mealList.add(new Meals("Medium Cheese Pizza", 5.20, restaurantID, R.drawable.cheesepizza));
//        mealList.add(new Meals("Medium Pepperoni Pizza", 4.99, restaurantID, R.drawable.peppizza));
//        mealList.add(new Meals("Medium Supreme Pizza", 6.70, restaurantID, R.drawable.suppizza));
//        mealList.add(new Meals("Large Cheese Pizza", 5.20, restaurantID, R.drawable.cheesepizza));
//        mealList.add(new Meals("Large Pepperoni Pizza", 4.99, restaurantID, R.drawable.peppizza));
//        mealList.add(new Meals("Large Supreme Pizza", 6.70, restaurantID, R.drawable.suppizza));
//        mealList.add(new Meals("XL Cheese Pizza", 5.20, restaurantID, R.drawable.cheesepizza));
//        mealList.add(new Meals("XL Pepperoni Pizza", 4.99, restaurantID, R.drawable.peppizza));
//        mealList.add(new Meals("XL Supreme Pizza", 6.70, restaurantID, R.drawable.suppizza));
//
//        Log.d("DEBUG", "Added PizzaHut Meals");
//
//        return mealList;
//    }
//
//    public List<Meals> Subway(List<Meals> mealList)
//    {
//        int restaurantID = restaurantDBModel.getId("Subway");
//
//        mealList.add(new Meals("Chicken Sub", 6.20, restaurantID, R.drawable.subfood));
//        mealList.add(new Meals("Beef Sub", 5.20, restaurantID, R.drawable.subfood));
//        mealList.add(new Meals("Veggie Sub", 1.20, restaurantID, R.drawable.subfood));
//        mealList.add(new Meals("Meatball Sub", 8.20, restaurantID, R.drawable.subfood));
//        mealList.add(new Meals("Bread Sub", 6.20, restaurantID, R.drawable.subfood));
//        mealList.add(new Meals("Pork Sub", 8.20, restaurantID, R.drawable.subfood));
//        mealList.add(new Meals("Sub Sub", 4.20, restaurantID, R.drawable.subfood));
//        mealList.add(new Meals("Vietnamese Sub", 9.20, restaurantID, R.drawable.subfood));
//        mealList.add(new Meals("American Sub", 8.20, restaurantID, R.drawable.subfood));
//        mealList.add(new Meals("Duck Sub", 7.20, restaurantID, R.drawable.subfood));
//        mealList.add(new Meals("Deer Sub", 5.20, restaurantID, R.drawable.subfood));
//        mealList.add(new Meals("Cheese Sub", 7.20, restaurantID, R.drawable.subfood));
//        mealList.add(new Meals("Mushroom Sub", 9.20, restaurantID, R.drawable.subfood));
//
//
//        Log.d("DEBUG", "Added Subway Meals");
//
//        return mealList;
//    }
//
//    public List<Meals> TacoBell(List<Meals> mealList)
//    {
//        int restaurantID = restaurantDBModel.getId("Taco Bell");
//
//        mealList.add(new Meals("Small Fries", 3.20, restaurantID, R.drawable.fries));
//        mealList.add(new Meals("Small Burger", 6.00, restaurantID, R.drawable.niceburger));
//        mealList.add(new Meals("Small Taco", 10.25, restaurantID, R.drawable.chicken));
//        mealList.add(new Meals("Medium Fries", 3.20, restaurantID, R.drawable.fries));
//        mealList.add(new Meals("Medium Burger", 6.00, restaurantID, R.drawable.niceburger));
//        mealList.add(new Meals("Medium Taco", 10.25, restaurantID, R.drawable.chicken));
//        mealList.add(new Meals("Large Fries", 3.20, restaurantID, R.drawable.fries));
//        mealList.add(new Meals("Large Burger", 6.00, restaurantID, R.drawable.niceburger));
//        mealList.add(new Meals("Large Taco", 10.25, restaurantID, R.drawable.chicken));
//        mealList.add(new Meals("XL Fries", 3.20, restaurantID, R.drawable.fries));
//        mealList.add(new Meals("XL Burger", 6.00, restaurantID, R.drawable.niceburger));
//        mealList.add(new Meals("XL Taco", 10.25, restaurantID, R.drawable.chicken));
//
//        Log.d("DEBUG", "Added Taco Bell meals");
//
//        return mealList;
//    }
//
//    public List<Meals> Zambrero(List<Meals> mealList)
//    {
//        int restaurantID = restaurantDBModel.getId("Zambrero");
//
//        mealList.add(new Meals("Small Burrito", 3.20, restaurantID, R.drawable.burrito));
//        mealList.add(new Meals("Small Burrito2", 6.00, restaurantID, R.drawable.burrito2));
//        mealList.add(new Meals("Small Tacos", 10.25, restaurantID, R.drawable.taco));
//        mealList.add(new Meals("Medium Burrito", 3.20, restaurantID, R.drawable.burrito));
//        mealList.add(new Meals("Medium Burrito2", 6.00, restaurantID, R.drawable.burrito2));
//        mealList.add(new Meals("Medium Tacos", 10.25, restaurantID, R.drawable.taco));
//        mealList.add(new Meals("Large Burrito", 3.20, restaurantID, R.drawable.burrito));
//        mealList.add(new Meals("Large Burrito2", 6.00, restaurantID, R.drawable.burrito2));
//        mealList.add(new Meals("Large Tacos", 10.25, restaurantID, R.drawable.taco));
//        mealList.add(new Meals("XL Burrito", 3.20, restaurantID, R.drawable.burrito));
//        mealList.add(new Meals("XL Burrito2", 6.00, restaurantID, R.drawable.burrito2));
//        mealList.add(new Meals("XL Tacos", 10.25, restaurantID, R.drawable.taco));
//
//        Log.d("DEBUG", "Added Zambrero meals");
//
//        return mealList;
//    }



}

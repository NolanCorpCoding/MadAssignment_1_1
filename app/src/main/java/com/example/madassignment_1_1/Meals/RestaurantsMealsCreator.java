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
        KFC(mealList);
        FiveGuys(mealList);
        Grilld(mealList);
        MadMex(mealList);
        Zambrero(mealList);
        Nandos(mealList);
        TacoBell(mealList);
        PizzaHut(mealList);
        HungryJacks(mealList);
        Subway(mealList);


        // make sure you double check the name of the restaurant ID!!!

        return mealList;
    }


    public List<Meals> DominosMeals(List<Meals> mealList)
    {
        int restaurantID = restaurantDBModel.getId("Dominos");

        mealList.add(new Meals(1, "Small Cheese Pizza", 5.20, restaurantID, R.drawable.cheesepizza));
        mealList.add(new Meals(2, "Small Pepperoni Pizza", 4.99, restaurantID, R.drawable.peppizza));
        mealList.add(new Meals(3, "Small Supreme Pizza", 6.70, restaurantID, R.drawable.suppizza));
        mealList.add(new Meals(4, "Medium Cheese Pizza", 5.20, restaurantID, R.drawable.cheesepizza));
        mealList.add(new Meals(5, "Medium Pepperoni Pizza", 4.99, restaurantID, R.drawable.peppizza));
        mealList.add(new Meals(6, "Medium Supreme Pizza", 6.70, restaurantID, R.drawable.suppizza));
        mealList.add(new Meals(7, "Large Cheese Pizza", 5.20, restaurantID, R.drawable.cheesepizza));
        mealList.add(new Meals(8, "Large Pepperoni Pizza", 4.99, restaurantID, R.drawable.peppizza));
        mealList.add(new Meals(9, "Large Supreme Pizza", 6.70, restaurantID, R.drawable.suppizza));
        mealList.add(new Meals(10, "XL Cheese Pizza", 5.20, restaurantID, R.drawable.cheesepizza));
        mealList.add(new Meals(11, "XL Pepperoni Pizza", 4.99, restaurantID, R.drawable.peppizza));
        mealList.add(new Meals(12, "XL Supreme Pizza", 6.70, restaurantID, R.drawable.suppizza));
        Log.d("DEBUG", "Added Dominos Meals");

        return mealList;
    }

    public List<Meals> MaccasMeals(List<Meals> mealList)
    {
        int restaurantID = restaurantDBModel.getId("McDonalds");

        mealList.add(new Meals(13, "Small Fries", 3.20, restaurantID, R.drawable.fries));
        mealList.add(new Meals(14, "Small Mac", 6.00, restaurantID, R.drawable.bigmac));
        mealList.add(new Meals(15,"5 Nuggets", 10.25, restaurantID, R.drawable.nuggets));
        mealList.add(new Meals(16,"Medium Fries", 3.20, restaurantID, R.drawable.fries));
        mealList.add(new Meals(17,"Medium Mac", 6.00, restaurantID, R.drawable.bigmac));
        mealList.add(new Meals(18,"10 Nuggets", 10.25, restaurantID, R.drawable.nuggets));
        mealList.add(new Meals(19,"Large Fries", 3.20, restaurantID, R.drawable.fries));
        mealList.add(new Meals(20,"Big Mac", 6.00, restaurantID, R.drawable.bigmac));
        mealList.add(new Meals(21,"20 Nuggets", 10.25, restaurantID, R.drawable.nuggets));
        mealList.add(new Meals(22,"XL Fries", 3.20, restaurantID, R.drawable.fries));
        mealList.add(new Meals(23,"Monster Mac", 6.00, restaurantID, R.drawable.cheeseburger));
        mealList.add(new Meals(24, "50 Nuggets", 10.25, restaurantID, R.drawable.nuggets));
        Log.d("DEBUG", "Added Maccas Meals");

        return mealList;
    }

    public List<Meals> FiveGuys(List<Meals> mealList)
    {
        int restaurantID = restaurantDBModel.getId("Five Guys");

        mealList.add(new Meals(25, "Small Fries", 3.20, restaurantID, R.drawable.fries));
        mealList.add(new Meals(26, "Small Burger", 6.00, restaurantID, R.drawable.cheeseburger));
        mealList.add(new Meals(27, "Small Shake", 10.25, restaurantID, R.drawable.milkshake));
        mealList.add(new Meals(28, "Medium Fries", 3.20, restaurantID, R.drawable.fries));
        mealList.add(new Meals(29, "Medium Burger", 6.00, restaurantID, R.drawable.cheeseburger));
        mealList.add(new Meals(30,"Medium Shake", 10.25, restaurantID, R.drawable.milkshake));
        mealList.add(new Meals(31,"Large Fries", 3.20, restaurantID, R.drawable.fries));
        mealList.add(new Meals(32,"Large Burger", 6.00, restaurantID, R.drawable.cheeseburger));
        mealList.add(new Meals(33,"Large Shake", 10.25, restaurantID, R.drawable.milkshake));
        mealList.add(new Meals(34,"XL Fries", 3.20, restaurantID, R.drawable.fries));
        mealList.add(new Meals(35,"XL Burger", 6.00, restaurantID, R.drawable.cheeseburger));
        mealList.add(new Meals(36,"XL Shake", 10.25, restaurantID, R.drawable.milkshake));
        Log.d("DEBUG", "Added 5 guys Meals");

        return mealList;
    }

    public List<Meals> KFC(List<Meals> mealList)
    {
        int restaurantID = restaurantDBModel.getId("KFC");

        mealList.add(new Meals(37,"Small Fries", 3.20, restaurantID, R.drawable.fries));
        mealList.add(new Meals(38,"Small Chicken", 6.00, restaurantID, R.drawable.chicken));
        mealList.add(new Meals(39,"Small Nuggets", 10.25, restaurantID, R.drawable.nuggets));
        mealList.add(new Meals(40,"Medium Fries", 3.20, restaurantID, R.drawable.fries));
        mealList.add(new Meals(41,"Medium Chicken", 6.00, restaurantID, R.drawable.chicken));
        mealList.add(new Meals(42,"Medium Nuggets", 10.25, restaurantID, R.drawable.nuggets));
        mealList.add(new Meals(43,"Large Fries", 3.20, restaurantID, R.drawable.fries));
        mealList.add(new Meals(44,"Large Chicken", 6.00, restaurantID, R.drawable.chicken));
        mealList.add(new Meals(45,"Large Nuggets", 10.25, restaurantID, R.drawable.nuggets));
        mealList.add(new Meals(46,"XL Fries", 3.20, restaurantID, R.drawable.fries));
        mealList.add(new Meals(47,"XL Chicken", 6.00, restaurantID, R.drawable.chicken));
        mealList.add(new Meals(48,"XL Nuggets", 10.25, restaurantID, R.drawable.nuggets));

        Log.d("DEBUG", "Added KFC Meals");

        return mealList;
    }

    public List<Meals> HungryJacks(List<Meals> mealList)
    {
        int restaurantID = restaurantDBModel.getId("Hungry Jacks");

        mealList.add(new Meals(49,"Small Fries", 3.20, restaurantID, R.drawable.fries));
        mealList.add(new Meals(50,"Small Mac", 6.00, restaurantID, R.drawable.bigmac));
        mealList.add(new Meals(51,"5 Nuggets", 10.25, restaurantID, R.drawable.nuggets));
        mealList.add(new Meals(52,"Medium Fries", 3.20, restaurantID, R.drawable.fries));
        mealList.add(new Meals(53,"Medium Mac", 6.00, restaurantID, R.drawable.bigmac));
        mealList.add(new Meals(54,"10 Nuggets", 10.25, restaurantID, R.drawable.nuggets));
        mealList.add(new Meals(55,"Large Fries", 3.20, restaurantID, R.drawable.fries));
        mealList.add(new Meals(56,"Big Mac", 6.00, restaurantID, R.drawable.bigmac));
        mealList.add(new Meals(57,"20 Nuggets", 10.25, restaurantID, R.drawable.nuggets));
        mealList.add(new Meals(58,"XL Fries", 3.20, restaurantID, R.drawable.fries));
        mealList.add(new Meals(59,"Monster Mac", 6.00, restaurantID, R.drawable.cheeseburger));
        mealList.add(new Meals(60, "50 Nuggets", 10.25, restaurantID, R.drawable.nuggets));

        Log.d("DEBUG", "Added Jacks Meals");

        return mealList;
    }

    public List<Meals> Grilld(List<Meals> mealList)
    {
        int restaurantID = restaurantDBModel.getId("Grill'd");

        Log.d("testingtesting", "Restaurant ID inside Grill'd: " + restaurantID);

        mealList.add(new Meals(61, "Small Fries", 3.20, restaurantID, R.drawable.fries));
        mealList.add(new Meals(62, "Small Burger", 6.00, restaurantID, R.drawable.cheeseburger));
        mealList.add(new Meals(63, "Small Burger2", 10.25, restaurantID, R.drawable.niceburger));
        mealList.add(new Meals(64, "Medium Fries", 3.20, restaurantID, R.drawable.fries));
        mealList.add(new Meals(65, "Medium Burger", 6.00, restaurantID, R.drawable.cheeseburger));
        mealList.add(new Meals(66, "Medium Burger2", 10.25, restaurantID, R.drawable.niceburger));
        mealList.add(new Meals(67, "Large Fries", 3.20, restaurantID, R.drawable.fries));
        mealList.add(new Meals(68, "Large Burger", 6.00, restaurantID, R.drawable.cheeseburger));
        mealList.add(new Meals(69, "Large Burger2", 10.25, restaurantID, R.drawable.niceburger));
        mealList.add(new Meals(70,"XL Fries", 3.20, restaurantID, R.drawable.fries));
        mealList.add(new Meals(71,"XL Burger", 6.00, restaurantID, R.drawable.cheeseburger));
        mealList.add(new Meals(72,"XL Burger2", 10.25, restaurantID, R.drawable.niceburger));

        Log.d("DEBUG", "Added Grill'd Meals");

        return mealList;
    }

    public List<Meals> MadMex(List<Meals> mealList)
    {
        int restaurantID = restaurantDBModel.getId("Mad Mex");

        Log.d("testingtesting", "Restaurant ID inside MadMex: " + restaurantID);

        mealList.add(new Meals(73,"Small Burrito", 3.20, restaurantID, R.drawable.burrito));
        mealList.add(new Meals(74,"Small Burrito2", 6.00, restaurantID, R.drawable.burrito2));
        mealList.add(new Meals(75,"Small Tacos", 10.25, restaurantID, R.drawable.taco));
        mealList.add(new Meals(76,"Medium Burrito", 3.20, restaurantID, R.drawable.burrito));
        mealList.add(new Meals(77,"Medium Burrito2", 6.00, restaurantID, R.drawable.burrito2));
        mealList.add(new Meals(78,"Medium Tacos", 10.25, restaurantID, R.drawable.taco));
        mealList.add(new Meals(79,"Large Burrito", 3.20, restaurantID, R.drawable.burrito));
        mealList.add(new Meals(80,"Large Burrito2", 6.00, restaurantID, R.drawable.burrito2));
        mealList.add(new Meals(81,"Large Tacos", 10.25, restaurantID, R.drawable.taco));
        mealList.add(new Meals(82,"XL Burrito", 3.20, restaurantID, R.drawable.burrito));
        mealList.add(new Meals(83,"XL Burrito2", 6.00, restaurantID, R.drawable.burrito2));
        mealList.add(new Meals(84,"XL Tacos", 10.25, restaurantID, R.drawable.taco));

        Log.d("DEBUG", "Added Grill'd Meals");

        return mealList;
    }

    public List<Meals> Nandos(List<Meals> mealList)
    {
        int restaurantID = restaurantDBModel.getId("Nandos");


        mealList.add(new Meals(85,"Small Fries", 3.20, restaurantID, R.drawable.fries));
        mealList.add(new Meals(86,"Small Burger", 6.00, restaurantID, R.drawable.niceburger));
        mealList.add(new Meals(87,"Small Chicken", 10.25, restaurantID, R.drawable.chicken));
        mealList.add(new Meals(88,"Medium Fries", 3.20, restaurantID, R.drawable.fries));
        mealList.add(new Meals(89,"Medium Burger", 6.00, restaurantID, R.drawable.niceburger));
        mealList.add(new Meals(90,"Medium Chicken", 10.25, restaurantID, R.drawable.chicken));
        mealList.add(new Meals(91,"Large Fries", 3.20, restaurantID, R.drawable.fries));
        mealList.add(new Meals(92,"Large Burger", 6.00, restaurantID, R.drawable.niceburger));
        mealList.add(new Meals(93,"Large Chicken", 10.25, restaurantID, R.drawable.chicken));
        mealList.add(new Meals(94,"XL Fries", 3.20, restaurantID, R.drawable.fries));
        mealList.add(new Meals(95,"XL Burger", 6.00, restaurantID, R.drawable.niceburger));
        mealList.add(new Meals(96,"XL Chicken", 10.25, restaurantID, R.drawable.chicken));

        Log.d("DEBUG", "Added Nandos Meals");

        return mealList;
    }

    public List<Meals> PizzaHut(List<Meals> mealList)
    {
        int restaurantID = restaurantDBModel.getId("Pizza Hut");

        mealList.add(new Meals(97,"Small Cheese Pizza", 5.20, restaurantID, R.drawable.cheesepizza));
        mealList.add(new Meals(98,"Small Pepperoni Pizza", 4.99, restaurantID, R.drawable.peppizza));
        mealList.add(new Meals(99,"Small Supreme Pizza", 6.70, restaurantID, R.drawable.suppizza));
        mealList.add(new Meals(100,"Medium Cheese Pizza", 5.20, restaurantID, R.drawable.cheesepizza));
        mealList.add(new Meals(101,"Medium Pepperoni Pizza", 4.99, restaurantID, R.drawable.peppizza));
        mealList.add(new Meals(102,"Medium Supreme Pizza", 6.70, restaurantID, R.drawable.suppizza));
        mealList.add(new Meals(103,"Large Cheese Pizza", 5.20, restaurantID, R.drawable.cheesepizza));
        mealList.add(new Meals(104,"Large Pepperoni Pizza", 4.99, restaurantID, R.drawable.peppizza));
        mealList.add(new Meals(105,"Large Supreme Pizza", 6.70, restaurantID, R.drawable.suppizza));
        mealList.add(new Meals(106,"XL Cheese Pizza", 5.20, restaurantID, R.drawable.cheesepizza));
        mealList.add(new Meals(107,"XL Pepperoni Pizza", 4.99, restaurantID, R.drawable.peppizza));
        mealList.add(new Meals(108,"XL Supreme Pizza", 6.70, restaurantID, R.drawable.suppizza));

        Log.d("DEBUG", "Added PizzaHut Meals");

        return mealList;
    }

    public List<Meals> Subway(List<Meals> mealList)
    {
        int restaurantID = restaurantDBModel.getId("Subway");

        mealList.add(new Meals(109,"Chicken Sub", 6.20, restaurantID, R.drawable.subfood));
        mealList.add(new Meals(110,"Beef Sub", 5.20, restaurantID, R.drawable.subfood));
        mealList.add(new Meals(111,"Veggie Sub", 1.20, restaurantID, R.drawable.subfood));
        mealList.add(new Meals(112,"Meatball Sub", 8.20, restaurantID, R.drawable.subfood));
        mealList.add(new Meals(113,"Bread Sub", 6.20, restaurantID, R.drawable.subfood));
        mealList.add(new Meals(114,"Pork Sub", 8.20, restaurantID, R.drawable.subfood));
        mealList.add(new Meals(115,"Sub Sub", 4.20, restaurantID, R.drawable.subfood));
        mealList.add(new Meals(116,"Vietnamese Sub", 9.20, restaurantID, R.drawable.subfood));
        mealList.add(new Meals(117,"American Sub", 8.20, restaurantID, R.drawable.subfood));
        mealList.add(new Meals(118,"Duck Sub", 7.20, restaurantID, R.drawable.subfood));
        mealList.add(new Meals(119,"Deer Sub", 5.20, restaurantID, R.drawable.subfood));
        mealList.add(new Meals(120,"Cheese Sub", 7.20, restaurantID, R.drawable.subfood));
        mealList.add(new Meals(121,"Mushroom Sub", 9.20, restaurantID, R.drawable.subfood));


        Log.d("DEBUG", "Added Subway Meals");

        return mealList;
    }

    public List<Meals> TacoBell(List<Meals> mealList)
    {
        int restaurantID = restaurantDBModel.getId("Taco Bell");

        mealList.add(new Meals(122,"Small Fries", 3.20, restaurantID, R.drawable.fries));
        mealList.add(new Meals(123,"Small Burger", 6.00, restaurantID, R.drawable.niceburger));
        mealList.add(new Meals(124,"Small Taco", 10.25, restaurantID, R.drawable.chicken));
        mealList.add(new Meals(125,"Medium Fries", 3.20, restaurantID, R.drawable.fries));
        mealList.add(new Meals(126,"Medium Burger", 6.00, restaurantID, R.drawable.niceburger));
        mealList.add(new Meals(127,"Medium Taco", 10.25, restaurantID, R.drawable.chicken));
        mealList.add(new Meals(128,"Large Fries", 3.20, restaurantID, R.drawable.fries));
        mealList.add(new Meals(129,"Large Burger", 6.00, restaurantID, R.drawable.niceburger));
        mealList.add(new Meals(130,"Large Taco", 10.25, restaurantID, R.drawable.chicken));
        mealList.add(new Meals(131,"XL Fries", 3.20, restaurantID, R.drawable.fries));
        mealList.add(new Meals(132,"XL Burger", 6.00, restaurantID, R.drawable.niceburger));
        mealList.add(new Meals(133,"XL Taco", 10.25, restaurantID, R.drawable.chicken));

        Log.d("DEBUG", "Added Taco Bell meals");

        return mealList;
    }

    public List<Meals> Zambrero(List<Meals> mealList)
    {
        int restaurantID = restaurantDBModel.getId("Zambrero");

        mealList.add(new Meals(134,"Small Burrito", 3.20, restaurantID, R.drawable.burrito));
        mealList.add(new Meals(135,"Small Burrito2", 6.00, restaurantID, R.drawable.burrito2));
        mealList.add(new Meals(136,"Small Tacos", 10.25, restaurantID, R.drawable.taco));
        mealList.add(new Meals(137,"Medium Burrito", 3.20, restaurantID, R.drawable.burrito));
        mealList.add(new Meals(138,"Medium Burrito2", 6.00, restaurantID, R.drawable.burrito2));
        mealList.add(new Meals(139,"Medium Tacos", 10.25, restaurantID, R.drawable.taco));
        mealList.add(new Meals(140,"Large Burrito", 3.20, restaurantID, R.drawable.burrito));
        mealList.add(new Meals(141,"Large Burrito2", 6.00, restaurantID, R.drawable.burrito2));
        mealList.add(new Meals(142,"Large Tacos", 10.25, restaurantID, R.drawable.taco));
        mealList.add(new Meals(143,"XL Burrito", 3.20, restaurantID, R.drawable.burrito));
        mealList.add(new Meals(144,"XL Burrito2", 6.00, restaurantID, R.drawable.burrito2));
        mealList.add(new Meals(145,"XL Tacos", 10.25, restaurantID, R.drawable.taco));

        Log.d("DEBUG", "Added Zambrero meals");

        return mealList;
    }



}

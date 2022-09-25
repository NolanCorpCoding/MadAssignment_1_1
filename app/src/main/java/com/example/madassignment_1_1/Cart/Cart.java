package com.example.madassignment_1_1.Cart;

import android.content.Context;

import com.example.madassignment_1_1.CartMenuItem.CartMenuItem;
import com.example.madassignment_1_1.CartMenuItem.CartMenuItemDBModel;
import com.example.madassignment_1_1.Meals.MealItemDBModel;
import com.example.madassignment_1_1.Meals.Meals;
import com.example.madassignment_1_1.Meals.MealsList;

import java.util.ArrayList;

public class Cart {
    public final int id;
    private double totalPrice;
    private final int userAccountID;
    private String orderTime;
    private ArrayList<CartMenuItem> menuItemList;
//    private boolean currentCart; -- can make it that the current cart is the 'current' instance of the cart inside
//    cartlist class instance

    public static int autoNextID = 1;

    public Cart(int pId, double pTotalPrice, int pUserAccountID, String pOrderTime)
    {
        this.id = pId;
        this.totalPrice = pTotalPrice;
        this.userAccountID = pUserAccountID;
        this.orderTime = pOrderTime;

        this.menuItemList = new ArrayList<>();

        autoNextID = id + 1;
    }

    public Cart(double pTotalPrice, int pUserAccountID)
    {
        this.id = autoNextID;
        this.totalPrice = pTotalPrice;
        this.userAccountID = pUserAccountID;
        this.orderTime = "";

        this.menuItemList = new ArrayList<>();

        autoNextID++;
    }

//    public void addMeal(CartMenuItem pMeal)
//    {
//        menuItemList.add(pMeal);
//    }

    public void addMeal(CartMenuItem pCartMenuItem, int quantity)
    {
        boolean found = false;
        for(CartMenuItem tempCartMenuItem : menuItemList)
        {
            if((tempCartMenuItem.getMenuItemID() == pCartMenuItem.getMenuItemID()) && (tempCartMenuItem.getCartID() == pCartMenuItem.getCartID()))
            {
                tempCartMenuItem.setQuantity(quantity);
                found = true;
            }
        }

        if(!found)
        {
            menuItemList.add(pCartMenuItem);
        }
    }



    public int getId() {return id;}

    public double getTotalPrice() {return totalPrice;}

    public int getUserAccountID() {return userAccountID;}


    public ArrayList<CartMenuItem> getMenuItemList() {return menuItemList;}

    public String getOrderTime() { return orderTime; }

    public void setTotalPrice(double totalPrice) {this.totalPrice = totalPrice;}

    public void calculateTotalPrice(Context context)
    {
        MealItemDBModel model = new MealItemDBModel();
        model.load(context);

        double tempTotal = 0;
        double tempCalc = 0;

        for(CartMenuItem item : menuItemList)
        {
            tempCalc = item.getQuantity() * model.findMeal(item.getMenuItemID()).getPrice();
            tempTotal = tempTotal + tempCalc;
        }

        totalPrice = Math.round(100.0*tempTotal)/100.0;
    }


}

package com.example.madassignment_1_1.Cart;

import com.example.madassignment_1_1.Meals.Meals;

import java.util.ArrayList;

public class Cart {
    public final int id;
    private double totalPrice;
    private final int userAccountID;
    private String orderTime;
    private ArrayList<Meals> menuItemList;
//    private boolean currentCart; -- can make it that the current cart is the 'current' instance of the cart inside
//    cartlist class instance

    public static int autoNextID = 0;

//    public Cart(int pId, double pTotalPrice, int pUserAccountID, String pOrderTime)
//    {
//        this.id = pId;
//        this.totalPrice = pTotalPrice;
//        this.userAccountID = pUserAccountID;
//        this.orderTime = pOrderTime;
//
//        autoNextID = id + 1;
//    }

    public Cart(double pTotalPrice, int pUserAccountID, String pOrderTime)
    {
        this.id = autoNextID;
        this.totalPrice = pTotalPrice;
        this.userAccountID = pUserAccountID;
        this.orderTime = pOrderTime;

        this.menuItemList = new ArrayList<>();

        autoNextID++;
    }

    public int getId() {return id;}

    public double getTotalPrice() {return totalPrice;}

    public int getUserAccountID() {return userAccountID;}

    public ArrayList<Meals> getMenuItemList() {return menuItemList;}

    public String getOrderTime() { return orderTime; }

    public void setTotalPrice(double totalPrice) {this.totalPrice = totalPrice;}
}

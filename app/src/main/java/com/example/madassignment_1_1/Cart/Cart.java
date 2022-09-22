package com.example.madassignment_1_1.Cart;

public class Cart {
    public final int id;
    private double totalPrice;
    private final int userAccountID;
    private final int restaurantID;
//    private boolean currentCart; -- can make it that the current cart is the 'current' instance of the cart inside
//    cartlist class instance

    public static int autoNextID = 0;

    public Cart(int pId, double pTotalPrice, int pUserAccountID, int pRestaurantID)
    {
        this.id = pId;
        this.totalPrice = pTotalPrice;
        this.userAccountID = pUserAccountID;
        this.restaurantID = pRestaurantID;

        autoNextID = id + 1;
    }

    public Cart(double pTotalPrice, int pUserAccountID, int pRestaurantID)
    {
        this(autoNextID, pTotalPrice, pUserAccountID, pRestaurantID);

        autoNextID++;
    }

    public int getId() {return id;}

    public double getTotalPrice() {return totalPrice;}

    public int getRestaurantID() {return restaurantID;}

    public int getUserAccountID() {return userAccountID;}

    public void setTotalPrice(double totalPrice) {this.totalPrice = totalPrice;}
}

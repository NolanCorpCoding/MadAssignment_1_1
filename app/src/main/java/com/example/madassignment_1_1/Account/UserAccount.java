package com.example.madassignment_1_1.Account;

import android.content.Context;
import android.util.Log;

import com.example.madassignment_1_1.Cart.Cart;
import com.example.madassignment_1_1.Cart.CartDBModel;

import java.util.ArrayList;

public class UserAccount
{
    private static int autoNextId = 0;

    public final int id;
    private String firstname;
    private String lastname;
    private String email;
    private String pass;
    private Cart currentCart;
    private int currentCartID;
    private ArrayList<Cart> previousCarts;

    public static void resetAutoNextId()
    {
        autoNextId = 0;
    }


    public UserAccount(int pId, String pFirstname, String pLastname, String pEmail, String pPass, int cartId)
    {
        CartDBModel cartDBModel = new CartDBModel();

        this.id = pId;
        this.firstname = pFirstname;
        this.lastname = pLastname;
        this.email = pEmail;
        this.pass = pPass;
        this.currentCartID = cartId;
//        currentCart = new Cart(0, this.id);

        previousCarts = new ArrayList<>();

        autoNextId = id + 1;
    }

    public UserAccount(String pFirstname, String pLastname, String pEmail, String pPass)
    {
        this.id = autoNextId;
        this.firstname = pFirstname;
        this.lastname = pLastname;
        this.email = pEmail;
        this.pass = pPass;
//        currentCart = new Cart(0, this.id);

        previousCarts = new ArrayList<>();

        autoNextId++;
    }

    public int getId()
    {
        return this.id;
    }

    public String getFirstname()
    {
        return this.firstname;
    }

    public String getLastname()
    {
        return this.lastname;
    }

    public String getEmail()
    {
        return this.email;
    }

    public String getPass() { return this.pass; }

    public void updateFirstname(String pFirstName)
    {
        this.firstname = pFirstName;
    }

    public void updateLastname(String pLastName)
    {
        this.lastname = pLastName;
    }

    public void updateEmail(String pEmail)
    {
        this.email = pEmail;
    }

    public void updatePass(String pPass) { this.pass = pPass; }

    public Cart getCurrentCart() { return currentCart; }

    public int getCurrentCartId() { return currentCartID; }

    public ArrayList<Cart> getPreviousCarts() { return previousCarts; }


    public void setEmail(String pEmail)
    {
        this.firstname = pEmail;
    }

    public void setPass(String pPass) { this.pass = pPass; }

    public void setCurrentCart(Cart currentCart) {
        this.currentCart = currentCart;
        this.currentCartID = currentCart.getId();
    }

    public void setCurrentCartID(int currentCartID) {
        this.currentCartID = currentCartID;
    }

    public void loadPrevCarts(Context context)
    {
        CartDBModel pCartDBModel = new CartDBModel();
        pCartDBModel.load(context);

        previousCarts.clear();

        for(Cart loopingCart : pCartDBModel.getAllCarts())
        {
            Log.d("LOOPINGDEBUG",
                    "Looping Cart: cartid=" + loopingCart.getId() + " userid= " + loopingCart.getUserAccountID() + "  VS  currentCart: cartid=" + this.getCurrentCartId() + " userid=" + this.getId());
            if((loopingCart.getUserAccountID() == this.id) && (loopingCart.getId() != this.currentCartID))
            {
                Log.d("LOOPINGDEBUG", "CART " + loopingCart.getId() + " belonging to " + loopingCart.getUserAccountID() + " ADDED");
                loopingCart.loadMeals(context);
                previousCarts.add(loopingCart);
            }
        }

        Log.d("LOOPINGDEBUG", "END LOOP : LIST SIZE =  " + previousCarts.size());
    }

}

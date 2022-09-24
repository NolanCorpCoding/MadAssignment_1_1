package com.example.madassignment_1_1.Account;

import android.util.Log;

import com.example.madassignment_1_1.Cart.Cart;

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
    private ArrayList<Cart> previousCarts;

    public static void resetAutoNextId()
    {
        autoNextId = 0;
    }


    public UserAccount(int pId, String pFirstname, String pLastname, String pEmail, String pPass)
    {
        this.id = pId;
        this.firstname = pFirstname;
        this.lastname = pLastname;
        this.email = pEmail;
        this.pass = pPass;

        autoNextId = id + 1;
    }

    public UserAccount(String pFirstname, String pLastname, String pEmail, String pPass)
    {
        this.id = autoNextId;
        this.firstname = pFirstname;
        this.lastname = pLastname;
        this.email = pEmail;
        this.pass = pPass;

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

    public ArrayList<Cart> getPreviousCarts() { return previousCarts; }

    public void setEmail(String pEmail)
    {
        this.firstname = pEmail;
    }

    public void setPass(String pPass) { this.pass = pPass; }
    
}

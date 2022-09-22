package com.example.madassignment_1_1.Account;

import android.util.Log;

import java.util.ArrayList;

public class UserAccount
{
    private static int autoNextId = 0;

    public final int id;
    private String firstname;
    private String lastname;
    private String email;
    private String pass;
//    private Cart currentCart;
//    private ArrayList<Cart> previousCarts;


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

    public void setFirstname(String pFirstname)
    {
        this.firstname = pFirstname;
    }

    public void setLastname(String pLastname)
    {
        this.firstname = pLastname;
    }

    public void setEmail(String pEmail)
    {
        this.firstname = pEmail;
    }

    public void setPass(String pPass) { this.pass = pPass; }
    
}

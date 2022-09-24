package com.example.madassignment_1_1.Account;

import android.content.Context;
import android.util.Log;

import com.example.madassignment_1_1.Cart.Cart;
import com.example.madassignment_1_1.Cart.CartDBModel;

import java.util.ArrayList;
import java.util.List;

public class UserAccountList {
    private List<UserAccount> userAccounts;
    UserAccountDBModel useraccountDBModel;

    private List<Cart> carts;
    CartDBModel cartDBModel;

    public void load(Context context)
    {
        userAccounts = new ArrayList<>();
        carts = new ArrayList<>();

        useraccountDBModel = new UserAccountDBModel();
        useraccountDBModel.load(context);

        cartDBModel = new CartDBModel();
        cartDBModel.load(context);

        userAccounts = useraccountDBModel.getAllUserAccounts();
        carts = cartDBModel.getAllCarts();

        Log.d("DEBUG", "User Accounts:");
        for(UserAccount acct : userAccounts)
        {
            Log.d("DEBUG", "id:" + acct.getId() + "  name:" + acct.getFirstname() + " " + acct.getLastname() + "  email:" + acct.getEmail());
        }
    }

    public UserAccountList() {}

    public UserAccount get(int i)
    {
        return userAccounts.get(i);
    }

    public int size()
    {
        return userAccounts.size();
    }


    public UserAccount findUser(String pFirstname, String pLastname, String pEmail, String pPass)
    {
        UserAccount returningUser = null;
        Cart cart = null;
        int idFound = useraccountDBModel.getIDByAllDetails(pFirstname, pLastname, pEmail);

        if(idFound == -1)
        {
            returningUser = new UserAccount(pFirstname, pLastname, pEmail, pPass);

            cart = new Cart(0, returningUser.getId());
            returningUser.setCurrentCart(cart);

            useraccountDBModel.addUserAccount(returningUser);
            cartDBModel.addCart(cart);

            Log.d("DEBUG", "CREATED the " +  returningUser.getCurrentCart().getId() + " cart for the user with the cart " + returningUser.getCurrentCart().getId());

        }
        else
        {
             for(UserAccount acct : userAccounts)
             {
                 if(acct.getId() == idFound)
                 {
                     returningUser = acct;
                 }
             }
        }

        return returningUser;
    }

    public UserAccount findUser(String pEmail, String pPass)
    {
        UserAccount returningUser = null;
        boolean found = false;
        int idFound = useraccountDBModel.getId(pEmail, pPass);

        if(idFound >= 0)
        {
            for(UserAccount acct : userAccounts)
            {
                if(acct.getId() == idFound)
                {
                    returningUser = acct;
                    returningUser.setCurrentCart(cartDBModel.findCart(acct.getCurrentCartId()));
                    Log.d("DEBUG", "FOUND THE USER TO LOG INTO ...");
                    Log.d("DEBUG", "The user's cart has an id of " + returningUser.getCurrentCartId() + " which actually is " + returningUser.getCurrentCart().getId());
                    found = true;
                }
            }
        }
        else
        {
            throw new IllegalArgumentException("User Details Incorrect");
        }

        if(!found)
        {
            throw new IllegalArgumentException("User Details Incorrect");

        }

        return returningUser;
    }

    public UserAccount findUser(int pId)
    {
        UserAccount returningUser = null;
        boolean found = false;

        if(pId >= 0)
        {
            for(UserAccount acct : userAccounts)
            {
                if(acct.getId() == pId)
                {
                    returningUser = acct;
                    found = true;
                }
            }
        }
        else
        {
            throw new IllegalArgumentException("User Details Incorrect");
        }

        if(!found)
        {
            throw new IllegalArgumentException("User Details Incorrect");

        }

        return returningUser;
    }

    public void updateUserAccount(UserAccount pUserAccount, String pFirstname, String pLastname, String pEmail, String pPass)
    {
        useraccountDBModel.updateUserAccount(pUserAccount, pFirstname, pLastname, pEmail, pPass);
    }




}

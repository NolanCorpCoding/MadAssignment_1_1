package com.example.madassignment_1_1.Cart;

import android.content.Context;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class CartList {
    private List<Cart> carts;
    private Cart currentCart;
    CartDBModel cartDBModel;

    public void load(Context context)
    {
        carts = new ArrayList<>();

        cartDBModel = new CartDBModel();
        cartDBModel.load(context);

        carts = cartDBModel.getAllCarts();

        if(cartDBModel.getNumTuples() <= 0)
        {
            Log.d("DEBUG", "CREATING NEW USERS");
//            addUsers();
        }
//        else
//        {
//            useraccountDBModel.getId("jamescarey@gmail.com", "jamescareypassword");
//            useraccountDBModel.getId("angusbrayshaw@htomail.com", "angusbrayshawpassword");
//            useraccountDBModel.getId("jacktyson@outlook.com", "jacktysonpassword");
//        }
        Log.d("DEBUG", "FINISHED LOADING DB");

    }


    protected CartList() {}

    public Cart get(int i)
    {
        return carts.get(i);
    }

    public int size()
    {
        return carts.size();
    }

}

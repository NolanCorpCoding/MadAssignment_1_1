package com.example.madassignment_1_1.Account;

import android.content.Context;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class UserAccountList {
    private List<UserAccount> userAccounts;
    UserAccountDBModel useraccountDBModel;

    public void load(Context context)
    {
        userAccounts = new ArrayList<>();

        useraccountDBModel = new UserAccountDBModel();
        useraccountDBModel.load(context);

        userAccounts = useraccountDBModel.getAllUserAccounts();

        if(useraccountDBModel.getNumTuples() <= 0)
        {
            Log.d("DEBUG", "CREATING NEW USERS");
            addUsers();
        }
        else
        {
            useraccountDBModel.getId("jamescarey@gmail.com", "jamescareypassword");
            useraccountDBModel.getId("angusbrayshaw@htomail.com", "angusbrayshawpassword");
            useraccountDBModel.getId("jacktyson@outlook.com", "jacktysonpassword");
        }
        Log.d("DEBUG", "FINISHED LOADING DB");

    }

    private void addUsers()
    {
        useraccountDBModel.addRestaurant(new UserAccount(1, "James", "Carey", "jamescarey@gmail.com", "jamescareypassword"));
        useraccountDBModel.addRestaurant(new UserAccount(2, "Angus", "Brayshaw", "angusbrayshaw@htomail.com", "angusbrayshawpassword"));
        useraccountDBModel.addRestaurant(new UserAccount(3, "Jack", "Tyson", "jacktyson@outlook.com", "jacktysonpassword"));
    }


    protected UserAccountList() {}

    public UserAccount get(int i)
    {
        return userAccounts.get(i);
    }

    public int size()
    {
        return userAccounts.size();
    }

}

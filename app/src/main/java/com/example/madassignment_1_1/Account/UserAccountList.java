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

        Log.d("DEBUG", "User Accounts:");
        for(UserAccount acct : userAccounts)
        {
            Log.d("DEBUG", "id:" + acct.getId() + "  name:" + acct.getFirstname() + " " + acct.getLastname() + "  email:" + acct.getEmail());
        }

        if(useraccountDBModel.getNumTuples() <= 0)
        {
            Log.d("DEBUG", "CREATING NEW USERS");
            addUsers();
        }
        else
        {
//            useraccountDBModel.getId("jamescarey@gmail.com", "jamescareypassword");
//            useraccountDBModel.getId("angusbrayshaw@htomail.com", "angusbrayshawpassword");
//            useraccountDBModel.getId("jacktyson@outlook.com", "jacktysonpassword");
        }
        Log.d("DEBUG", "FINISHED LOADING DB");

    }

    private void addUsers()
    {
//        useraccountDBModel.addRestaurant(new UserAccount(1, "James", "Carey", "jamescarey@gmail.com", "jamescareypassword"));
//        useraccountDBModel.addRestaurant(new UserAccount(2, "Angus", "Brayshaw", "angusbrayshaw@htomail.com", "angusbrayshawpassword"));
//        useraccountDBModel.addRestaurant(new UserAccount(3, "Jack", "Tyson", "jacktyson@outlook.com", "jacktysonpassword"));
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


    public UserAccount findUser(String pFirstname, String pLastname, String pEmail, String pPass)
    {
        UserAccount returningUser = null;
        int idFound = useraccountDBModel.getIDByAllDetails(pFirstname, pLastname, pEmail);

        if(idFound == -1)
        {
            returningUser = new UserAccount(pFirstname, pLastname, pEmail, pPass);
            useraccountDBModel.addUserAccount(returningUser);
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
            Log.d("DEBUG",
                    "Going through the for loop in findUser() as the idFound is = " + idFound);
            for(UserAccount acct : userAccounts)
            {
                Log.d("DEBUG",
                        "isFound = " + idFound + " compared to .getID = " + acct.getId());


                if(acct.getId() == idFound)
                {
                    returningUser = acct;
                    found = true;
                    Log.d("DEBUG",
                            "USER FOUND USING THE findUser() : id=" + returningUser.getId() + "   name=" + returningUser.getFirstname()+returningUser.getLastname() + "   email=" + returningUser.getEmail());
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



}

package com.example.madassignment_1_1.Account;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.CursorIndexOutOfBoundsException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;


import java.util.ArrayList;

public class UserAccountDBModel
{
    SQLiteDatabase database;

    public void load(Context context)
    {
        this.database = new UserAccountDBHelper(context).getWritableDatabase();
//        Log.d("WARNING", "Resetting the database");
//        new RestaurantDBHelper(context).deleteTable(database);
//        new RestaurantDBHelper(context).onCreate(database);

    }

    public void addRestaurant(UserAccount pRestaurant)
    {
        ContentValues contentValues = new ContentValues();

        contentValues.put(UserAccountDBSchema.UserAccountTable.Cols.ID, pRestaurant.getId());
        contentValues.put(UserAccountDBSchema.UserAccountTable.Cols.FIRSTNAME, pRestaurant.getFirstname());
        contentValues.put(UserAccountDBSchema.UserAccountTable.Cols.LASTNAME, pRestaurant.getLastname());
        contentValues.put(UserAccountDBSchema.UserAccountTable.Cols.EMAIL, pRestaurant.getEmail());

        database.insert(UserAccountDBSchema.UserAccountTable.NAME, null, contentValues);
    }

    public void updateRestaurant() {}

    public void deleteRestaurant(UserAccount pUserAccount)
    {
        String[] whereValue = {String.valueOf(pUserAccount.getId())};
        database.delete(UserAccountDBSchema.UserAccountTable.NAME, UserAccountDBSchema.UserAccountTable.Cols.ID + "=?", whereValue);
    }

    public ArrayList<UserAccount> getAllUserAccounts()
    {
        ArrayList<UserAccount> useraccountList = new ArrayList<>();
        Cursor cursor = database.query(UserAccountDBSchema.UserAccountTable.NAME,null,null,null,null,null,null);
        UserAccountDBCursor useraccountDBCursor = new UserAccountDBCursor(cursor);

        try {
            useraccountDBCursor.moveToFirst();
            while(!useraccountDBCursor.isAfterLast())
            {
                useraccountList.add(useraccountDBCursor.getUserAccount());
                useraccountDBCursor.moveToNext();
            }
        }
        finally {
            cursor.close();
        }

        return useraccountList;
    }

    public int getNumTuples()
    {
        int tableSize = 0;
        Cursor cursor = database.query(UserAccountDBSchema.UserAccountTable.NAME,null,null,null,null,null,null);
        UserAccountDBCursor useraccountDBCursor = new UserAccountDBCursor(cursor);

        try{
            useraccountDBCursor.moveToFirst();
            while(!useraccountDBCursor.isAfterLast()){
                tableSize++;
                useraccountDBCursor.moveToNext();
            }
        }
        finally {
            cursor.close();
        }
        return tableSize;
    }

    public int getId(String useraccountName)
    {
        UserAccount tempUserAccount = new UserAccount(null, null,  null);
        int restaurantID = -1;

//        Cursor cursor = database.query(RestaurantTable.NAME, new String[] {RestaurantTable.Cols.ID},RestaurantTable.Cols.NAME + " = ?",new String[] {restaurantName},null,null,null);
        Cursor cursor = database.query(UserAccountDBSchema.UserAccountTable.NAME, null, UserAccountDBSchema.UserAccountTable.Cols.FIRSTNAME + " = ?" ,new String[] {useraccountName},null,null,null);
        UserAccountDBCursor useraccountDBCursor = new UserAccountDBCursor(cursor);

        try{
            useraccountDBCursor.moveToFirst();
            tempUserAccount = useraccountDBCursor.getUserAccount();
            restaurantID = tempUserAccount.getId();
            Log.d("WHILE LOOP", "ID = " + restaurantID + " for when the USER ACCOUNT = " + tempUserAccount.getFirstname() + " " + tempUserAccount.getLastname());
        }
        catch(CursorIndexOutOfBoundsException e) {
            Log.d("ERROR", "ERROR: " + e.getCause() + " ... " + e.getLocalizedMessage());
        }
        finally {
            cursor.close();
        }
        return restaurantID;
    }
}

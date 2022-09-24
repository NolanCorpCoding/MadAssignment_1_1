package com.example.madassignment_1_1.Account;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.CursorIndexOutOfBoundsException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.util.Log;


import java.util.ArrayList;

public class UserAccountDBModel
{
    SQLiteDatabase database;

    public void load(Context context)
    {
        this.database = new UserAccountDBHelper(context).getWritableDatabase();
//        Log.d("WARNING", "Resetting the database");
//        new UserAccountDBHelper(context).deleteTable(database);
//        new UserAccountDBHelper(context).onCreate(database);

    }

    public void addRestaurant(UserAccount pRestaurant)
    {
        ContentValues contentValues = new ContentValues();

        contentValues.put(UserAccountDBSchema.UserAccountTable.Cols.ID, pRestaurant.getId());
        contentValues.put(UserAccountDBSchema.UserAccountTable.Cols.FIRSTNAME, pRestaurant.getFirstname());
        contentValues.put(UserAccountDBSchema.UserAccountTable.Cols.LASTNAME, pRestaurant.getLastname());
        contentValues.put(UserAccountDBSchema.UserAccountTable.Cols.EMAIL, pRestaurant.getEmail());
        contentValues.put(UserAccountDBSchema.UserAccountTable.Cols.PASS, pRestaurant.getPass());
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

    public int getId(String userAccountEmail, String userAccountPassword)
    {
        UserAccount tempUserAccount = new UserAccount(null, null,  null, null);
        int userAccountID = -1;

        Cursor cursor = database.query(UserAccountDBSchema.UserAccountTable.NAME, null,
                UserAccountDBSchema.UserAccountTable.Cols.EMAIL + " = ? AND " + UserAccountDBSchema.UserAccountTable.Cols.PASS + " = ?",new String[] {userAccountEmail, userAccountPassword},null,
                null,
                null);
        UserAccountDBCursor useraccountDBCursor = new UserAccountDBCursor(cursor);

        try{
            Log.d("DEBUG", "Beginning of Try statement inside the UserAccountDBModel.getID() method");
            useraccountDBCursor.moveToFirst();
            Log.d("DEBUG", "Moves to the first element of the query inside of the Try statement inside the UserAccountDBModel.getID() method");
            tempUserAccount = useraccountDBCursor.getUserAccount();
            Log.d("DEBUG", "Finds the user account id inside of the Try statement inside the UserAccountDBModel.getID() method");
            userAccountID = tempUserAccount.getId();
            Log.d("WHILE LOOP", "ID = " + userAccountID + " for when the USER ACCOUNT = " + tempUserAccount.getFirstname() + " " + tempUserAccount.getLastname());
        }
        catch(CursorIndexOutOfBoundsException e) {
            Log.d("WHILE LOOP ERROR", "ERROR: " + e.getCause() + " ... " + e.getLocalizedMessage());
        }
        catch(SQLiteException e)
        {
            Log.d("SQLite Exception ERROR", "ERROR: " + e.getCause() + " ... " + e.getLocalizedMessage());
        }
        finally {
            cursor.close();
        }
        return userAccountID;
    }
}

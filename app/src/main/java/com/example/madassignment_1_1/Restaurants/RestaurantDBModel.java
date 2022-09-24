package com.example.madassignment_1_1.Restaurants;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.CursorIndexOutOfBoundsException;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.lang.reflect.Array;
import java.util.ArrayList;


import com.example.madassignment_1_1.Restaurants.RestaurantDBSchema.RestaurantTable;

public class RestaurantDBModel
{
    SQLiteDatabase database;

    public void load(Context context)
    {
        this.database = new RestaurantDBHelper(context).getWritableDatabase();
//        Log.d("WARNING", "Resetting the database");
//        new RestaurantDBHelper(context).deleteTable(database);
//        new RestaurantDBHelper(context).onCreate(database);

    }

    public void addRestaurant(Restaurant pRestaurant)
    {
        try {
            ContentValues contentValues = new ContentValues();

            contentValues.put(RestaurantTable.Cols.ID, pRestaurant.getId());
            contentValues.put(RestaurantTable.Cols.NAME, pRestaurant.getName());
            contentValues.put(RestaurantTable.Cols.ADDRESS, pRestaurant.getAddress());
            contentValues.put(RestaurantTable.Cols.DRAWABLEREFERENCE, pRestaurant.getDrawableID());

            database.insert(RestaurantTable.NAME, null, contentValues);
        }
        catch(SQLiteConstraintException e)
        {
            Log.d("DEBUG", "ERROR inside " + e.getStackTrace() + " ... Reason: " + e.getMessage());
        }
    }

    public void updateRestaurant() {}

    public void deleteRestaurant(Restaurant pRestaurant)
    {
        String[] whereValue = {String.valueOf(pRestaurant.getId())};
        database.delete(RestaurantTable.NAME, RestaurantTable.Cols.ID + "=?", whereValue);
    }

    public ArrayList<Restaurant> getAllRestaurants()
    {
        ArrayList<Restaurant> restaurantList = new ArrayList<>();
        Cursor cursor = database.query(RestaurantTable.NAME,null,null,null,null,null,null);
        RestaurantDBCursor restaurantDBCursor = new RestaurantDBCursor(cursor);

        try {
            restaurantDBCursor.moveToFirst();
            while(!restaurantDBCursor.isAfterLast())
            {
                restaurantList.add(restaurantDBCursor.getRestaurant());
                restaurantDBCursor.moveToNext();
            }
        }
        finally {
            cursor.close();
        }

        return  restaurantList;
    }

    public int getNumTuples()
    {
        int tableSize = 0;
        Cursor cursor = database.query(RestaurantTable.NAME,null,null,null,null,null,null);
        RestaurantDBCursor restaurantDBCursor = new RestaurantDBCursor(cursor);

        try{
            restaurantDBCursor.moveToFirst();
            while(!restaurantDBCursor.isAfterLast()){
                tableSize++;
                restaurantDBCursor.moveToNext();
            }
        }
        finally {
            cursor.close();
        }
        return tableSize;
    }

    public int getId(String restaurantName)
    {
        Restaurant tempRestaurant = new Restaurant(null, null,  0);
        int restaurantID = -1;

        Cursor cursor = database.query(RestaurantTable.NAME, null,RestaurantTable.Cols.NAME + " = ?",new String[] {restaurantName},null,null,null);
        RestaurantDBCursor restaurantDBCursor = new RestaurantDBCursor(cursor);

        try{
            restaurantDBCursor.moveToFirst();
            tempRestaurant = restaurantDBCursor.getRestaurant();
            restaurantID = tempRestaurant.getId();
            Log.d("WHILE LOOP", "ID = " + restaurantID + " for when the Restaurant = " + tempRestaurant.getName());
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

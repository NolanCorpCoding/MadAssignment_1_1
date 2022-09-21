package com.example.madassignment_1_1.Restaurants;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.CursorIndexOutOfBoundsException;
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
        ContentValues contentValues = new ContentValues();

        contentValues.put(RestaurantTable.Cols.ID, pRestaurant.getId());
        contentValues.put(RestaurantTable.Cols.NAME, pRestaurant.getName());
        contentValues.put(RestaurantTable.Cols.ADDRESS, pRestaurant.getAddress());
        contentValues.put(RestaurantTable.Cols.DRAWABLEREFERENCE, pRestaurant.getDrawableID());

        database.insert(RestaurantTable.NAME, null, contentValues);
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

    public int getID(String restaurantName)
    {
        Cursor cursor = database.query(RestaurantTable.NAME,new String[] {RestaurantTable.Cols.ID},RestaurantTable.Cols.NAME + " = ?",new String[] {restaurantName},null,null,null);
        RestaurantDBCursor restaurantDBCursor = new RestaurantDBCursor(cursor);

        try{
            restaurantDBCursor.moveToFirst();
            Log.d("WHILE LOOP", "ID = " + restaurantDBCursor.getString(0) + " for when the Restaurant = " + restaurantName);
        }
        catch(CursorIndexOutOfBoundsException e) {
            Log.d("ERROR", "ERROR: " + e.getCause() + " ... " + e.getLocalizedMessage());
        }
        finally {
            cursor.close();
        }
        return 0;
    }







}

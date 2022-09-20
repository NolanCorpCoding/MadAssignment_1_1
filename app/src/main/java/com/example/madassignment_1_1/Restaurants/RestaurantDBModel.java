package com.example.madassignment_1_1.Restaurants;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.lang.reflect.Array;
import java.util.ArrayList;

import com.example.madassignment_1_1.Restaurants.RestaurantDBSchema.RestaurantTable;

public class RestaurantDBModel
{
    SQLiteDatabase database;

    public void load(Context context)
    {
        this.database = new RestaurantDBHelper(context).getWritableDatabase();
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






}

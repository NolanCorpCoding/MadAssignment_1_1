package com.example.madassignment_1_1.Restaurants;

import android.database.Cursor;
import android.database.CursorWrapper;
import com.example.madassignment_1_1.Restaurants.RestaurantDBSchema.RestaurantTable;

public class RestaurantDBCursor extends CursorWrapper {
    public RestaurantDBCursor(Cursor cursor) {
        super(cursor);
    }

    public Restaurant getRestaurant(){
        int id = getInt(getColumnIndex(RestaurantTable.Cols.ID));
        String name = getString(getColumnIndex(RestaurantTable.Cols.NAME));
        String address = getString(getColumnIndex(RestaurantTable.Cols.ADDRESS));
        int drawableReference = getInt(getColumnIndex(RestaurantTable.Cols.DRAWABLEREFERENCE));
        return new Restaurant(id,name,address,drawableReference);
    }
}

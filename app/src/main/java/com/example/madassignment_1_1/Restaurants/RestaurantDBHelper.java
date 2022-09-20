package com.example.madassignment_1_1.Restaurants;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.madassignment_1_1.Restaurants.RestaurantDBSchema.RestaurantTable;

public class RestaurantDBHelper extends SQLiteOpenHelper {
    private static final int VERSION = 1;
    private static final String DATABASE_NAME = "Restaurant.db";

    public RestaurantDBHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table "+RestaurantTable.NAME+"("+RestaurantTable.Cols.ID+" INT, "+RestaurantTable.Cols.NAME+" TEXT, "+RestaurantTable.Cols.ADDRESS+" TEXT, "+ RestaurantTable.Cols.DRAWABLEREFERENCE+ " INT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    //uncomment RestaurantDBHelper.load() delete and onCreate comments
    public void deleteTable(SQLiteDatabase sqLiteDatabase)
    {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+RestaurantTable.NAME);
    }

}

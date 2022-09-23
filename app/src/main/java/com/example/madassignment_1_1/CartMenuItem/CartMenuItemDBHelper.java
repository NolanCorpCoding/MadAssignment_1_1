package com.example.madassignment_1_1.CartMenuItem;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.madassignment_1_1.Cart.CartDBSchema;

public class CartMenuItemDBHelper extends SQLiteOpenHelper
{
    private static final int VERSION = 1;
    private static final String DATABASE_NAME = "CartMealItem.db";

    public CartMenuItemDBHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase)
    {
        sqLiteDatabase.execSQL("create table "+ CartDBSchema.CartTable.NAME+"("+ CartMealItemDBSchema.CartMealItemTable.Cols.CARTID+ " INT, "+ CartMealItemDBSchema.CartMealItemTable.Cols.MEALITEMID + " INT, " + CartMealItemDBSchema.CartMealItemTable.Cols.QUANTITY + " INT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    //uncomment RestaurantDBHelper.load() delete and onCreate comments
    public void deleteTable(SQLiteDatabase sqLiteDatabase)
    {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+ CartDBSchema.CartTable.NAME);
    }

}
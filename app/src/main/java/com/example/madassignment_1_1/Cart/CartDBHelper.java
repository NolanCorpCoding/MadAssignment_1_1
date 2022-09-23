package com.example.madassignment_1_1.Cart;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.madassignment_1_1.Account.UserAccountDBSchema;

public class CartDBHelper extends SQLiteOpenHelper
{
    private static final int VERSION = 1;
    private static final String DATABASE_NAME = "Cart.db";

    public CartDBHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase)
    {
        sqLiteDatabase.execSQL("create table "+ CartDBSchema.CartTable.NAME+"("+ CartDBSchema.CartTable.Cols.ID+" INT, "+ CartDBSchema.CartTable.Cols.PRICE+" REAL,  "+ CartDBSchema.CartTable.Cols.RESTAURANTID+ " TEXT,  "+ CartDBSchema.CartTable.Cols.USERACCOUNTID+ " TEXT, " + CartDBSchema.CartTable.Cols.ORDERTIME + " TEXT);");
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
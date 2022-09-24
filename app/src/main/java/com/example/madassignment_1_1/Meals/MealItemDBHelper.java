package com.example.madassignment_1_1.Meals;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MealItemDBHelper extends SQLiteOpenHelper {
    private static final int VERSION = 1;
    private static final String DATABASE_NAME = "MealItem.db";

    public MealItemDBHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase)
    {
        sqLiteDatabase.execSQL("create table "+ MealItemDBSchema.MealsTable.NAME+"("+ MealItemDBSchema.MealsTable.Cols.ID+" INT PRIMARY KEY, "+ MealItemDBSchema.MealsTable.Cols.NAME+" TEXT,  "+ MealItemDBSchema.MealsTable.Cols.PRICE+" REAL,  "+ MealItemDBSchema.MealsTable.Cols.RESTAURANTID+ " INT, " + MealItemDBSchema.MealsTable.Cols.DRAWABLEREFERENCE + " INT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    //uncomment RestaurantDBHelper.load() delete and onCreate comments
    public void deleteTable(SQLiteDatabase sqLiteDatabase)
    {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+ MealItemDBSchema.MealsTable.NAME);
    }

}

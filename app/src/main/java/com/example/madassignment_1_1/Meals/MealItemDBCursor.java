package com.example.madassignment_1_1.Meals;

import android.database.Cursor;
import android.database.CursorWrapper;

public class MealItemDBCursor extends CursorWrapper {
    public MealItemDBCursor(Cursor cursor) { super(cursor); }

    public Meals getMealItem(){
        int id = getInt(getColumnIndex(MealItemDBSchema.MealsTable.Cols.ID));
        String name = getString(getColumnIndex(MealItemDBSchema.MealsTable.Cols.NAME));
        double price = getDouble(getColumnIndex(MealItemDBSchema.MealsTable.Cols.PRICE));
        int restaurantID = getInt(getColumnIndex(MealItemDBSchema.MealsTable.Cols.RESTAURANTID));
        int drawableReference = getInt(getColumnIndex(MealItemDBSchema.MealsTable.Cols.DRAWABLEREFERENCE));
        return new Meals(id,name,price, restaurantID, drawableReference);
    }
}

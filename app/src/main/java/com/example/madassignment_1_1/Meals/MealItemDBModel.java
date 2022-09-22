package com.example.madassignment_1_1.Meals;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.CursorIndexOutOfBoundsException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.util.Log;

import java.util.ArrayList;

public class MealItemDBModel
{
    SQLiteDatabase database;

    public void load(Context context)
    {
        this.database = new MealItemDBHelper(context).getWritableDatabase();
//        Log.d("WARNING", "Resetting the database");
//        new UserAccountDBHelper(context).deleteTable(database);
//        new UserAccountDBHelper(context).onCreate(database);

    }

    public void addRestaurant(Meal pRestaurant)
    {
        ContentValues contentValues = new ContentValues();

        contentValues.put(MealItemDBSchema.MealsTable.Cols.ID, pRestaurant.getId());
        contentValues.put(MealItemDBSchema.MealsTable.Cols.NAME, pRestaurant.getName());
        contentValues.put(MealItemDBSchema.MealsTable.Cols.PRICE, pRestaurant.getPrice());
        contentValues.put(MealItemDBSchema.MealsTable.Cols.RESTAURANTID, pRestaurant.getRestaurantID());
        contentValues.put(MealItemDBSchema.MealsTable.Cols.DRAWABLEREFERENCE, pRestaurant.getDrawableID());
        database.insert(MealItemDBSchema.MealsTable.NAME, null, contentValues);
    }

    public void updateRestaurant() {}

    public void deleteRestaurant(Meal pMeal)
    {
        String[] whereValue = {String.valueOf(pMeal.getId())};
        database.delete(MealItemDBSchema.MealsTable.NAME, MealItemDBSchema.MealsTable.Cols.ID + "=?", whereValue);
    }

    public ArrayList<Meal> getAllUserAccounts()
    {
        ArrayList<Meal> mealItemList = new ArrayList<>();
        Cursor cursor = database.query(MealItemDBSchema.MealsTable.NAME,null,null,null,null,null,null);
        MealItemDBCursor mealItemDBCursor = new MealItemDBCursor(cursor);

        try {
            mealItemDBCursor.moveToFirst();
            while(!mealItemDBCursor.isAfterLast())
            {
                mealItemList.add(mealItemDBCursor.getMealItem());
                mealItemDBCursor.moveToNext();
            }
        }
        finally {
            cursor.close();
        }

        return mealItemList;
    }

    public int getNumTuples()
    {
        int tableSize = 0;
        Cursor cursor = database.query(MealItemDBSchema.MealsTable.NAME,null,null,null,null,null,null);
        MealItemDBCursor mealItemDBCursor = new MealItemDBCursor(cursor);

        try{
            mealItemDBCursor.moveToFirst();
            while(!mealItemDBCursor.isAfterLast()){
                tableSize++;
                mealItemDBCursor.moveToNext();
            }
        }
        finally {
            cursor.close();
        }
        return tableSize;
    }

    public int getId(String pMealName, String pMealRestaurant)
    {
        Meal tempMealItem = new Meal(0, null,  null, 0, 0);
        int mealItemID = -1;

        Cursor cursor = database.query(MealItemDBSchema.MealsTable.NAME, null,
                MealItemDBSchema.MealsTable.Cols.NAME + " = ? AND " + MealItemDBSchema.MealsTable.Cols.RESTAURANTID + " = ?",new String[] {pMealName, pMealRestaurant},null,null,null);

        MealItemDBCursor mealItemDBCursor = new MealItemDBCursor(cursor);

        try{
            mealItemDBCursor.moveToFirst();
            tempMealItem = mealItemDBCursor.getMealItem();
            mealItemID = tempMealItem.getId();
            Log.d("WHILE LOOP", "ID = " + mealItemID + " for when the Meal = " + tempMealItem.getName());
        }
        catch(CursorIndexOutOfBoundsException e) {
            Log.d("WHILE LOOP ERROR", "ERROR: " + e.getCause() + " ... " + e.getLocalizedMessage());
        }
        catch(SQLiteException e)
        {
            Log.d("WHILE LOOP ERROR", "ERROR: " + e.getCause() + " ... " + e.getLocalizedMessage());
        }
        finally {
            cursor.close();
        }
        return mealItemID;
    }
}

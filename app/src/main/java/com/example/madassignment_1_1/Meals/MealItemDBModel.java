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

    Context context;

    public void load(Context context)
    {
        this.database = new MealItemDBHelper(context).getWritableDatabase();
//        Log.d("WARNING", "Resetting the meal database");
//        new MealItemDBHelper(context).deleteTable(database);
//        new MealItemDBHelper(context).onCreate(database);
        this.context = context;

    }

    public void addMealItem(Meals pRestaurant)
    {
        ContentValues contentValues = new ContentValues();

        contentValues.put(MealItemDBSchema.MealsTable.Cols.ID, pRestaurant.getId());
        contentValues.put(MealItemDBSchema.MealsTable.Cols.NAME, pRestaurant.getName());
        contentValues.put(MealItemDBSchema.MealsTable.Cols.PRICE, pRestaurant.getPrice());
        contentValues.put(MealItemDBSchema.MealsTable.Cols.RESTAURANTID, pRestaurant.getRestaurantId());
        contentValues.put(MealItemDBSchema.MealsTable.Cols.DRAWABLEREFERENCE, pRestaurant.getDrawableId());
        database.insert(MealItemDBSchema.MealsTable.NAME, null, contentValues);
    }

    public void updateMealItem() {}

    public void deleteMealItem(Meals pMeal)
    {
        String[] whereValue = {String.valueOf(pMeal.getId())};
        database.delete(MealItemDBSchema.MealsTable.NAME, MealItemDBSchema.MealsTable.Cols.ID + "=?", whereValue);
    }

    public ArrayList<Meals> getAllMealItems()
    {
        Log.d("debug Sam", "im out of the loop");

        ArrayList<Meals> mealItemList = new ArrayList<>();
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

        for (Meals meals : mealItemList)
        {
            Log.d("debug Sam", "im in the loop");
            Log.d("debug Sam", meals.getName());
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
        Meals tempMealItem = new Meals(0, null,  0.0, 0, 0);
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

    public Meals findMeal(int id)
    {
        Meals meal = null;

        for(Meals currMeal : getAllMealItems())
        {
            if(id == currMeal.getId())
            {
                meal = currMeal;
            }
        }

        return meal;
    }
}

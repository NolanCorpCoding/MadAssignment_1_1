package com.example.madassignment_1_1.CartMenuItem;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.view.MenuItem;

import com.example.madassignment_1_1.Account.UserAccountDBSchema;
import com.example.madassignment_1_1.Cart.Cart;
import com.example.madassignment_1_1.Meals.Meals;

import java.util.ArrayList;

public class CartMenuItemDBModel
{
    SQLiteDatabase database;

    public void load(Context context)
    {
        Log.d("CHECK", "Loading the CartMenuItem Database using the DBHelper");
        this.database = new CartMenuItemDBHelper(context).getWritableDatabase();
        Log.d("CHECK", "Got the " + database.getPath() + " database and is " + database.isOpen() + ".");

//        Log.d("WARNING", "Resetting the database");
//        new CartMenuItemDBHelper(context).deleteTable(database);
//        new CartMenuItemDBHelper(context).onCreate(database);

    }

    public void addCartMenuItem(CartMenuItem pCartMenuItem)
    {
        ContentValues contentValues = new ContentValues();

        contentValues.put(CartMealItemDBSchema.CartMealItemTable.Cols.CARTID, pCartMenuItem.getCartID());
        contentValues.put(CartMealItemDBSchema.CartMealItemTable.Cols.MEALITEMID, pCartMenuItem.getMenuItemID());
        contentValues.put(CartMealItemDBSchema.CartMealItemTable.Cols.QUANTITY, pCartMenuItem.getQuantity());

        Log.d("DEBUG", "INSERTING THE CARTMEALITEM tuple");
        database.insert(CartMealItemDBSchema.CartMealItemTable.NAME, null, contentValues);
    }

    public void updateCart(CartMenuItem pCartMenuItem, int quantity) {
        ContentValues contentValues = new ContentValues();

//        contentValues.put(CartMealItemDBSchema.CartMealItemTable.Cols.CARTID, pCartMenuItem.getCartID());
//        contentValues.put(CartMealItemDBSchema.CartMealItemTable.Cols.MEALITEMID, pCartMenuItem.getMenuItemID());
        contentValues.put(CartMealItemDBSchema.CartMealItemTable.Cols.QUANTITY, quantity);

        String[] whereValue = {String.valueOf(pCartMenuItem.getMenuItemID()), String.valueOf(pCartMenuItem.getCartID())};

        Log.d("DEBUG", "UPDATING THE CARTMEALITEM tuple");
        database.update(CartMealItemDBSchema.CartMealItemTable.NAME, contentValues,
                CartMealItemDBSchema.CartMealItemTable.Cols.MEALITEMID + " = ? AND " + CartMealItemDBSchema.CartMealItemTable.Cols.CARTID + " = ?", whereValue);
    }

    public void deleteCart(CartMenuItem pCartMenuItem)
    {
        String[] whereValue = {String.valueOf(pCartMenuItem.getCartID()), String.valueOf(pCartMenuItem.getMenuItemID())};
        database.delete(CartMealItemDBSchema.CartMealItemTable.NAME, CartMealItemDBSchema.CartMealItemTable.Cols.CARTID + "=? AND " + CartMealItemDBSchema.CartMealItemTable.Cols.MEALITEMID + "=?",
                whereValue);
    }

    public ArrayList<CartMenuItem> getAllCartMenuItems()
    {
        ArrayList<CartMenuItem> cartMenuItemList = new ArrayList<>();
        Log.d("CHECK", "Got the " + database.getPath() + " database and is " + database.isOpen() + " just before the db query.");
        Cursor cursor = database.query(CartMealItemDBSchema.CartMealItemTable.NAME,null,null,null,null,null,null);
        CartMenuItemDBCursor cartMenuItemDBCursor = new CartMenuItemDBCursor(cursor);

        try {
            cartMenuItemDBCursor.moveToFirst();
            while(!cartMenuItemDBCursor.isAfterLast())
            {
                cartMenuItemList.add(cartMenuItemDBCursor.getCartMenuItem());
                cartMenuItemDBCursor.moveToNext();
            }
        }
        finally {
            cursor.close();
        }

        return cartMenuItemList;
    }

    public int getNumTuples()
    {
        int tableSize = 0;
        Cursor cursor = database.query(CartMealItemDBSchema.CartMealItemTable.NAME,null,null,null,null,null,null);
        CartMenuItemDBCursor cartMenuItemDBCursor = new CartMenuItemDBCursor(cursor);

        try{
            cartMenuItemDBCursor.moveToFirst();
            while(!cartMenuItemDBCursor.isAfterLast()){
                tableSize++;
                cartMenuItemDBCursor.moveToNext();
            }
        }
        finally {
            cursor.close();
        }
        return tableSize;
    }

}
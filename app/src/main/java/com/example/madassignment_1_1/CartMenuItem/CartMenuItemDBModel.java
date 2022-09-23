package com.example.madassignment_1_1.CartMenuItem;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.MenuItem;

import com.example.madassignment_1_1.Cart.Cart;
import com.example.madassignment_1_1.Meals.Meals;

import java.util.ArrayList;

public class CartMenuItemDBModel
{
    SQLiteDatabase database;

    public void load(Context context)
    {
        this.database = new CartMenuItemDBHelper(context).getWritableDatabase();
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
        database.insert(CartMealItemDBSchema.CartMealItemTable.NAME, null, contentValues);
    }

    public void updateCart() {}

    public void deleteCart(CartMenuItem pCartMenuItem)
    {
        String[] whereValue = {String.valueOf(pCartMenuItem.getCartID()), String.valueOf(pCartMenuItem.getMenuItemID())};
        database.delete(CartMealItemDBSchema.CartMealItemTable.NAME, CartMealItemDBSchema.CartMealItemTable.Cols.CARTID + "=? AND " + CartMealItemDBSchema.CartMealItemTable.Cols.MEALITEMID + "=?",
                whereValue);
    }

    public ArrayList<CartMenuItem> getAllCarts()
    {
        ArrayList<CartMenuItem> cartMenuItemList = new ArrayList<>();
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
package com.example.madassignment_1_1.Cart;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.CursorIndexOutOfBoundsException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.util.Log;

import java.util.ArrayList;

public class CartDBModel
{
    SQLiteDatabase database;

    public void load(Context context)
    {
        this.database = new CartDBHelper(context).getWritableDatabase();
//        Log.d("WARNING", "Resetting the database");
//        new CartDBHelper(context).deleteTable(database);
//        new CartDBHelper(context).onCreate(database);

    }

    public void addCart(Cart pCart)
    {
        ContentValues contentValues = new ContentValues();

        contentValues.put(CartDBSchema.CartTable.Cols.ID, pCart.getId());
        contentValues.put(CartDBSchema.CartTable.Cols.PRICE, pCart.getTotalPrice());
        contentValues.put(CartDBSchema.CartTable.Cols.USERACCOUNTID, pCart.getUserAccountID());
        database.insert(CartDBSchema.CartTable.NAME, null, contentValues);
    }

    public void updateCart() {}

    public void deleteCart(Cart pCart)
    {
        String[] whereValue = {String.valueOf(pCart.getId())};
        database.delete(CartDBSchema.CartTable.NAME, CartDBSchema.CartTable.Cols.ID + "=?", whereValue);
    }

    public ArrayList<Cart> getAllCarts()
    {
        ArrayList<Cart> cartList = new ArrayList<>();
        Cursor cursor = database.query(CartDBSchema.CartTable.NAME,null,null,null,null,null,null);
        CartDBCursor cartDBCursor = new CartDBCursor(cursor);

        try {
            cartDBCursor.moveToFirst();
            while(!cartDBCursor.isAfterLast())
            {
                cartList.add(cartDBCursor.getCart());
                cartDBCursor.moveToNext();
            }
        }
        finally {
            cursor.close();
        }

        return cartList;
    }

    public int getNumTuples()
    {
        int tableSize = 0;
        Cursor cursor = database.query(CartDBSchema.CartTable.NAME,null,null,null,null,null,null);
        CartDBCursor cartDBCursor = new CartDBCursor(cursor);

        try{
            cartDBCursor.moveToFirst();
            while(!cartDBCursor.isAfterLast()){
                tableSize++;
                cartDBCursor.moveToNext();
            }
        }
        finally {
            cursor.close();
        }
        return tableSize;
    }

//    public int getId(String cartPrice)
//    {
//        Cart tempCart = new Cart(0, 0.0,  0, 0);
//        int cartID = -1;
//
//        Cursor cursor = database.query(CartDBSchema.CartTable.NAME, null,
//                CartDBSchema.CartTable.Cols.PRICE + " = ? ",new String[] {cartPrice},null,null,null);
//        CartDBCursor cartDBCursor = new CartDBCursor(cursor);
//
//        try{
//            Log.d("DEBUG", "Beginning of Try statement inside the UserAccountDBModel.getID() method");
//            cartDBCursor.moveToFirst();
//            Log.d("DEBUG", "Moves to the first element of the query inside of the Try statement inside the UserAccountDBModel.getID() method");
//            tempCart = cartDBCursor.getCart();
//            Log.d("DEBUG", "Finds the user account id inside of the Try statement inside the UserAccountDBModel.getID() method");
//            cartID = tempCart.getId();
//            Log.d("WHILE LOOP", "ID = " + cartID + " for when the Cart");
//        }
//        catch(CursorIndexOutOfBoundsException e) {
//            Log.d("WHILE LOOP ERROR", "ERROR: " + e.getCause() + " ... " + e.getLocalizedMessage());
//        }
//        catch(SQLiteException e)
//        {
//            Log.d("WHILE LOOP ERROR", "ERROR: " + e.getCause() + " ... " + e.getLocalizedMessage());
//        }
//        finally {
//            cursor.close();
//        }
//        return cartID;
//    }

    public Cart findCart(int id)
    {
        Cart tempCart = null;
        Log.d("DEBUG", "START GOING THROUGH CARTS");
        for(Cart cart : getAllCarts())
        {
            Log.d("DEBUG", "CYCLING THROUGH CURRENT CART " + cart.getId());
            if(cart.getId() == id)
            {
                tempCart = cart;
            }
        }
        return tempCart;
    }

}


package com.example.madassignment_1_1.Cart;

import android.database.Cursor;
import android.database.CursorWrapper;

public class CartDBCursor extends CursorWrapper
{
    public CartDBCursor(Cursor cursor) { super(cursor); }

    public Cart getCart(){
        int id = getInt(getColumnIndex(CartDBSchema.CartTable.Cols.ID));
        double price = getDouble(getColumnIndex(CartDBSchema.CartTable.Cols.PRICE));
        int userAccountID = getInt(getColumnIndex(CartDBSchema.CartTable.Cols.USERACCOUNTID));
        String orderTime = getString(getColumnIndex(CartDBSchema.CartTable.Cols.ORDERTIME));
        return new Cart(id, price, userAccountID, orderTime);
    }
}

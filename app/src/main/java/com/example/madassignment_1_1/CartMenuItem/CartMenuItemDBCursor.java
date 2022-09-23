package com.example.madassignment_1_1.CartMenuItem;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.example.madassignment_1_1.Cart.Cart;
import com.example.madassignment_1_1.Cart.CartDBSchema;

public class CartMenuItemDBCursor extends CursorWrapper {
    public CartMenuItemDBCursor(Cursor cursor) { super(cursor); }

    public CartMenuItem getCartMenuItem(){
        int cartID = getInt(getColumnIndex(CartMealItemDBSchema.CartMealItemTable.Cols.CARTID));
        int menuItemID = getInt(getColumnIndex(CartMealItemDBSchema.CartMealItemTable.Cols.MEALITEMID));
        int quantity = getInt(getColumnIndex(CartMealItemDBSchema.CartMealItemTable.Cols.QUANTITY));
        return new CartMenuItem(cartID, menuItemID, quantity);
    }
}

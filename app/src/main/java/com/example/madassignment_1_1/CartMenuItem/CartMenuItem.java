package com.example.madassignment_1_1.CartMenuItem;

public class CartMenuItem {
    public final int cartID;
    private final int menuItemID;
    private int quantity;

    public CartMenuItem(int pCartID, int pMenuItemID, int pQuantity)
    {
        this.cartID = pCartID;
        this.menuItemID = pMenuItemID;
        this.quantity = pQuantity;

    }


    public int getCartID() {return cartID;}

    public int getMenuItemID() {return menuItemID;}

    public int getQuantity() {return quantity;}

    public void setQuantity(int pQuantity) {this.quantity = pQuantity;}

    public void quantityAddOne() {this.quantity++;}

    public void quantitySubOne() {
        int temp = this.quantity - 1;
        if(temp >= 0)
        {
            this.quantity = temp;
        }
    }

}


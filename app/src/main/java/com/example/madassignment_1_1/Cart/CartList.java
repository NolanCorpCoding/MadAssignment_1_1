package com.example.madassignment_1_1.Cart;

import android.content.Context;
import android.util.Log;
import android.view.MenuItem;

import com.example.madassignment_1_1.Account.UserAccount;
import com.example.madassignment_1_1.Account.UserAccountList;
import com.example.madassignment_1_1.CartMenuItem.CartMenuItem;
import com.example.madassignment_1_1.CartMenuItem.CartMenuItemDBModel;
import com.example.madassignment_1_1.Meals.MealItemDBModel;
import com.example.madassignment_1_1.Meals.Meals;

import java.util.ArrayList;
import java.util.List;

public class CartList {
    private List<Cart> carts;
    CartDBModel cartDBModel;

    private List<CartMenuItem> cartMenuItems;
    CartMenuItemDBModel cartMenuItemDBModel;

    private List<Meals> menuItems;
    MealItemDBModel menuItemDBModel;

    private UserAccountList userAcctList;


    public void load(Context context)
    {
        carts = new ArrayList<>();
        cartDBModel = new CartDBModel();
        cartDBModel.load(context);
        carts = cartDBModel.getAllCarts();

        cartMenuItems = new ArrayList<>();
        cartMenuItemDBModel = new CartMenuItemDBModel();
        cartMenuItemDBModel.load(context);
        cartMenuItems = cartMenuItemDBModel.getAllCartMenuItems();

        menuItems = new ArrayList<>();
        menuItemDBModel = new MealItemDBModel();
        menuItemDBModel.load(context);
        menuItems = menuItemDBModel.getAllMealItems();

        userAcctList = new UserAccountList();
        userAcctList.load(context);

        updateCart();

        Log.d("OUTRAGE", "DONE");
    }


    public CartList() {}

    public Cart get(int i)
    {
        return carts.get(i);
    }

    public int size()
    {
        return carts.size();
    }

    public Cart getCart(int id)
    {
        boolean found = false;
        Cart pCart = null;
        Log.d("WOW", "TRYING TO FIND THE CART MEAL INSIDE THE DB for the id:" + id + " and comparing to " + carts.size() + " diff carts");
        for(Cart cart : carts)
        {
            Log.d("WOW", "Comparing the cart we have (" + id + ") to the cart id:" + cart.getId());
            if(cart.getId() == id)
            {
                Log.d("WOW", "FOUND THE CART MEAL INSIDE THE DB");
                pCart = cart;
                found = true;
            }
        }

        if(!found)
        {
            Log.d("WOW", "DID NOT FIND THE CART MEAL INSIDE THE DB");
        }
        else
        {
            Log.d("WOW", "EXPORTING WITH THE CART WITH AN ID OF" + pCart.getId());
        }

        return pCart;
    }


    public CartMenuItem addMeal(Cart pCart, Meals pMeal, int quantity, Context context)
    {
        cartMenuItemDBModel.load(context);
        cartMenuItems = cartMenuItemDBModel.getAllCartMenuItems();

        boolean found = false;
        CartMenuItem tempCartMenuItem = new CartMenuItem(pCart.getId(), pMeal.getId(), quantity);

        Log.d("DEBUG", "STARTING CYCLE TO ADD NEW CARTMENUITEM");
        for(CartMenuItem cartMenuItem : cartMenuItems)
        {
            Log.d("DEBUG", "CART: cmi=" + cartMenuItem.getCartID() + " vs pC=" + pCart.getId() + "   MEAL: cmi="+ cartMenuItem.getMenuItemID() + " vs pC=" + pMeal.getId());
            if(cartMenuItem.getCartID() == pCart.getId())
            {
                if(cartMenuItem.getMenuItemID() == pMeal.getId())
                {
                    Log.d("DEBUG", "FOUND CART!");
                    found = true;
                    cartMenuItemDBModel.updateCart(cartMenuItem, quantity);

                }
            }
        }

        if(!found)
        {
            cartMenuItemDBModel.addCartMenuItem(tempCartMenuItem);
        }

        pCart.addMeal(tempCartMenuItem, quantity);

        pCart.calculateTotalPrice(context);

        return tempCartMenuItem;
    }

    public void printAllCartMenuItem()
    {
        Log.d("DEBUG", "CART MENU ITEMS:");
        for(CartMenuItem obj : cartMenuItems)
        {
            Log.d("DEBUG", "CART MENU ITEM: cartID=" + obj.getCartID() + "   menuID=" + obj.getMenuItemID() + "   quantity=" + obj.getQuantity());
        }
    }

    public Meals getMeal(int mealID)
    {
        Meals tempMeal = null;

        for(Meals meal : menuItems)
        {
            if(mealID == meal.getId())
            {
                tempMeal = meal;
            }
        }

        return tempMeal;
    }

    public void updateCart()
    {
        Cart cart;

        Log.d("DEBUG", "Starting the updateCart method for statement...");
        for(CartMenuItem pCartMenuItem : cartMenuItems)
        {
            Log.d("DEBUG", "Cycle is the " + pCartMenuItem.getCartID() + " numbered cart for the meal with the number " + pCartMenuItem.getMenuItemID());
            cart = getCart(pCartMenuItem.getCartID());

            cart.addMeal(pCartMenuItem, pCartMenuItem.getQuantity());
        }
    }

    public CartMenuItem getCartMealItem(int pCartID, int pMealID)
    {
        CartMenuItem tempItem = null;

        for(CartMenuItem item : cartMenuItems)
        {
            if((pCartID == item.getCartID()) && (pMealID == item.getMenuItemID()))
            {
                tempItem = item;
            }
        }

        return tempItem;
    }





}

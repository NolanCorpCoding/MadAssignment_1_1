package com.example.madassignment_1_1.Cart;

public class CartDBSchema
{
    public static class CartTable{
        public static final String NAME = "Cart";
        public static class Cols{
            public static final String ID = "id";
            public static final String PRICE = "price";
            public static final String USERACCOUNTID = "userAccountID";
            public static final String ORDERTIME = "orderTime";
        }
    }
}

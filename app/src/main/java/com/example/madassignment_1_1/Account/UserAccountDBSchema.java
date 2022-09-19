package com.example.madassignment_1_1.Account;

public class UserAccountDBSchema {
    public static class UserAccountTable{
        public static final String NAME = "UserAccount";
        public static class Cols{
            public static final String ID = "id";
            public static final String FIRSTNAME = "firstname";
            public static final String LASTNAME = "lastname";
            public static final String EMAIL = "email";
            public static final String CURRENTCART = "currentCart";
            public static final String PREVIOUSCARTS = "previousCarts";
        }
    }
}

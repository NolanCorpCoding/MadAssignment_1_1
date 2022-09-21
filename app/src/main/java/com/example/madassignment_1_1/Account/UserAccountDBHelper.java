package com.example.madassignment_1_1.Account;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.madassignment_1_1.Account.UserAccountDBSchema.UserAccountTable;


public class UserAccountDBHelper extends SQLiteOpenHelper
{
    private static final int VERSION = 1;
    private static final String DATABASE_NAME = "UserAccount.db";

    public UserAccountDBHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase)
    {
        sqLiteDatabase.execSQL("create table "+UserAccountTable.NAME+"("+UserAccountTable.Cols.ID+" INT, "+UserAccountTable.Cols.FIRSTNAME+" TEXT,  "+UserAccountTable.Cols.LASTNAME+" TEXT,  "+ UserAccountTable.Cols.EMAIL+ " TEXT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}

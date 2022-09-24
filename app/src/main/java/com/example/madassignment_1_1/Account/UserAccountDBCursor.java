package com.example.madassignment_1_1.Account;

import android.database.Cursor;
import android.database.CursorWrapper;
import com.example.madassignment_1_1.Account.UserAccountDBSchema.UserAccountTable;

public class UserAccountDBCursor extends CursorWrapper
{
    public UserAccountDBCursor(Cursor cursor)
    {
        super(cursor);
//        UserAccount.resetAutoNextId();
    }

    public UserAccount getUserAccount(){
        int id = getInt(getColumnIndex(UserAccountTable.Cols.ID));
        String firstname = getString(getColumnIndex(UserAccountTable.Cols.FIRSTNAME));
        String lastname = getString(getColumnIndex(UserAccountTable.Cols.LASTNAME));
        String email = getString(getColumnIndex(UserAccountTable.Cols.EMAIL));
        String pass = getString(getColumnIndex(UserAccountTable.Cols.PASS));
        return new UserAccount(id,firstname,lastname, email, pass);
    }
}

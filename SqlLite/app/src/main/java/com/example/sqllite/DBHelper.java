package com.example.sqllite;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.sqllite.ContactContract.ContactEntry;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "contactsManager";
    public static final int DATABASE_VERSION = 1;

    public DBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        final String SQL_CREATE_TABLE_CONTACTS ="CREATE TABLE IF NOT EXISTS " + ContactEntry.TABLE_NAME + "(" +
                ContactEntry.COLUMN_ID +" INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ContactEntry.COLUMN_NAME +" TEXT NOT NULL, " +
                ContactEntry.COLUMN_PHONE+" TEXT NOT NULL" +
                ");";

        db.execSQL(SQL_CREATE_TABLE_CONTACTS);
        Log.i("DBHelper" ,"database is created .......");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void addContactm (Contact contact){

        ContentValues cv =new ContentValues();
        cv.put(ContactEntry.COLUMN_NAME,contact.getName());
        cv.put(ContactEntry.COLUMN_PHONE,contact.getPhone());

        SQLiteDatabase db = getWritableDatabase();
        db.insert(ContactEntry.TABLE_NAME ,null ,cv);
        db.close();
        Log.i("DBHelper" , "added....");
    }
}

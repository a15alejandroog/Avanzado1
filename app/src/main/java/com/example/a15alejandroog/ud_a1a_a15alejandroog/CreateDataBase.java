package com.example.a15alejandroog.ud_a1a_a15alejandroog;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by a15alejandroog on 11/16/15.
 */
public class CreateDataBase extends SQLiteOpenHelper {

    public final static String DB_NAME = "database";
    public final static int DB_VERSION = 1;

    public CreateDataBase(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub

    }
}

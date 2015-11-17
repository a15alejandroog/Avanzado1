package com.example.a15alejandroog.ud_a1a_a15alejandroog;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by a15alejandroog on 11/16/15.
 */
public class CreateDataBase extends SQLiteOpenHelper {

    public SQLiteDatabase database;
    public final static String DB_NAME = "DATOS";
    public final static int DB_VERSION = 1;
    private String CT_PERSOA = "CREATE TABLE persoa(" +
            "nome VARCHAR(50) PRIMARY KEY," +
            "descricion VARCHAR(150))";

    public CreateDataBase(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        // TODO Auto-generated constructor stub
    }

    public void addPerson(Persoa person) {
        ContentValues values = new ContentValues();
        values.put("nome", person.getNome());
        values.put("descricion", person.getDescricion());
        database.insert("persoa", null, values);
    }

    public ArrayList<Persoa> listPeople() {
        ArrayList<Persoa> listPeople = new ArrayList<>();
        Cursor consult = database.rawQuery("SELECT * FROM persoa", null);
        if (consult.moveToFirst()) {
            Persoa person;
            while (!consult.isAfterLast()) {
                person = new Persoa(consult.getString(0), consult.getString(1));
                listPeople.add(person);
                consult.moveToNext();
            }
        }
        return listPeople;
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CT_PERSOA);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
    }
}

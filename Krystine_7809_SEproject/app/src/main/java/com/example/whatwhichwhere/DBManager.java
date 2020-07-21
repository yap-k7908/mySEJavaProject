package com.example.whatwhichwhere;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import static com.example.whatwhichwhere.DatabaseHelper.TABLE_NAME;

    public class DBManager {
    private DatabaseHelper dbHelper;
    private SQLiteDatabase database;
    public Context context;

    public DBManager(Context c) {
        context = c;
    }


    public DBManager open() throws android.database.SQLException {
        dbHelper = new DatabaseHelper(context);
        database = dbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        dbHelper.close();
    }

    public void insert(String product, String brand, double price, String unit, double size, String location) {
        // put data in contentvalues first
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelper.TYPE, product);
        contentValues.put(DatabaseHelper.BRAND, brand);
        contentValues.put(DatabaseHelper.PRICE, price);
        contentValues.put(DatabaseHelper.UNIT, unit);
        contentValues.put(DatabaseHelper.SIZE, size);
        contentValues.put(DatabaseHelper.LOCATION, location);
        database.insert(TABLE_NAME, null, contentValues);
    }

    public Cursor fetch() {
        String[] columns = new String[]{DatabaseHelper._ID, DatabaseHelper.BRAND, DatabaseHelper.PRICE, DatabaseHelper.UNIT, DatabaseHelper.SIZE, DatabaseHelper.LOCATION};
        Cursor cursor = database.query(TABLE_NAME, columns, null, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        return cursor;
    }


    public int update(long _id, String product, String brand, double price, String unit,
                      double size, String location) {

            ContentValues contentValues = new ContentValues();
            contentValues.put(DatabaseHelper.TYPE, product);
            contentValues.put(DatabaseHelper.BRAND, brand);
            contentValues.put(DatabaseHelper.PRICE, price);
            contentValues.put(DatabaseHelper.UNIT, unit);
            contentValues.put(DatabaseHelper.SIZE, size);
            contentValues.put(DatabaseHelper.LOCATION, location);
            int i = database.update(DatabaseHelper.TABLE_NAME, contentValues, DatabaseHelper._ID + " = " + _id, null);
            return i;
    }


    public void delete(long _id) {
        database.delete(TABLE_NAME, DatabaseHelper._ID + "=" + _id, null);
    }
}

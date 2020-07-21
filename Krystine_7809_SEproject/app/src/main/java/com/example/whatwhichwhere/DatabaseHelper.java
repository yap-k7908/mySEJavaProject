package com.example.whatwhichwhere;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String TABLE_NAME = "Comaprison Table";
    public static final String _ID="#";
    public static final String TYPE = "Product";
    public static final String BRAND = "Brand";
    public static final String PRICE = "Price";
    public static final String UNIT = "per";
    public static final String SIZE = "Size";
    public static final String LOCATION = "Location";

    static final String DB_NAME = "GROCERY_ITEMS.DB";
    static final int DB_VERSION = 1;

    private static final String CREATE_TABLE = "create table " + TABLE_NAME + "(" + _ID
            + " INTEGER PRIMARY KEY AUTOINCREMENT, " +TYPE + " TEXT NOT NULL" + BRAND + PRICE + " DOUBLE NOT NULL, " + UNIT + " TEXT NOT NULL, " + SIZE + " DOUBLE NOT NULL, " + LOCATION + " TEXT);";

    public static final String DELETE_TABLE_NAME="DROP TABLE IF EXISTS " + TABLE_NAME;
    // Create database
    public DatabaseHelper(Context context) {
        // factory is for creating cursor objects, or null for the default factory
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }


}

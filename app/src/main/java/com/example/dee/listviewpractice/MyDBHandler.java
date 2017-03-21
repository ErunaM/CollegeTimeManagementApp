package com.example.dee.listviewpractice;

/**
 * Created by Dee on 19/03/2017.
 */
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.Cursor;
import android.content.Context;
import android.content.ContentValues;

public class MyDBHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "days.db";

    public static final String TABLE_PRODUCTS = "days";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_DAYASSIGNMENT = "mainAssignment";
    public static final String COLUMN_PRODUCTNAME = "dayName";

    public MyDBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "CREATE TABLE " + TABLE_PRODUCTS + "(" + COLUMN_ID +  " INTEGER PRIMARY KEY AUTOINCREMENT " + COLUMN_PRODUCTNAME+ " TEXT " + COLUMN_DAYASSIGNMENT + " TEXT" + ");";
        sqLiteDatabase.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_PRODUCTS);
        onCreate(sqLiteDatabase);
    }

    //Add new row to DATABASE
    public void addItem(Days day)
    {
        // set a bunch of different values for different columes (list of values)
        ContentValues values = new ContentValues();
        values.put(COLUMN_PRODUCTNAME, day.getDays());
        values.put(COLUMN_DAYASSIGNMENT, day.getMainAssignment());
        SQLiteDatabase sqLiteDatabase = getWritableDatabase(); // database we writing too
        sqLiteDatabase.insert(TABLE_PRODUCTS,null,values);//Table,null,values (inserts new row)
        sqLiteDatabase.close();
    }

    //Delete item from Database
    public void deleteItem(String mainAssignment)
    {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase(); // database we writing too
        sqLiteDatabase.execSQL("DELETE FROM " + TABLE_PRODUCTS + " WHERE " + COLUMN_DAYASSIGNMENT + "=\"" + mainAssignment + "\";");

    }
    //print out database as a string
    public String databaseToString()
    {
        String dbString = "";
        SQLiteDatabase sqLiteDatabase = getWritableDatabase(); // database we writing too
        String query = "SELECT * FROM " + TABLE_PRODUCTS + "WHERE 1"; // 1 means every row * means every columns

        //Cursor points to locations in the results
        Cursor cursor = sqLiteDatabase.rawQuery(query,null);
        //Move to first row in results
        cursor.moveToFirst();

        // loops through every product and extracts the productname
        while(!cursor.isAfterLast())
        {
            if(cursor.getString(cursor.getColumnIndex("productname"))!= null)
            {
                dbString += cursor.getString(cursor.getColumnIndex("productname"));
                dbString += "\n";
            }
        }
        sqLiteDatabase.close();
        return dbString;
    }
}

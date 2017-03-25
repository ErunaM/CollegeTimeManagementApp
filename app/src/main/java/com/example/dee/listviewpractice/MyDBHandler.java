package com.example.dee.listviewpractice;

/**
 * Created by Dee on 19/03/2017.
 */
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.Cursor;
import android.content.Context;
import android.content.ContentValues;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MyDBHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "days.db";

    public static final String TABLE_PRODUCTS = "days";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_DAYASSIGNMENT = "mainAssignment";
    public static final String COLUMN_PRODUCTNAME = "dayName";
    private final ArrayList<Days> dayList = new ArrayList<>();

    public MyDBHandler(Context context) {
        super(context, Constants.DATABASE_NAME, null, Constants.DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "CREATE TABLE " + Constants.TABLE_NAME + "(" + Constants.KEY_ID +  " INTEGER PRIMARY KEY, " + Constants.DAY_NAME + " TEXT, " +
                Constants.Main_Assignment_NAME + " TEXT" + ");";
        sqLiteDatabase.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + Constants.TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    //Add new row to DATABASE
    public void addItem(Days day)
    {
        // set a bunch of different values for different columes (list of values)
        ContentValues values = new ContentValues();
        values.put(Constants.DAY_NAME, day.getDays());
        values.put(Constants.Main_Assignment_NAME, day.getMainAssignment());
        SQLiteDatabase sqLiteDatabase = getWritableDatabase(); // database we writing too
        sqLiteDatabase.insert(Constants.TABLE_NAME,null,values);//Table,null,values (inserts new row)
        sqLiteDatabase.close();
    }

    //Delete item from Database
    public void deleteItem(String mainAssignment)
    {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase(); // database we writing too
        sqLiteDatabase.execSQL("DELETE FROM " + Constants.TABLE_NAME + " WHERE " + Constants.Main_Assignment_NAME + "=\"" + mainAssignment + "\";");

    }
    //print out database as a string Not working how i want it
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
    public ArrayList<Days> getDays()
    {
        dayList.clear();
        SQLiteDatabase dba = this.getReadableDatabase();
        Cursor cursor = dba.query(Constants.TABLE_NAME, new String[]{Constants.KEY_ID, Constants.DAY_NAME,
                Constants.Main_Assignment_NAME},null,null,null,null, Constants.DAY_NAME + " DESC ");
        //Looping
        if(cursor.moveToFirst())
        {
            do{
                Days day = new Days();
                day.setDays(cursor.getString(cursor.getColumnIndex(Constants.DAY_NAME)));
                day.setMainAssignment(cursor.getString(cursor.getColumnIndex(Constants.Main_Assignment_NAME)));
                day.setDayId(cursor.getInt(cursor.getColumnIndex(Constants.KEY_ID)));


                dayList.add(day);
            }while(cursor.moveToNext());
        }
        cursor.close();
        dba.close();

        return dayList;
    }

}

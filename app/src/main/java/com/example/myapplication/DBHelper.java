package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.io.ByteArrayOutputStream;

public class DBHelper extends SQLiteOpenHelper {
    private Context context;
    public static  final String DATABASE_NAME="Leaderboard.db";
    public static final int DATABASE_VERSION=1;
    public  static final String COLUMN_ID="id";
    public  static final String COLUMN_NAME="name";
    public  static final String COLUMN_SCORE="score";
    public  static final String COLUMN_LEVEL="level";
    public  static final String TABLE_NAME="leaderboard";


    public DBHelper(@Nullable Context context) {
        super(context,DATABASE_NAME, null, DATABASE_VERSION);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query="CREATE TABLE "+ TABLE_NAME +"("+ COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_NAME +" TEXT, "+COLUMN_LEVEL +" TEXT, "+
        COLUMN_SCORE + " INTEGER);";
        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME);
        onCreate(db);


    }
    void add(String name,int score,String level){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv =new ContentValues();
        cv.put(COLUMN_NAME,name);
        cv.put(COLUMN_SCORE,score);
        cv.put(COLUMN_LEVEL,level);
        long result =db.insert(TABLE_NAME,null,cv);
        if (result==-1){
            Toast.makeText(context,"Failed",Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context,"Added Successfully",Toast.LENGTH_SHORT).show();
        }

    }

    Cursor readallData() {
        String query = "SELECT * FROM " + TABLE_NAME + " WHERE " + COLUMN_LEVEL + " IN ('Hard', 'Medium', 'Easy') ORDER BY CASE " + COLUMN_LEVEL + " WHEN 'Hard' THEN 1 WHEN 'Medium' THEN 2 WHEN 'Easy' THEN 3 END, " + COLUMN_SCORE + " ASC";


        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = null;
        if (db != null) {
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }

}
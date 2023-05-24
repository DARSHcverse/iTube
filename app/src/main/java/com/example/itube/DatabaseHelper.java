package com.example.itube;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String MyDatabase="mydatabase.db";

    public static final int VERSION=3;

    public DatabaseHelper(@Nullable Context context) {
        super(context, MyDatabase, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE userdetail (id INTEGER PRIMARY KEY, Name TEXT, UserName TEXT, Password TEXT, Confirm_Password TEXT)");
        db.execSQL("CREATE TABLE YoutubeURL (id INTEGER PRIMARY KEY, URL TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS userdetail");
        db.execSQL("DROP TABLE IF EXISTS YoutubeURL");
    }
    public Boolean checkuserpass(String username,String password)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.rawQuery("select * from userdetail where UserName = ? and Password = ?", new String[] {username,password});
        if(cursor.getCount()>0)
        {
            return true;
        }
        else{
            return false;
        }
    }

    public Cursor getdata()
    {
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.rawQuery("SELECT * FROM YoutubeURL",null);
        return cursor;
    }
}

package com.javatpoint.dietsqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    public DatabaseHelper(Context context) {
        super(context, "user0.db", null, 1);
    }

    public DatabaseHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create Table users1(lname Text ,pass Text,email Text,phone Text)");
        db.execSQL("create Table users(username Text primary key,password Text)");
        db.execSQL("create Table dietdata(name Text ,password Text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        db.execSQL("drop Table if exists users1");
        db.execSQL("drop Table if exists users");
        db.execSQL("drop Table if exists dietdata");
        onCreate(db);
    }


    public Boolean Data( String lname, String pass, String email, String phone) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("lname", lname);
        contentValues.put("pass", pass);
        contentValues.put("email", email);
        contentValues.put("phone", phone);
        long result1 = db.insert("users1", null, contentValues);
        if (result1 == 1) {
            return true;
        } else {
            return false ;
        }
    }



    public Boolean DietData( String name, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("name", name);
        contentValues.put("password", password);
        long result2 = db.insert("dietdata", null, contentValues);
        if (result2 == 1) {
            return true;
        } else {
            return false ;
        }
    }



    public Boolean insertData(String username, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", username);
        contentValues.put("password", password);
        long result = db.insert("users", null, contentValues);
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }


    public Boolean checkusername(String username)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.rawQuery("select * from users where username = ?",new String[] {username});
        if(cursor.getCount()>0){
            return true;
        }
        else
        {
            return false;
        }
}
public Boolean checkusernamePassword(String username,String password){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.rawQuery("select * from users where username = ?",new String[]{password});
        if(cursor.getCount()>0){
            return true;
        }
        else{
            return false;
        }


}
  public Cursor getAllData(){
        SQLiteDatabase db=this.getWritableDatabase();
      Cursor cursor=db.rawQuery("select*from dietdata",null);
        return cursor;
    }

}


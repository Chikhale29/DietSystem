package com.javatpoint.dietsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

public class DietDatabase extends AppCompatActivity {
DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diet_database);
        db=new DatabaseHelper(this);
        Cursor cursor=db.getAllData();
        if(cursor.getCount()==0){
            Toast.makeText(getApplicationContext(), "NO data", Toast.LENGTH_SHORT).show();
        }
        else{
            while(cursor.moveToNext()){
                Toast.makeText(getApplicationContext(), "Name:"+cursor.getString(0), Toast.LENGTH_SHORT).show();
                Toast.makeText(getApplicationContext(), "Password:"+cursor.getString(1), Toast.LENGTH_SHORT).show();

            }
        }

    }
}
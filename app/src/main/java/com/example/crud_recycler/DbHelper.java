package com.example.crud_recycler;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DbHelper extends SQLiteOpenHelper {
    public DbHelper(@Nullable Context context) {
        super(context, "Employee",null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query="CREATE TABLE EMPLOYEE (ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,AGE INTEGER)";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
    }

    public Boolean insert(String name, int age){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("Name",name);
        contentValues.put("Age",age);
        long res=db.insert("Employee",null,contentValues);
        if(res==-1){
            return false;
        }else{
            return true;
        }
    }

    public List<Employee> allData(){
        String query="SELECT * FROM EMPLOYEE";
        List<Employee>data=new ArrayList<Employee>();
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor res=db.rawQuery(query);
        if(res.moveToFirst()){

        }

    }
}

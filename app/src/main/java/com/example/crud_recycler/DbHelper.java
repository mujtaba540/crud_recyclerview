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

    public Boolean update(String name, int age,int id){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("Name",name);
        contentValues.put("Age",age);
        long res=db.update("Employee",contentValues,"ID=?",new String[]{name});
        if(res==-1){
            return false;
        }else{
            return true;
        }
    }
    public Boolean delete(String name, int age,int id){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("Name",name);
        contentValues.put("Age",age);
        long res=db.delete("Employee","where ID=?",new String[]{Integer.toString(id)});
        if(res==-1){
            return false;
        }else{
            return true;
        }
    }
    public ArrayList<Employee> allData(){
        String query="SELECT * FROM EMPLOYEE";
        ArrayList<Employee>data=new ArrayList<Employee>();
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor res=db.rawQuery(query,null);
        if(res.moveToFirst()){
            do {
                String name=res.getString(1);
                int age=res.getInt(2);
                data.add(new Employee(age,name));
            }while(res.moveToNext());
        }else{

        }
        res.close();
        return data;
    }
}

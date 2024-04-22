package com.example.my;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

public class DBHelper_2 extends SQLiteOpenHelper{
    public DBHelper_2(Context context) {
        super(context, "Locationdata.db", null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase DB2) {
        DB2.execSQL("create Table Locationdetails(nation TEXT primary key, name TEXT, organization TEXT, address TEXT, city TEXT, phone TEXT, email TEXT)");
    }
    @Override
    public void onUpgrade(SQLiteDatabase DB2, int i, int ii) {
        DB2.execSQL("drop Table if exists Locationdetails");
    }
    public Boolean insertuserdata(String nation, String name, String organization, String address, String city, String phone, String email)
    {
        SQLiteDatabase DB2 = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("nation", nation);
        contentValues.put("name", name);
        contentValues.put("organization", organization);
        contentValues.put("address", address);
        contentValues.put("city", city);
        contentValues.put("phone", phone);
        contentValues.put("email", email);
        long result=DB2.insert("Locationdetails", null, contentValues);
        if(result==-1){
            return false;
        }else{
            return true;
        }
    }
    public Boolean deletedata (String name)
    {
        SQLiteDatabase DB2 = this.getWritableDatabase();
        Cursor cursor = DB2.rawQuery("Select * from Locationdetails where name = ?", new String[]{name});
        if (cursor.getCount() > 0) {
            long result = DB2.delete("Locationdetails", "name=?", new String[]{name});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

}

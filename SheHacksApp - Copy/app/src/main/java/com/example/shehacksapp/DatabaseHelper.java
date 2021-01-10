package com.example.shehacksapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    public DatabaseHelper(@Nullable Context context) {
        super(context, "Login.db", null, 5);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE user(email TEXT PRIMARY KEY, password TEXT)");
        db.execSQL("CREATE TABLE food(name TEXT PRIMARY KEY, price TEXT, amount TEXT)");
        db.execSQL("CREATE TABLE other(name TEXT PRIMARY KEY, price TEXT, amount TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS user");
        db.execSQL("DROP TABLE IF EXISTS food");
        db.execSQL("DROP TABLE IF EXISTS other");
    }

    /**
     * a method that inserts the information into the database
     * @param email: the email the user signed up with
     * @param password: the password the user entered
     */
    public boolean insert (String email, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("email", email);
        contentValues.put("password", password);
        long ins = db.replace("user", null, contentValues);
        return ins != -1;
    }//end method insert

    /**
     * Check if email exists already
     * @param email: the email that the user is signing up with
     * @return the number of times the email is found in the database
     */
    public boolean checkEmail(String email){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from user where email=?", new String[]{email});
        return cursor.getCount() <= 0;
    }//end method checkEmail

    public boolean checkCredentials (String email, String password){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from user where email=? and password=?", new String[]{email, password});
        return cursor.getCount() > 0;
    }//end method checkCredentials

    public boolean changePassword (String email, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("password", password);
        db.update("user", contentValues, "email=?", new String[]{email});
        return true;
    }//end method checkCredentials

    public boolean insertFoodDrinks (String name, String price, String amount) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("price", price);
        contentValues.put("amount", amount);
        long ins = db.replace("food", null, contentValues);
        return ins != -1;
    }

    public Cursor getFoodDrinks(String name){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select name from food where name=?", new String[]{name});
        return cursor;
    }

    public boolean updateFoodDrink (String name, String amount){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("amount", amount);
        long ins = db.update("food", contentValues, "name=?", new String[]{name});
        return ins != -1;
    }

    public boolean deleteFoodDrink(String name){
        SQLiteDatabase db = this.getWritableDatabase();
        long ins =  db.delete("food", "name=?", new String[]{name});
        return ins != -1;
    }

    public Cursor getRoommates(String email){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from user where email=?", new String[]{email});
        return cursor;
    }

    public boolean deleteRoommate(String email, String roomNum){
        String s = null;
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(roomNum, s);
        long ins = db.update("user", contentValues, "email=?", new String[]{email});
        return ins != -1;
    }

    public boolean insertRoommate (String r1, String email, String roomNum) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(roomNum, r1);
        long ins = db.update("user", contentValues, "email=?", new String[]{email});
        return ins != -1;
    }

    public boolean update (String key, String email, String update){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(key, update);
        long ins = db.update("other", contentValues, "name=?", new String[]{key});
        return ins != -1;
    }



}

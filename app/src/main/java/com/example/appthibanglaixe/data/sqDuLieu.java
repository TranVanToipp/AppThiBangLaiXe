package com.example.appthibanglaixe.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.appthibanglaixe.entity.modify;

public class sqDuLieu extends SQLiteOpenHelper {
    private static final String DB_Name = "banglaixea1";
    private static final int DB_VERSION = 1;
    private static sqDuLieu instance = null;

    //chạy trên nhiều luồng
    public synchronized static sqDuLieu getInstance(Context context){
        if(instance == null){
            instance = new sqDuLieu(context);
        }
        return instance;
    }
    public sqDuLieu(@Nullable Context context) {
        super(context, DB_Name, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = modify.QUERY_CREATE_TABLE;
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

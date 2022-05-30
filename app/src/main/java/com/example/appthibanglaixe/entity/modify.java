package com.example.appthibanglaixe.entity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.appthibanglaixe.data.sqDuLieu;
import com.example.appthibanglaixe.model.cauhoi_traloi;

public class modify {
    public static final String QUERY_CREATE_TABLE = "create table cauhoi(create table cauhoi\n" +
            "(\n" +
            "\tcau integer primary key autoincrement,\n" +
            "\tnd_cauhoi text,\n" +
            "\thinh varchar(30),\n" +
            "\tdapana text,\n" +
            "\tdapanb text,\n" +
            "\tdapanc text,\n" +
            "\tdapand text,\n" +
            "\tcaudung text,\n" +
            "\tcaudiemliet int,\n" +
            "\tloaicauhoi text,\n" +
            "))";

    // phương thức lấy hết dữ liệu của bảng
    public static Cursor finAll(){
        String sql = "select * from cauhoi";
        SQLiteDatabase sqLiteDatabase = sqDuLieu.getInstance(null).getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(sql,null);
        return cursor;
    }

    // phương thức thêm dữ liệu
    public static void insert(cauhoi_traloi cauhoi) {
SQLiteDatabase sqLiteDatabase = sqDuLieu.getInstance(null).getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("cau",  cauhoi.getCau());
        values.put("noidung", cauhoi.getNoidungcauhoi());
        values.put("hinhcauhoi", cauhoi.getHinhcauhoi());
        values.put("a", cauhoi.getA());
        values.put("b", cauhoi.getB());
        values.put("c", cauhoi.getC());
        values.put("d", cauhoi.getD());
        values.put("caudung", cauhoi.getCaudung());
        values.put("caudiemliet", cauhoi.getCauliet());
        values.put("loaicauhoi", cauhoi.getLoaicauhoi());
        sqLiteDatabase.insert("cauhoi", null, values);
    }
}

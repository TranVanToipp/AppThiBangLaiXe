package com.example.appthibanglaixe.entity;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.example.appthibanglaixe.data.sqDuLieu;
import com.example.appthibanglaixe.model.cauhoi_traloi;

import java.util.ArrayList;

public class modify {
    public Context context;
    private static final String TABLE_NAME ="cauhoi";
    public static final String QUERY_CREATE_TABLE = "CREATE TABLE "+TABLE_NAME +" (" +
            "\tcau TEXT,\n" +
            "\tnd_cauhoi TEXT,\n" +
            "\thinh TEXT,\n" +
            "\tdapana TEXT,\n" +
            "\tdapanb TEXT,\n" +
            "\tdapanc TEXT,\n" +
            "\tdapand TEXT,\n" +
            "\tcaudung TEXT,\n" +
            "\tcaudiemliet TEXT,\n" +
            "\tloaicauhoi TEXT,\n" +
            "\tbode TEXT,\n"+
            ")";

    // phương thức lấy hết dữ liệu của bảng
    public static Cursor finAll(){
        String sql = "select * from "+TABLE_NAME;
        SQLiteDatabase sqLiteDatabase = sqDuLieu.getInstance(null).getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(sql,null);
        cursor.close();
        return cursor;
    }

    // phương thức thêm dữ liệu
    public static void insert(cauhoi_traloi cauhoi) {
SQLiteDatabase sqLiteDatabase = sqDuLieu.getInstance(null).getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("cau",  cauhoi.getCau());
        values.put("nd_cauhoi", cauhoi.getNoidungcauhoi());
        values.put("hinh", cauhoi.getHinhcauhoi());
        values.put("dapana", cauhoi.getA());
        values.put("dapanb", cauhoi.getB());
        values.put("dapanc", cauhoi.getC());
        values.put("dapand", cauhoi.getD());
        values.put("caudung", cauhoi.getCaudung());
        values.put("caudiemliet", cauhoi.getCauliet());
        values.put("loaicauhoi", cauhoi.getLoaicauhoi());
        values.put("bode", cauhoi.getBode());
        sqLiteDatabase.insert("cauhoi", null, values);
    }
    public static boolean Check(String cauu) {
        ArrayList<cauhoi_traloi> arrcauhoi;
        arrcauhoi = (ArrayList<cauhoi_traloi>) modify.finAll();
        for (cauhoi_traloi c : arrcauhoi) {
            if(c.getCau() == cauu){
                return true;
            }
        }
        return false;
    }
}

package com.example.appthibanglaixe.data;

import android.provider.BaseColumns;

public class DbContract {
    public static final class MenuEntry implements BaseColumns {
        public static final String TABLE_NAME = "cauhoi_traloi";
        public static final String COLUMN_CAU = "cau";
        public static final String COLUMN_NOIDUNGCAUHOI = "noidungcauhoi";
        public static final String COLUMN_HINHCAUHOI = "hinhcauhoi";
        public static final String COLUMN_A = "a";
        public static final String COLUMN_B = "b";
        public static final String COLUMN_C = "c";
        public static final String COLUMN_D = "d";
        public static final String COLUMN_CAUDUNG = "caudung";
        public static final String COLUMN_CAUDIEMLIET = "caudiemliet";
        public static final String COLUMN_LOAICAUHOI = "loaicauhoi";
        public static final String COLUMN_SOBODE = "sobode";

    }

    public static final class Lythuyet implements BaseColumns{
        public static final String TABLE_NAME1 = "lythuyet";
        public static final String COLUMN_HINH = "hinh";
        public static final String COLUMN_TIEUDE = "tieude";
        public static final String COLUMN_SOCAU = "socau";
        public static final String COLUMN_DIEMLIET = "caudiemliet";
        public static final String COLUMN_TIENDO = "tiendo";
    }
}

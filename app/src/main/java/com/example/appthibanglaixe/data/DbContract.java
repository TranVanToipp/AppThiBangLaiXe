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
        public static final String COLUMN_CNDC = "CauNDChon";
        public static final String COLUMN_NGUOIDUNGLYTHUYET = "nguoidunglythuet";

    }

    public static final class Lythuyet implements BaseColumns{
        public static final String TABLE_NAME1 = "lythuyet";
        public static final String COLUMN_TIEUDE = "tieude";
        public static final String COLUMN_HINH = "hinh";
        public static final String COLUMN_SOCAU = "socau";
        public static final String COLUMN_DIEMLIET = "caudiemliet";
        public static final String COLUMN_TIENDO = "tiendo";
    }
    public static final class BoDe implements BaseColumns{
        public static final String TABLE_NAMEBODE = "bode";
        public static final String COLUM_BDSO = "bodeso";
        public static final String COLUM_SOCAU = "socau";
        public static final String COLUM_DIEM = "diem";
        public static final String COLUM_KQ = "ketqua";
    }
    public static final class MeoThi implements BaseColumns{
        public static final String TABLE_NAMEMEOTHI = "meothi";
        public static final String COLUM_IDMEOTHI = "id_meothi";
        public static final String COLUM_NDMEOTHI = "nd_meothi";
        public static final String COLUM_LOAI = "loai";
    }
}

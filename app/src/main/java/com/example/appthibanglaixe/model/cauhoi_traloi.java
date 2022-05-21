package com.example.appthibanglaixe.model;

public class cauhoi_traloi {
    public int cau;
    public  String Noidungcauhoi;
    public String Hinhcauhoi;
    public  String a;
    public String b;
    public String c;
    public String d;
    public String Caudung;
    public String Cauliet;

    public cauhoi_traloi(int cau, String noidungcauhoi, String hinhcauhoi, String a, String b, String c, String d, String caudung, String cauliet) {
        this.cau = cau;
        Noidungcauhoi = noidungcauhoi;
        Hinhcauhoi = hinhcauhoi;
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        Caudung = caudung;
        Cauliet = cauliet;
    }

    public int getCau() {
        return cau;
    }

    public void setCau(int cau) {
        this.cau = cau;
    }

    public String getNoidungcauhoi() {
        return Noidungcauhoi;
    }

    public void setNoidungcauhoi(String noidungcauhoi) {
        Noidungcauhoi = noidungcauhoi;
    }

    public String getHinhcauhoi() {
        return Hinhcauhoi;
    }

    public void setHinhcauhoi(String hinhcauhoi) {
        Hinhcauhoi = hinhcauhoi;
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }

    public String getD() {
        return d;
    }

    public void setD(String d) {
        this.d = d;
    }

    public String getCaudung() {
        return Caudung;
    }

    public void setCaudung(String caudung) {
        Caudung = caudung;
    }

    public String getCauliet() {
        return Cauliet;
    }

    public void setCauliet(String cauliet) {
        Cauliet = cauliet;
    }
}

package com.example.appthibanglaixe.model;

import java.io.Serializable;

public class cauhoi_traloi  {
    private int ID;
    private String cau,Noidungcauhoi,Hinhcauhoi,a,b,c,d,Caudung,Cauliet,loaicauhoi,bode,CauNDChon, Nguoidunglythuet;

    public cauhoi_traloi(){

    }
    public cauhoi_traloi(int id,String cau, String noidungcauhoi, String hinhcauhoi, String a, String b, String c, String d, String caudung, String cauliet, String loaicauhoi, String bode, String CauNDChon, String Nguoidunglythuyet) {
        this.ID = id;
        this.cau = cau;
        this.Noidungcauhoi = noidungcauhoi;
        this.Hinhcauhoi = hinhcauhoi;
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.Caudung = caudung;
        this.Cauliet = cauliet;
        this.loaicauhoi = loaicauhoi;
        this.bode=bode;
        this.CauNDChon = CauNDChon;
        this.Nguoidunglythuet = Nguoidunglythuyet;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getBode() {
        return bode;
    }

    public void setBode(String bode) {
        this.bode = bode;
    }

    public String getCau() {
        return cau;
    }

    public void setCau(String cau) {
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

    public String getLoaicauhoi() {
        return loaicauhoi;
    }

    public void setLoaicauhoi(String loaicauhoi) {
        this.loaicauhoi = loaicauhoi;
    }

    public String getCauNDChon() {
        return CauNDChon;
    }

    public void setCauNDChon(String cauNDChon) {
        CauNDChon = cauNDChon;
    }

    public String getNguoidunglythuet() {
        return Nguoidunglythuet;
    }

    public void setNguoidunglythuet(String nguoidunglythuet) {
        Nguoidunglythuet = nguoidunglythuet;
    }
}


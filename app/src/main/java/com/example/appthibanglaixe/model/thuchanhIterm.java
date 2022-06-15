package com.example.appthibanglaixe.model;

public class thuchanhIterm {
    private int id;
    private String id_meothi,noidung,loai;

    public thuchanhIterm(int id, String id_meothi, String noidung, String loai) {
        this.id = id;
        this.id_meothi = id_meothi;
        this.noidung = noidung;
        this.loai = loai;
    }

    public String getId_meothi() {
        return id_meothi;
    }

    public void setId_meothi(String id_meothi) {
        this.id_meothi = id_meothi;
    }

    public String getLoai() {
        return loai;
    }

    public void setLoai(String loai) {
        this.loai = loai;
    }

    public thuchanhIterm(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNoidung() {
        return noidung;
    }

    public void setNoidung(String noidung) {
        this.noidung = noidung;
    }

}

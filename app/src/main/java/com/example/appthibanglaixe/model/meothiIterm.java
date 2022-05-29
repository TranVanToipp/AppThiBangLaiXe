package com.example.appthibanglaixe.model;

public class meothiIterm {
    private int id;
    private String noidung;

    public meothiIterm(int id, String noidung) {
        this.id = id;
        this.noidung = noidung;
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

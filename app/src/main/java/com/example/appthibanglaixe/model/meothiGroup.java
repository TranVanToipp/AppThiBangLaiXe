package com.example.appthibanglaixe.model;

public class meothiGroup {
    private int id;
    private String loai;

    public meothiGroup(int id, String loai) {
        this.id = id;
        this.loai = loai;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLoai() {
        return loai;
    }

    public void setLoai(String loai) {
        this.loai = loai;
    }
}

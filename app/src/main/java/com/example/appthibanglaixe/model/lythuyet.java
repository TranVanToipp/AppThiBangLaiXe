package com.example.appthibanglaixe.model;

public class lythuyet {
    int id;
    private String hinhanh;
    private String loaicauhoi;
    private String socauhoi;
    private String caudiemliet;
    private String tiendo;

    public lythuyet(){

    }

    public lythuyet(int id ,String hinhanh, String loaicauhoi, String socauhoi, String caudiemliet, String tiendo) {
        this.id = id;
        this.hinhanh = hinhanh;
        this.loaicauhoi = loaicauhoi;
        this.socauhoi = socauhoi;
        this.caudiemliet = caudiemliet;
        this.tiendo = tiendo;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHinhanh() {
        return hinhanh;
    }

    public void setHinhanh(String hinhanh) {
        this.hinhanh = hinhanh;
    }

    public String getLoaicauhoi() {
        return loaicauhoi;
    }

    public void setLoaicauhoi(String loaicauhoi) {
        this.loaicauhoi = loaicauhoi;
    }

    public String getSocauhoi() {
        return socauhoi;
    }

    public void setSocauhoi(String socauhoi) {
        this.socauhoi = socauhoi;
    }

    public String getCaudiemliet() {
        return caudiemliet;
    }

    public void setCaudiemliet(String caudiemliet) {
        this.caudiemliet = caudiemliet;
    }

    public String getTiendo() {
        return tiendo;
    }

    public void setTiendo(String tiendo) {
        this.tiendo = tiendo;
    }
}

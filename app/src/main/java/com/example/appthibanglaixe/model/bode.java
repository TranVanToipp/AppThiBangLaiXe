package com.example.appthibanglaixe.model;

public class bode {
    private int id;
    private String sobode, socau, diem, ketqua;


    public bode(){

    }

    public bode(int id,String sobode, String socau, String diem, String ketqua) {
        this.id = id;
        this.sobode = sobode;
        this.socau = socau;
        this.diem = diem;
        this.ketqua=ketqua;
    }
    public String getDiem() {
        return diem;
    }

    public void setDiem(String diem) {
        this.diem = diem;
    }

    public String getKetqua() {
        return ketqua;
    }

    public void setKetqua(String ketqua) {
        this.ketqua = ketqua;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSocau() {
        return socau;
    }

    public void setSocau(String socau) {
        this.socau = socau;
    }

    public String getSobode() {
        return sobode;
    }

    public void setSobode(String sobode) {
        this.sobode = sobode;
    }
}

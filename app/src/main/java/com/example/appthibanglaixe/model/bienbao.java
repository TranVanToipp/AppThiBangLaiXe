package com.example.appthibanglaixe.model;

public class bienbao {
    public String hinhbienbao;
    public String noidungbienbao;
//    public String loaibienbao;

    public bienbao(String hinhbienbao, String noidungbienbao) {
        this.hinhbienbao = hinhbienbao;
        this.noidungbienbao = noidungbienbao;
       // this.loaibienbao = loaibienbao;
    }

    public String getHinhbienbao() {
        return hinhbienbao;
    }

    public void setHinhbienbao(String hinhbienbao) {
        this.hinhbienbao = hinhbienbao;
    }

    public String getNoidungbienbao() {
        return noidungbienbao;
    }

    public void setNoidungbienbao(String noidungbienbao) {
        this.noidungbienbao = noidungbienbao;
    }

}

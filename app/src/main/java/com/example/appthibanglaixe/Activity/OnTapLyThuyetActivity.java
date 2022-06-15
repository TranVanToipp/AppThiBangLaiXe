package com.example.appthibanglaixe.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.ContentValues;
import android.content.Intent;
import android.icu.text.CaseMap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.appthibanglaixe.Adapter.OnLyThuyetAdapter;
import com.example.appthibanglaixe.R;
import com.example.appthibanglaixe.data.sqDuLieu;
import com.example.appthibanglaixe.model.cauhoi_traloi;
import com.example.appthibanglaixe.data.DbContract;
import com.example.appthibanglaixe.model.lythuyet;

import java.util.ArrayList;

public class OnTapLyThuyetActivity extends AppCompatActivity {
    Toolbar toobar;
    TextView txtnoidung, txtcaudiemliet, txtdapana, txtdapanb, txtdapanc, txtdapand, txtcau;
    ImageView imghinhanh;
    sqDuLieu dulieu;
    Button btnback, btnnext;
    int currentQuestionPosition = 0 ;
    String cauhoinguoidungchon = "";
    String tiendo;

    @Override
    public void onBackPressed() {

        super.onBackPressed();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_tap_ly_thuyet);
        Anhxa();
        Xulitoobar();
        dulieu = new sqDuLieu(this);
        int i = laydulieu();
        ArrayList<cauhoi_traloi> valuse = dulieu.getAllCauhoi(i);
        ArrayList<lythuyet> valu = dulieu.getdulieulythuyet();
        int lt = i-1;
        toobar.setTitle(valu.get(lt).getLoaicauhoi());
        txtnoidung.setText(valuse.get(0).getNoidungcauhoi());
//        if(valuse.get(0).getCauliet().equals("1")){
//            txtcaudiemliet.setText("(câu điểm liệt)");
//        }
        if(valuse.get(0).getHinhcauhoi().isEmpty()){
            imghinhanh.setVisibility(View.GONE);
        }else {
            Glide.with(getApplicationContext()).load(valuse.get(0).getHinhcauhoi()).into(imghinhanh);
        }
        if(valuse.get(0).getA().isEmpty()){
            txtdapana.setVisibility(View.GONE);
        }else {
            txtdapana.setText(valuse.get(0).getA());
            if(valuse.get(0).getCaudung().equals("a") && valuse.get(0).getNguoidunglythuet().isEmpty());
            else if(valuse.get(0).getCaudung().equals("a")){
                txtdapana.setBackgroundResource(R.drawable.background_button);
                if(valuse.get(0).getNguoidunglythuet().equals("b"))
                    txtdapanb.setBackgroundResource(R.drawable.background_home);
                else if(valuse.get(0).getNguoidunglythuet().equals("c"))
                    txtdapanc.setBackgroundResource(R.drawable.background_home);
                else if(valuse.get(0).getNguoidunglythuet().equals("d"))
                    txtdapand.setBackgroundResource(R.drawable.background_home);
            }
        }if (valuse.get(0).getB().isEmpty()){
            txtdapanb.setVisibility(View.GONE);
        }else {
            txtdapanb.setText(valuse.get(0).getB());
            if(valuse.get(0).getCaudung().equals("b") && valuse.get(0).getNguoidunglythuet().isEmpty());
            else if(valuse.get(0).getCaudung().equals("b")){
                txtdapanb.setBackgroundResource(R.drawable.background_button);
                if(valuse.get(0).getNguoidunglythuet().equals("a"))
                    txtdapana.setBackgroundResource(R.drawable.background_home);
                else if(valuse.get(0).getNguoidunglythuet().equals("c"))
                    txtdapanc.setBackgroundResource(R.drawable.background_home);
                else if(valuse.get(0).getNguoidunglythuet().equals("d"))
                    txtdapand.setBackgroundResource(R.drawable.background_home);
            }
        }if(valuse.get(0).getC().isEmpty()){
            txtdapanc.setVisibility(View.GONE);
        }else {
            txtdapanc.setText(valuse.get(0).getC());
            if(valuse.get(0).getCaudung().equals("c") && valuse.get(0).getNguoidunglythuet().isEmpty());
            else if(valuse.get(0).getCaudung().equals("c")){
                txtdapanc.setBackgroundResource(R.drawable.background_button);
                if(valuse.get(0).getNguoidunglythuet().equals("b"))
                    txtdapanb.setBackgroundResource(R.drawable.background_home);
                else if(valuse.get(0).getNguoidunglythuet().equals("a"))
                    txtdapana.setBackgroundResource(R.drawable.background_home);
                else if(valuse.get(0).getNguoidunglythuet().equals("d"))
                    txtdapand.setBackgroundResource(R.drawable.background_home);
            }
        }if(valuse.get(0).getD().isEmpty()){
            txtdapand.setVisibility(View.GONE);
        }else {
            txtdapand.setText(valuse.get(0).getD());
            if(valuse.get(0).getCaudung().equals("d") && valuse.get(0).getNguoidunglythuet().isEmpty());
            else if(valuse.get(0).getCaudung().equals("d")){
                txtdapand.setBackgroundResource(R.drawable.background_button);
                if(valuse.get(0).getNguoidunglythuet().equals("b"))
                    txtdapanb.setBackgroundResource(R.drawable.background_home);
                else if(valuse.get(0).getNguoidunglythuet().equals("c"))
                    txtdapanc.setBackgroundResource(R.drawable.background_home);
                else if(valuse.get(0).getNguoidunglythuet().equals("a"))
                    txtdapana.setBackgroundResource(R.drawable.background_home);
            }
        }

        txtdapana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cauhoinguoidungchon = "a";
                txtdapana.setBackgroundResource(R.drawable.background_khonghienthi);
                txtdapanb.setBackgroundResource(R.drawable.background_khonghienthi);
                txtdapanc.setBackgroundResource(R.drawable.background_khonghienthi);
                txtdapand.setBackgroundResource(R.drawable.background_khonghienthi);
                checkDA(valuse,currentQuestionPosition,cauhoinguoidungchon);
                tiendo = tiendo(i);
                updatetd(tiendo,i);
                String cauD = valuse.get(currentQuestionPosition).getCaudung();
                if(cauD.equals("a"))
                    txtdapana.setBackgroundResource(R.drawable.background_button);
                if(cauD.equals("b"))
                    txtdapanb.setBackgroundResource(R.drawable.background_button);
                if(cauD.equals("c"))
                    txtdapanc.setBackgroundResource(R.drawable.background_button);
                if(cauD.equals("d"))
                    txtdapand.setBackgroundResource(R.drawable.background_button);
                ArrayList<cauhoi_traloi> val = dulieu.getAllCauhoi(i);
                String cauNDC = val.get(currentQuestionPosition).getNguoidunglythuet();
                if(cauNDC.equals(cauD))
                    txtdapana.setBackgroundResource(R.drawable.background_button);
                else
                    txtdapana.setBackgroundResource(R.drawable.background_home);

            }
        });

        txtdapanb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cauhoinguoidungchon = "b";
                txtdapana.setBackgroundResource(R.drawable.background_khonghienthi);
                txtdapanb.setBackgroundResource(R.drawable.background_khonghienthi);
                txtdapanc.setBackgroundResource(R.drawable.background_khonghienthi);
                txtdapand.setBackgroundResource(R.drawable.background_khonghienthi);
                checkDA(valuse,currentQuestionPosition,cauhoinguoidungchon);
                tiendo = tiendo(i);
                updatetd(tiendo,i);
                String cauD = valuse.get(currentQuestionPosition).getCaudung();
                if(cauD.equals("a"))
                    txtdapana.setBackgroundResource(R.drawable.background_button);
                if(cauD.equals("b"))
                    txtdapanb.setBackgroundResource(R.drawable.background_button);
                if(cauD.equals("c"))
                    txtdapanc.setBackgroundResource(R.drawable.background_button);
                if(cauD.equals("d"))
                    txtdapand.setBackgroundResource(R.drawable.background_button);
                ArrayList<cauhoi_traloi> val = dulieu.getAllCauhoi(i);
                String cauNDC = val.get(currentQuestionPosition).getNguoidunglythuet();
                if(cauNDC.equals(cauD))
                    txtdapanb.setBackgroundResource(R.drawable.background_button);
                else
                    txtdapanb.setBackgroundResource(R.drawable.background_home);
            }
        });

        txtdapanc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cauhoinguoidungchon = "c";
                txtdapana.setBackgroundResource(R.drawable.background_khonghienthi);
                txtdapanb.setBackgroundResource(R.drawable.background_khonghienthi);
                txtdapanc.setBackgroundResource(R.drawable.background_khonghienthi);
                txtdapand.setBackgroundResource(R.drawable.background_khonghienthi);
                checkDA(valuse,currentQuestionPosition,cauhoinguoidungchon);
                tiendo = tiendo(i);
                updatetd(tiendo,i);
                String cauD = valuse.get(currentQuestionPosition).getCaudung();
                if(cauD.equals("a"))
                    txtdapana.setBackgroundResource(R.drawable.background_button);
                if(cauD.equals("b"))
                    txtdapanb.setBackgroundResource(R.drawable.background_button);
                if(cauD.equals("c"))
                    txtdapanc.setBackgroundResource(R.drawable.background_button);
                if(cauD.equals("d"))
                    txtdapand.setBackgroundResource(R.drawable.background_button);
                ArrayList<cauhoi_traloi> val = dulieu.getAllCauhoi(i);
                String cauNDC = val.get(currentQuestionPosition).getNguoidunglythuet();
                if(cauNDC.equals(cauD))
                    txtdapanc.setBackgroundResource(R.drawable.background_button);
                else
                    txtdapanc.setBackgroundResource(R.drawable.background_home);
            }
        });

        txtdapand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cauhoinguoidungchon = "d";
                txtdapana.setBackgroundResource(R.drawable.background_khonghienthi);
                txtdapanb.setBackgroundResource(R.drawable.background_khonghienthi);
                txtdapanc.setBackgroundResource(R.drawable.background_khonghienthi);
                txtdapand.setBackgroundResource(R.drawable.background_khonghienthi);
                checkDA(valuse,currentQuestionPosition,cauhoinguoidungchon);
                tiendo = tiendo(i);
                updatetd(tiendo,i);
                String cauD = valuse.get(currentQuestionPosition).getCaudung();
                if(cauD.equals("a"))
                    txtdapana.setBackgroundResource(R.drawable.background_button);
                if(cauD.equals("b"))
                    txtdapanb.setBackgroundResource(R.drawable.background_button);
                if(cauD.equals("c"))
                    txtdapanc.setBackgroundResource(R.drawable.background_button);
                if(cauD.equals("d"))
                    txtdapand.setBackgroundResource(R.drawable.background_button);
                ArrayList<cauhoi_traloi> val = dulieu.getAllCauhoi(i);
                String cauNDC = val.get(currentQuestionPosition).getNguoidunglythuet();
                if(cauNDC.equals(cauD))
                    txtdapand.setBackgroundResource(R.drawable.background_button);
                else
                    txtdapand.setBackgroundResource(R.drawable.background_home);
            }
        });
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(currentQuestionPosition == 0){
                    Toast.makeText(OnTapLyThuyetActivity.this, "Câu đầu tiên", Toast.LENGTH_SHORT).show();
                }else {
                    ArrayList<cauhoi_traloi> val = dulieu.getAllCauhoi(i);
                    currentQuestionPosition -= 1;
                    trolai(val);
                }
            }

        });

        btnnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<cauhoi_traloi> val = dulieu.getAllCauhoi(i);
                if(currentQuestionPosition == valuse.size()-1){
                    Toast.makeText(OnTapLyThuyetActivity.this, "Đã ôn Xong-- ", Toast.LENGTH_SHORT).show();
                }else {
                    currentQuestionPosition += 1;
                    chuyencauhoi(val);
                }

            }

        });
    }
    public String tiendo(int i){
        ArrayList<cauhoi_traloi>valuseTD = dulieu.getTienDo(i);
        String td = String.valueOf(valuseTD.size());
        return td;

    }
    public void checkDA(ArrayList<cauhoi_traloi> valuse,int i,String noidunglythuyet1){
        update(valuse,noidunglythuyet1,i);
    }

    private void update(ArrayList<cauhoi_traloi> valuse, String lythuyet,int i){
        ContentValues val = new ContentValues();
        val.put("nguoidunglythuet",lythuyet);
        dulieu.Update(DbContract.MenuEntry.TABLE_NAME,val, " _id = "+valuse.get(i).getID(),null);
    }


    private void updatetd(String tiendo,int i){
        ContentValues val = new ContentValues();
        val.put("tiendo",tiendo);
        dulieu.Update(DbContract.Lythuyet.TABLE_NAME1,val, " _id = " + i,null);
    }

    private int laydulieu() {
        Intent intent = getIntent();
        int i = (int) intent.getSerializableExtra("data1");
        return i;
    }

    private void Xulitoobar() {
        setSupportActionBar(toobar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void chuyencauhoi(ArrayList<cauhoi_traloi> valuse) {
        if(currentQuestionPosition < valuse.size()) {
            cauhoinguoidungchon = "";
            mauCau(valuse, currentQuestionPosition);
            txtcau.setText(currentQuestionPosition + 1 + "/" + valuse.size());
            txtnoidung.setText(valuse.get(currentQuestionPosition).getNoidungcauhoi());
            if(valuse.get(currentQuestionPosition).getCauliet().equals("1")){
                txtcaudiemliet.setText("(câu điểm liệt)");
            }
            if (valuse.get(currentQuestionPosition).getA().isEmpty()) {
                txtdapana.setVisibility(View.GONE);
            } else {
                txtdapana.setText(valuse.get(currentQuestionPosition).getA());
            }
            if (valuse.get(currentQuestionPosition).getB().isEmpty()) {
                txtdapanb.setVisibility(View.GONE);
            } else {
                txtdapanb.setText(valuse.get(currentQuestionPosition).getB());
            }
            if (valuse.get(currentQuestionPosition).getC().isEmpty()) {
                txtdapanc.setVisibility(View.GONE);
            } else {
                txtdapanc.setText(valuse.get(currentQuestionPosition).getC());
            }
            if (valuse.get(currentQuestionPosition).getD().isEmpty()) {
                txtdapand.setVisibility(View.GONE);
            } else {
                txtdapand.setText(valuse.get(currentQuestionPosition).getD());
            }
            if(valuse.get(currentQuestionPosition).getHinhcauhoi().isEmpty()){
                imghinhanh.setVisibility(View.GONE);
            }else {
                Glide.with(getApplicationContext()).load(valuse.get(currentQuestionPosition).getHinhcauhoi()).error(R.drawable.icon).into(imghinhanh);
            }
        }
    }
    public void trolai(ArrayList<cauhoi_traloi> valuse){
        if(currentQuestionPosition == valuse.size() - 1)
            currentQuestionPosition -= 1;
        if (currentQuestionPosition > -1 && currentQuestionPosition < valuse.size()) {
            cauhoinguoidungchon = "";
            mauCau(valuse, currentQuestionPosition);
            int cau = currentQuestionPosition + 1;
            txtcau.setText(cau + "/" + valuse.size());
            txtnoidung.setText(valuse.get(currentQuestionPosition).getNoidungcauhoi());
            if(valuse.get(currentQuestionPosition).getCauliet().equals("1")){
                txtcaudiemliet.setText("(câu điểm liệt)");
            }
            if (valuse.get(currentQuestionPosition).getA().isEmpty()) {
                txtdapana.setVisibility(View.GONE);
            } else {
                txtdapana.setText(valuse.get(currentQuestionPosition).getA());
            }
            if (valuse.get(currentQuestionPosition).getB().isEmpty()) {
                txtdapanb.setVisibility(View.GONE);
            } else {
                txtdapanb.setText(valuse.get(currentQuestionPosition).getB());
            }
            if (valuse.get(currentQuestionPosition).getC().isEmpty()) {
                txtdapanc.setVisibility(View.GONE);
            } else {
                txtdapanc.setText(valuse.get(currentQuestionPosition).getC());
            }
            if (valuse.get(currentQuestionPosition).getD().isEmpty()) {
                txtdapand.setVisibility(View.GONE);
            } else {
                txtdapand.setText(valuse.get(currentQuestionPosition).getD());
            }
            if (valuse.get(currentQuestionPosition).getHinhcauhoi().isEmpty()) {
                imghinhanh.setVisibility(View.GONE);
            } else {
                Glide.with(getApplicationContext()).load(valuse.get(currentQuestionPosition).getHinhcauhoi()).error(R.drawable.icon).into(imghinhanh);
            }
        }
    }

    public void mauCau(ArrayList<cauhoi_traloi> valuse,int cau){
        txtdapana.setVisibility(View.VISIBLE);
        txtdapanb.setVisibility(View.VISIBLE);
        txtdapanc.setVisibility(View.VISIBLE);
        txtdapand.setVisibility(View.VISIBLE);
        imghinhanh.setVisibility(View.VISIBLE);

        txtdapana.setBackgroundResource(R.drawable.backgroung_cautraloi);
        txtdapanb.setBackgroundResource(R.drawable.backgroung_cautraloi);
        txtdapanc.setBackgroundResource(R.drawable.backgroung_cautraloi);
        txtdapand.setBackgroundResource(R.drawable.backgroung_cautraloi);
        if(valuse.get(cau).getCaudung().equals("a") && valuse.get(cau).getNguoidunglythuet().isEmpty());
        else {
            if(valuse.get(cau).getCaudung().equals("a")){
                txtdapana.setBackgroundResource(R.drawable.background_button);
                if(valuse.get(cau).getNguoidunglythuet().equals("b"))
                    txtdapanb.setBackgroundResource(R.drawable.background_home);
                else if(valuse.get(cau).getNguoidunglythuet().equals("c"))
                    txtdapanc.setBackgroundResource(R.drawable.background_home);
                else if(valuse.get(cau).getNguoidunglythuet().equals("d"))
                    txtdapand.setBackgroundResource(R.drawable.background_home);
            }
        }
        if(valuse.get(cau).getCaudung().equals("b") && valuse.get(cau).getNguoidunglythuet().isEmpty());
        else {
            if(valuse.get(cau).getCaudung().equals("b")){
                txtdapanb.setBackgroundResource(R.drawable.background_button);
                if(valuse.get(cau).getNguoidunglythuet().equals("a"))
                    txtdapana.setBackgroundResource(R.drawable.background_home);
                else if(valuse.get(cau).getNguoidunglythuet().equals("c"))
                    txtdapanc.setBackgroundResource(R.drawable.background_home);
                else if(valuse.get(cau).getNguoidunglythuet().equals("d"))
                    txtdapand.setBackgroundResource(R.drawable.background_home);
            }
        }
        if(valuse.get(cau).getCaudung().equals("c") && valuse.get(cau).getNguoidunglythuet().isEmpty());
        else {
            if(valuse.get(cau).getCaudung().equals("c")){
                txtdapanc.setBackgroundResource(R.drawable.background_button);
                if(valuse.get(cau).getNguoidunglythuet().equals("b"))
                    txtdapanb.setBackgroundResource(R.drawable.background_home);
                else if(valuse.get(cau).getNguoidunglythuet().equals("a"))
                    txtdapana.setBackgroundResource(R.drawable.background_home);
                else if(valuse.get(cau).getNguoidunglythuet().equals("d"))
                    txtdapand.setBackgroundResource(R.drawable.background_home);
            }
        }
        if(valuse.get(cau).getCaudung().equals("c") && valuse.get(cau).getNguoidunglythuet().isEmpty());
        else {
            if (valuse.get(cau).getCaudung().equals("d")) {
                txtdapand.setBackgroundResource(R.drawable.background_button);
                if (valuse.get(cau).getNguoidunglythuet().equals("b"))
                    txtdapanb.setBackgroundResource(R.drawable.background_home);
                else if (valuse.get(cau).getNguoidunglythuet().equals("c"))
                    txtdapanc.setBackgroundResource(R.drawable.background_home);
                else if (valuse.get(cau).getNguoidunglythuet().equals("a"))
                    txtdapana.setBackgroundResource(R.drawable.background_home);
            }
        }
    }
    private void Anhxa() {
        txtnoidung = findViewById(R.id.aotlt_txtnoidung);
        txtcaudiemliet = findViewById(R.id.aotlt_caudiemliet);
        txtdapana = findViewById(R.id.aotlt_txtcaua);
        txtdapanb = findViewById(R.id.aotlt_txtcaub);
        txtdapanc = findViewById(R.id.aotlt_txtcauc);
        txtdapand = findViewById(R.id.aotlt_txtcaud);
        imghinhanh = findViewById(R.id.aotlt_imghinh);
        txtcau = findViewById(R.id.aotlt_txtcau);
        btnback = findViewById(R.id.aotlt_btnback);
        btnnext = findViewById(R.id.aotlt_btnnext);
        toobar = findViewById(R.id.aotlt_toobar);
    }
}
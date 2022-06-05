package com.example.appthibanglaixe.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
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
    int j = 0;
    int td = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_tap_ly_thuyet);
        Anhxa();
        Xulitoobar();
        dulieu = new sqDuLieu(this);
        int i = laydulieu();

        if(i == 1){
            j = 0;
        }else if (i == 2) {
            j = 1;
        }else if (i == 3){
            j = 2;
        }else if(i == 4){
            j = 3;
        }else {
            j = 4;
        }
        ArrayList<cauhoi_traloi> valuse = dulieu.getAllCauhoi(i);
        ArrayList<lythuyet> values1 = dulieu.getdulieulythuyet();
        txtnoidung.setText(valuse.get(0).getNoidungcauhoi());
        if(valuse.get(0).getCauliet().equals(1)){
            txtnoidung.setText(valuse.get(0).getNoidungcauhoi()+"(câu điểm liệt)");
        }
        if(valuse.get(0).getHinhcauhoi().isEmpty()){
            imghinhanh.setVisibility(View.GONE);
        }else {
            Glide.with(getApplicationContext()).load(valuse.get(0).getHinhcauhoi()).into(imghinhanh);
        }
        if(valuse.get(0).getA().isEmpty()){
            txtdapana.setVisibility(View.GONE);
        }else {
            txtdapana.setText(valuse.get(0).getA());
        }if (valuse.get(0).getB().isEmpty()){
            txtdapanb.setVisibility(View.GONE);
        }else {
            txtdapanb.setText(valuse.get(0).getB());
        }if(valuse.get(0).getC().isEmpty()){
            txtdapanc.setVisibility(View.GONE);
        }else {
            txtdapanc.setText(valuse.get(0).getC());
        }if(valuse.get(0).getD().isEmpty()){
            txtdapand.setVisibility(View.GONE);
        }else {
            txtdapand.setText(valuse.get(0).getD());
        }

        txtdapana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cauhoinguoidungchon = "a";
                checkDA(valuse,currentQuestionPosition,cauhoinguoidungchon);
                txtdapana.setBackgroundResource(R.drawable.background_button);
                txtdapanb.setBackgroundResource(R.drawable.background_khonghienthi);
                txtdapanc.setBackgroundResource(R.drawable.background_khonghienthi);
                txtdapand.setBackgroundResource(R.drawable.background_khonghienthi);
                checkTD(currentQuestionPosition,td,j,valuse,values1,i);
            }
        });

        txtdapanb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cauhoinguoidungchon = "b";
                checkDA(valuse,currentQuestionPosition,cauhoinguoidungchon);
                txtdapanb.setBackgroundResource(R.drawable.background_button);
                txtdapanc.setBackgroundResource(R.drawable.background_khonghienthi);
                txtdapana.setBackgroundResource(R.drawable.background_khonghienthi);
                txtdapand.setBackgroundResource(R.drawable.background_khonghienthi);
                checkTD(currentQuestionPosition,td,j,valuse,values1,i);
            }
        });

        txtdapanc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cauhoinguoidungchon = "c";
                checkDA(valuse,currentQuestionPosition,cauhoinguoidungchon);
                txtdapanc.setBackgroundResource(R.drawable.background_button);
                txtdapana.setBackgroundResource(R.drawable.background_khonghienthi);
                txtdapanb.setBackgroundResource(R.drawable.background_khonghienthi);
                txtdapand.setBackgroundResource(R.drawable.background_khonghienthi);
                checkTD(currentQuestionPosition,td,j,valuse,values1,i);
            }
        });

        txtdapand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cauhoinguoidungchon = "d";
                checkDA(valuse,currentQuestionPosition,cauhoinguoidungchon);
                txtdapand.setBackgroundResource(R.drawable.background_button);
                txtdapana.setBackgroundResource(R.drawable.background_khonghienthi);
                txtdapanb.setBackgroundResource(R.drawable.background_khonghienthi);
                txtdapanc.setBackgroundResource(R.drawable.background_khonghienthi);
                checkTD(currentQuestionPosition,td,j,valuse,values1,i);
            }
        });
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(currentQuestionPosition == 0){
                    Toast.makeText(OnTapLyThuyetActivity.this, "Câu đầu tiên", Toast.LENGTH_SHORT).show();
                }else {
                    currentQuestionPosition -= 1;
                    trolai(valuse);
                }
            }

        });

        btnnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(currentQuestionPosition == valuse.size()){
                    Toast.makeText(OnTapLyThuyetActivity.this, "Nộp bài", Toast.LENGTH_SHORT).show();
                }else {
                    currentQuestionPosition += 1;
                    chuyencauhoi(valuse);
                }

            }

        });
    }

    public void checkTD(int j,int td,int i, ArrayList<cauhoi_traloi>values, ArrayList<lythuyet> values1, int a){
        if (values1.get(i).getTiendo().isEmpty()){
            if(values.get(j).getNguoidunglythuet() != "") {
                td += 1;
                updatetd(String.valueOf(td),a);
            }

        }else {
            int td1 = Integer.valueOf(values1.get(i).getTiendo());
            if(values.get(j).getNguoidunglythuet() != ""){
                td = td1 + 1;
                updatetd(String.valueOf(td),a);
            }
        }
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
        toobar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    public void chuyencauhoi(ArrayList<cauhoi_traloi> valuse) {
        if(currentQuestionPosition < valuse.size()) {
            cauhoinguoidungchon = "";

            txtdapana.setVisibility(View.VISIBLE);
            txtdapanb.setVisibility(View.VISIBLE);
            txtdapanc.setVisibility(View.VISIBLE);
            txtdapand.setVisibility(View.VISIBLE);
            imghinhanh.setVisibility(View.VISIBLE);

            txtdapana.setBackgroundResource(R.drawable.backgroung_cautraloi);
            txtdapanb.setBackgroundResource(R.drawable.backgroung_cautraloi);
            txtdapanc.setBackgroundResource(R.drawable.backgroung_cautraloi);
            txtdapand.setBackgroundResource(R.drawable.backgroung_cautraloi);
//            if(valuse.get(currentQuestionPosition).getNguoidunglythuet().equals("a"))
//                txtdapana.setBackgroundResource(R.drawable.background_button);
//            else if(valuse.get(currentQuestionPosition).getNguoidunglythuet().equals("b"))
//                txtdapanb.setBackgroundResource(R.drawable.background_button);
//            else if(valuse.get(currentQuestionPosition).getNguoidunglythuet().equals("c"))
//                txtdapanc.setBackgroundResource(R.drawable.background_button);
//            else if(valuse.get(currentQuestionPosition).getNguoidunglythuet().equals("d"))
//                txtdapand.setBackgroundResource(R.drawable.background_button);


            txtcau.setText(currentQuestionPosition + 1 + "/" + valuse.size());
            txtnoidung.setText(valuse.get(currentQuestionPosition).getNoidungcauhoi());

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

            txtdapana.setVisibility(View.VISIBLE);
            txtdapanb.setVisibility(View.VISIBLE);
            txtdapanc.setVisibility(View.VISIBLE);
            txtdapand.setVisibility(View.VISIBLE);
            imghinhanh.setVisibility(View.VISIBLE);

            txtdapana.setBackgroundResource(R.drawable.backgroung_cautraloi);
            txtdapanb.setBackgroundResource(R.drawable.backgroung_cautraloi);
            txtdapanc.setBackgroundResource(R.drawable.backgroung_cautraloi);
            txtdapand.setBackgroundResource(R.drawable.backgroung_cautraloi);
//            if(valuse.get(currentQuestionPosition).getNguoidunglythuet().equals("a"))
//                txtdapana.setBackgroundResource(R.drawable.background_button);
//            else if(valuse.get(currentQuestionPosition).getNguoidunglythuet().equals("b"))
//                txtdapanb.setBackgroundResource(R.drawable.background_button);
//            else if(valuse.get(currentQuestionPosition).getNguoidunglythuet().equals("c"))
//                txtdapanc.setBackgroundResource(R.drawable.background_button);
//            else if(valuse.get(currentQuestionPosition).getNguoidunglythuet().equals("d"))
//                txtdapand.setBackgroundResource(R.drawable.background_button);
            int cau = currentQuestionPosition + 1;
            txtcau.setText(cau + "/" + valuse.size());
            txtnoidung.setText(valuse.get(currentQuestionPosition).getNoidungcauhoi());

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
package com.example.appthibanglaixe.Activity;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.Toolbar;

import com.example.appthibanglaixe.data.DbContract;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.example.appthibanglaixe.Adapter.Cauhoi_traloiAdapter;
import com.example.appthibanglaixe.R;
import com.example.appthibanglaixe.data.sqDuLieu;
import com.example.appthibanglaixe.entity.modify;
import com.example.appthibanglaixe.model.bode;
import com.example.appthibanglaixe.model.cauhoi_traloi;
import com.example.appthibanglaixe.uliti.Server;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class SatHoachActivity extends AppCompatActivity {
    // khai báo
    private modify dbname;
    ListView lsstcauhoi;
    private Activity activity;
    int id = 0;
    // khai báo giao diện
    TextView txtcau;
    sqDuLieu dulieu;
    ImageView imganh;
    TextView noidungcauhoi;
    AppCompatButton dapan1, dapan2, dapan3, dapan4;
    Timer thoigian;
    int totalTimeMin = 1;
    int seconds = 0;
    Button btnnext, btnback, btnNopBai;
    private String cauhoinguoidungchon = "";
    Toolbar toobarkiemtra;
    String kq="0";
    int diemthi=0;
    private int currentQuestionPosition = 0 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sat_hoach);
        Anhxa();
        final TextView timer = findViewById(R.id.ftt_txt_time);
        Xulithoigian(timer);
        XuliToolbar();
        dulieu = new sqDuLieu(this);
        int i = laydulieu();
        ArrayList<cauhoi_traloi> valuse = dulieu.getAllPeople(i);
        ArrayList<bode> valuseBD = dulieu.getDuLieuBoDe();
        noidungcauhoi.setText(valuse.get(0).getNoidungcauhoi());
        if(valuse.get(0).getA().isEmpty()){
            dapan1.setVisibility(View.GONE);
        }else {
            dapan1.setText(valuse.get(0).getA());
            if(valuse.get(0).getCauNDChon().equals("a"))
                dapan1.setBackgroundResource(R.drawable.background_button);
        }
        if(valuse.get(0).getB().isEmpty()){
            dapan2.setVisibility(View.GONE);
        }else {
            dapan2.setText(valuse.get(0).getB());
            if(valuse.get(0).getCauNDChon().equals("b"))
                dapan2.setBackgroundResource(R.drawable.background_button);
        }
        if(valuse.get(0).getC().isEmpty()){
            dapan3.setVisibility(View.GONE);
        }else {
            dapan3.setText(valuse.get(0).getC());
            if(valuse.get(0).getCauNDChon().equals("c"))
                dapan3.setBackgroundResource(R.drawable.background_button);
        }
        if(valuse.get(0).getD().isEmpty()){
            dapan4.setVisibility(View.GONE);
        }else {
            dapan4.setText(valuse.get(0).getD());
            if(valuse.get(0).getCauNDChon().equals("d"))
                dapan4.setBackgroundResource(R.drawable.background_button);
        }
        if(valuse.get(0).getHinhcauhoi().isEmpty()){
            imganh.setVisibility(View.GONE);
        }else {
            Glide.with(getApplicationContext()).load(valuse.get(0).getHinhcauhoi()).error(R.drawable.icon).into(imganh);
        }
        dapan1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cauhoinguoidungchon = "a";
                checkDA(valuse,currentQuestionPosition,cauhoinguoidungchon);
                dapan1.setBackgroundResource(R.drawable.background_button);
                dapan2.setBackgroundResource(R.drawable.backgroung_cautraloi);
                dapan3.setBackgroundResource(R.drawable.backgroung_cautraloi);
                dapan4.setBackgroundResource(R.drawable.backgroung_cautraloi);
                diemthi = checkDiem(valuse,currentQuestionPosition);
                if(checkDLiet(valuse,i) == 0){
                    if (diemthi > 20){
                        kq = "THI DAU";
                    }else kq = "THI TRUOT\n (diem thi nho hon 21)";
                }
                int dl = checkDLiet(valuse, i);
                if(valuse.get(dl).getCaudung().equals(valuse.get(dl).getCauNDChon()));
                else kq = "THI TRUOT\n(sai cau diem liet)";

                updateBD(String.valueOf(diemthi),kq,i);

                dapan1.setEnabled(false);
                dapan2.setEnabled(true);
                dapan3.setEnabled(true);
                dapan4.setEnabled(true);
            }
        });
        dapan2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cauhoinguoidungchon = "b";
                checkDA(valuse,currentQuestionPosition,cauhoinguoidungchon);
                dapan2.setBackgroundResource(R.drawable.background_button);
                dapan1.setBackgroundResource(R.drawable.backgroung_cautraloi);
                dapan3.setBackgroundResource(R.drawable.backgroung_cautraloi);
                dapan4.setBackgroundResource(R.drawable.backgroung_cautraloi);
                diemthi = checkDiem(valuse,currentQuestionPosition);
                if(checkDLiet(valuse,i) == 0){
                    if (diemthi > 20){
                        kq = "THI DAU";
                    }else kq = "THI TRUOT\n (diem thi nho hon 21)";
                }
                int dl = checkDLiet(valuse, i);
                if(valuse.get(dl).getCaudung().equals(valuse.get(dl).getCauNDChon()));
                else kq = "THI TRUOT\n(sai cau diem liet)";

                updateBD(String.valueOf(diemthi),kq,i);

                dapan1.setEnabled(true);
                dapan2.setEnabled(false);
                dapan3.setEnabled(true);
                dapan4.setEnabled(true);
            }
        });
        dapan3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cauhoinguoidungchon = "c";
                checkDA(valuse,currentQuestionPosition,cauhoinguoidungchon);
                dapan3.setBackgroundResource(R.drawable.background_button);
                dapan1.setBackgroundResource(R.drawable.backgroung_cautraloi);
                dapan2.setBackgroundResource(R.drawable.backgroung_cautraloi);
                dapan4.setBackgroundResource(R.drawable.backgroung_cautraloi);
                diemthi = checkDiem(valuse,currentQuestionPosition);
                if(checkDLiet(valuse,i) == 0){
                    if (diemthi > 20){
                        kq = "THI DAU";
                    }else kq = "THI TRUOT\n(diem thi nho hon 21)";
                }
                int dl = checkDLiet(valuse, i);
                if(valuse.get(dl).getCaudung().equals(valuse.get(dl).getCauNDChon()));
                else kq = "THI TRUOT\n(sai cau diem liet)";

                updateBD(String.valueOf(diemthi),kq,i);

                dapan3.setEnabled(false);
                dapan1.setEnabled(true);
                dapan2.setEnabled(true);
                dapan4.setEnabled(true);
            }
        });
        dapan4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cauhoinguoidungchon = "d";
                checkDA(valuse,currentQuestionPosition,cauhoinguoidungchon);
                dapan4.setBackgroundResource(R.drawable.background_button);
                dapan1.setBackgroundResource(R.drawable.backgroung_cautraloi);
                dapan2.setBackgroundResource(R.drawable.backgroung_cautraloi);
                dapan3.setBackgroundResource(R.drawable.backgroung_cautraloi);
                diemthi = checkDiem(valuse,currentQuestionPosition);
                if(checkDLiet(valuse,i) == 0){
                    if (diemthi > 20){
                        kq = "THI DAU";
                    }else kq = "THI TRUOT\n(diem thi nho hon 21)";
                }
                int dl = checkDLiet(valuse, i);
                if(valuse.get(dl).getCaudung().equals(valuse.get(dl).getCauNDChon()));
                else kq = "THI TRUOT\n(sai cau diem liet)";


                updateBD(String.valueOf(diemthi),kq,i);

                dapan4.setEnabled(false);
                dapan1.setEnabled(true);
                dapan2.setEnabled(true);
                dapan3.setEnabled(true);
            }
        });
        btnnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(currentQuestionPosition  == valuse.size()-1){
                    Toast.makeText(SatHoachActivity.this, "Nộp bài bạn ơi!!! ", Toast.LENGTH_SHORT).show();
                }else
                    currentQuestionPosition+=1;
                chuyencauhoi(valuse);
            }
        });
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(currentQuestionPosition == 0) {
                    Toast.makeText(SatHoachActivity.this, "Câu đầu tiên ", Toast.LENGTH_SHORT).show();
                }
                else{
                    currentQuestionPosition-=1;
                    trolai(valuse);
                }
            }
        });
        btnNopBai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendata(i);
            }
        });

    }
    private void sendata(int i) {
        Intent intent = new Intent(SatHoachActivity.this, KetQuaThiActivity.class);
        intent.putExtra("bode",i);
        startActivity(intent);
    }
    public void chuyencauhoi(ArrayList<cauhoi_traloi> valuse) {
        if(currentQuestionPosition < valuse.size()) {
            cauhoinguoidungchon = "";
            dapan1.setVisibility(View.VISIBLE);
            dapan2.setVisibility(View.VISIBLE);
            dapan3.setVisibility(View.VISIBLE);
            dapan4.setVisibility(View.VISIBLE);
            imganh.setVisibility(View.VISIBLE);
            dapan1.setEnabled(true);
            dapan2.setEnabled(true);
            dapan3.setEnabled(true);
            dapan4.setEnabled(true);

            dapan1.setBackgroundResource(R.drawable.backgroung_cautraloi);
            dapan2.setBackgroundResource(R.drawable.backgroung_cautraloi);
            dapan3.setBackgroundResource(R.drawable.backgroung_cautraloi);
            dapan4.setBackgroundResource(R.drawable.backgroung_cautraloi);
            if(valuse.get(currentQuestionPosition).getCauNDChon().equals("a"))
                dapan1.setBackgroundResource(R.drawable.background_button);
            else if(valuse.get(currentQuestionPosition).getCauNDChon().equals("b"))
                dapan2.setBackgroundResource(R.drawable.background_button);
            else if(valuse.get(currentQuestionPosition).getCauNDChon().equals("c"))
                dapan3.setBackgroundResource(R.drawable.background_button);
            else if(valuse.get(currentQuestionPosition).getCauNDChon().equals("d"))
                dapan4.setBackgroundResource(R.drawable.background_button);


            txtcau.setText(currentQuestionPosition + 1 + "/" + valuse.size());
            noidungcauhoi.setText(valuse.get(currentQuestionPosition).getNoidungcauhoi());

            if (valuse.get(currentQuestionPosition).getA().isEmpty()) {
                dapan1.setVisibility(View.GONE);
            } else {
                dapan1.setText(valuse.get(currentQuestionPosition).getA());
            }
            if (valuse.get(currentQuestionPosition).getB().isEmpty()) {
                dapan2.setVisibility(View.GONE);
            } else {
                dapan2.setText(valuse.get(currentQuestionPosition).getB());
            }
            if (valuse.get(currentQuestionPosition).getC().isEmpty()) {
                dapan3.setVisibility(View.GONE);
            } else {
                dapan3.setText(valuse.get(currentQuestionPosition).getC());
            }
            if (valuse.get(currentQuestionPosition).getD().isEmpty()) {
                dapan4.setVisibility(View.GONE);
            } else {
                dapan4.setText(valuse.get(currentQuestionPosition).getD());
            }
            if(valuse.get(currentQuestionPosition).getHinhcauhoi().isEmpty()){
                imganh.setVisibility(View.GONE);
            }else {
                Glide.with(getApplicationContext()).load(valuse.get(currentQuestionPosition).getHinhcauhoi()).error(R.drawable.icon).into(imganh);
            }
        }
    }
    public void trolai(ArrayList<cauhoi_traloi> valuse){
        if(currentQuestionPosition == valuse.size()-1)
            currentQuestionPosition-=1;
        if(currentQuestionPosition > -1 && currentQuestionPosition < valuse.size()) {
            cauhoinguoidungchon = "";
            dapan1.setVisibility(View.VISIBLE);
            dapan2.setVisibility(View.VISIBLE);
            dapan3.setVisibility(View.VISIBLE);
            dapan4.setVisibility(View.VISIBLE);
            imganh.setVisibility(View.VISIBLE);

            dapan1.setEnabled(true);
            dapan2.setEnabled(true);
            dapan3.setEnabled(true);
            dapan4.setEnabled(true);

            dapan1.setBackgroundResource(R.drawable.backgroung_cautraloi);
            dapan2.setBackgroundResource(R.drawable.backgroung_cautraloi);
            dapan3.setBackgroundResource(R.drawable.backgroung_cautraloi);
            dapan4.setBackgroundResource(R.drawable.backgroung_cautraloi);
            if(valuse.get(currentQuestionPosition).getCauNDChon().equals("a"))
                dapan1.setBackgroundResource(R.drawable.background_button);
            else if(valuse.get(currentQuestionPosition).getCauNDChon().equals("b"))
                dapan2.setBackgroundResource(R.drawable.background_button);
            else if(valuse.get(currentQuestionPosition).getCauNDChon().equals("c"))
                dapan3.setBackgroundResource(R.drawable.background_button);
            else if(valuse.get(currentQuestionPosition).getCauNDChon().equals("d"))
                dapan4.setBackgroundResource(R.drawable.background_button);
            int cau =currentQuestionPosition + 1;
            txtcau.setText(cau + "/" + valuse.size());
            noidungcauhoi.setText(valuse.get(currentQuestionPosition).getNoidungcauhoi());

            if (valuse.get(currentQuestionPosition).getA().isEmpty()) {
                dapan1.setVisibility(View.GONE);
            } else {
                dapan1.setText(valuse.get(currentQuestionPosition).getA());
            }
            if (valuse.get(currentQuestionPosition).getB().isEmpty()) {
                dapan2.setVisibility(View.GONE);
            } else {
                dapan2.setText(valuse.get(currentQuestionPosition).getB());
            }
            if (valuse.get(currentQuestionPosition).getC().isEmpty()) {
                dapan3.setVisibility(View.GONE);
            } else {
                dapan3.setText(valuse.get(currentQuestionPosition).getC());
            }
            if (valuse.get(currentQuestionPosition).getD().isEmpty()) {
                dapan4.setVisibility(View.GONE);
            } else {
                dapan4.setText(valuse.get(currentQuestionPosition).getD());
            }
            if (valuse.get(currentQuestionPosition).getHinhcauhoi().isEmpty()) {
                imganh.setVisibility(View.GONE);
            } else {
                Glide.with(getApplicationContext()).load(valuse.get(currentQuestionPosition).getHinhcauhoi()).error(R.drawable.icon).into(imganh);
            }
        }
    }
    public void checkDA(ArrayList<cauhoi_traloi> valuse,int i,String cauhoinguoidungchon1){
        update(valuse,cauhoinguoidungchon1,i);
    }
    private int checkDiem(ArrayList<cauhoi_traloi> valuse,int i){
        if(valuse.get(i).getCaudung().equals(valuse.get(i).getCauNDChon())){
            diemthi+=1;
        }
        return diemthi;
    }
    private int checkDLiet(ArrayList<cauhoi_traloi> valuse,int i){
        if(valuse.get(i).getCauliet().equals("1")){
            if(valuse.get(i).getCaudung().equals(valuse.get(i).getCauNDChon()))
                return 0;
            else
                return i;
        }
        return 0;
    }
    private void update(ArrayList<cauhoi_traloi> valuse, String cauNDC,int i){
        ContentValues val = new ContentValues();
        val.put("CauNDChon",cauNDC);
        dulieu.Update(DbContract.MenuEntry.TABLE_NAME,val, " _id = "+valuse.get(i).getID(),null);

    }
    private  void updateBD(String socau, String kq ,int i){
        ContentValues val = new ContentValues();
        val.put("diem", socau);
        val.put("ketqua",kq);
        dulieu.Update(DbContract.BoDe.TABLE_NAMEBODE, val, "bodeso = " +i,null);
    }
    private int laydulieu() {
        Intent intent = getIntent();
        int i = (int) intent.getSerializableExtra("data");
        return i;
    }

    private void Xulithoigian(TextView timer) {
        thoigian = new Timer();
        thoigian.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if(seconds == 0){
                    totalTimeMin--;
                    seconds = 59;

                }else if(seconds == 0 && totalTimeMin == 0){
                    thoigian.purge();
                    thoigian.cancel();
                }else {
                    seconds --;
                    if(seconds == 0){
                        thoigian.cancel();
                    }
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        String finalminutes = String.valueOf(totalTimeMin);
                        String finalSeconds = String.valueOf(seconds);

                        if(finalminutes.length() == 1){
                            finalminutes = "0" + finalminutes;
                        }
                        if(finalSeconds.length() == 1){
                            finalSeconds = "0" + finalSeconds;
                        }
                        timer.setText(finalminutes+ ":" + finalSeconds);
                    }
                });
            }
        }, 1000, 1000);
    }

    private void XuliToolbar() {
        setSupportActionBar(toobarkiemtra);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toobarkiemtra.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void Anhxa() {
        noidungcauhoi = findViewById(R.id.ftt_txt_noidungcauhoi);
        dapan1 =  findViewById(R.id.ftt_txt_cautraloi1);
        dapan2 = findViewById(R.id.ftt_txt_cautraloi2);
        dapan3 = findViewById(R.id.ftt_txt_cautraloi3);
        dapan4 = findViewById(R.id.ftt_txt_cautraloi4);
        imganh = findViewById(R.id.ftt_imganhcauhoi);
        btnback = findViewById(R.id.ash_btnback);
        btnnext = findViewById(R.id.ash_btnnext);
        txtcau = findViewById(R.id.ash_txtcau);
        btnNopBai = findViewById(R.id.btnNopBai);
        toobarkiemtra = findViewById(R.id.ftp_toobar_kiemtra);
    }

}
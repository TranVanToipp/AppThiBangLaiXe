package com.example.appthibanglaixe.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
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
    sqDuLieu dulieu;
    ImageView imganh;
    TextView socauhoi;
    TextView noidungcauhoi;
    AppCompatButton dapan1, dapan2, dapan3, dapan4, chuyencau;
    Timer thoigian;
    int totalTimeMin = 1;
    int seconds = 0;
    private String cauhoinguoidungchon = "";
//    private ArrayList<cauhoi_traloi> arrayListcauhoi = new ArrayList<>();
    private int currentQuestionPosition = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sat_hoach);
        Anhxa();

//        ChuyenCauhoi();
        // kích hoạt database
        sqDuLieu.getInstance(this);
        final TextView timer = findViewById(R.id.ftt_txt_time);
        Xulithoigian(timer);
        dulieu = new sqDuLieu(this);
        ArrayList<cauhoi_traloi> valuse = dulieu.getAllPeople(2);
//        Cauhoi_traloiAdapter cauhoiTraloiAdapter = new Cauhoi_traloiAdapter(this,va);
        noidungcauhoi.setText(valuse.get(0).getNoidungcauhoi());
        if(valuse.get(0).getA().isEmpty()){
            dapan1.setVisibility(View.GONE);
        }else {
            dapan1.setText(valuse.get(0).getA());
        }
        if(valuse.get(0).getB().isEmpty()){
            dapan2.setVisibility(View.GONE);
        }else {
            dapan2.setText(valuse.get(0).getB());
        }
        if(valuse.get(0).getC().isEmpty()){
            dapan3.setVisibility(View.GONE);
        }else {
            dapan3.setText(valuse.get(0).getC());
        }
        if(valuse.get(0).getD().isEmpty()){
            dapan4.setVisibility(View.GONE);
        }else {
            dapan4.setText(valuse.get(0).getD());
        }
        chuyencau.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cauhoinguoidungchon.isEmpty()){
                    Chuyencauhoi();

//                    Toast.makeText(getActivity(), "Bạn chưa chọn câu hỏi!!!", Toast.LENGTH_SHORT).show();
                }else {
                    Chuyencauhoi();
                }
            }

            private void Chuyencauhoi() {
                currentQuestionPosition++;
                if(currentQuestionPosition+1 == valuse.size()){
                    Toast.makeText(SatHoachActivity.this, "Nộp bài bạn ơi!!!", Toast.LENGTH_SHORT).show();
                }
                if(currentQuestionPosition < valuse.size()) {
                    cauhoinguoidungchon = "";

                    dapan1.setVisibility(View.VISIBLE);
                    dapan2.setVisibility(View.VISIBLE);
                    dapan3.setVisibility(View.VISIBLE);
                    dapan4.setVisibility(View.VISIBLE);

                    socauhoi.setText(currentQuestionPosition + 1 + "/" + valuse.size());
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
                        Glide.with(activity).load(valuse.get(currentQuestionPosition).getHinhcauhoi()).error(R.drawable.icon).into(imganh);
                    }
                }
            }
        });
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
                        String finalminutes = String .valueOf(totalTimeMin);
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


    private void Anhxa() {

        socauhoi = findViewById(R.id.ftt_txt_socauhoi);
        noidungcauhoi = findViewById(R.id.ftt_txt_noidungcauhoi);
        dapan1 =  findViewById(R.id.ftt_txt_cautraloi1);
        dapan2 = findViewById(R.id.ftt_txt_cautraloi2);
        dapan3 = findViewById(R.id.ftt_txt_cautraloi3);
        dapan4 = findViewById(R.id.ftt_txt_cautraloi4);
        imganh = findViewById(R.id.ftt_imganhcauhoi);

        chuyencau = findViewById(R.id.ftt_btn_chuyencau);
//        toobarkiemtra = view.findViewById(R.id.ftt_toobar_kiemtra);
    }
}
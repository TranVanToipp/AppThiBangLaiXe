package com.example.appthibanglaixe.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

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
import com.example.appthibanglaixe.R;
import com.example.appthibanglaixe.data.sqDuLieu;
import com.example.appthibanglaixe.entity.modify;
import com.example.appthibanglaixe.model.cauhoi_traloi;
import com.example.appthibanglaixe.uliti.Server;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class SatHoachActivity extends AppCompatActivity {
    // khai báo
    ListView lsstcauhoi;
    int id = 0;
    // khai báo giao diện
    ImageView imganh;
    TextView socauhoi;
    TextView noidungcauhoi;
    AppCompatButton dapan1, dapan2, dapan3, dapan4, chuyencau;
    Timer thoigian;
    int totalTimeMin = 1;
    int seconds = 0;
    private String cauhoinguoidungchon = "";
    private ArrayList<cauhoi_traloi> arrayListcauhoi = new ArrayList<>();
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

        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Server.Duongdancauhoi_dapan, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                if(response != null){
                    int cau = 0;
                    String ndcauhoi = "";
                    String hcauhoi = "";
                    String a = "";
                    String b = "";
                    String c = "";
                    String d = "";
                    String cdung = "";
                    String cdiemliet = "";
                    String loaicauhoi = "";
                    for(int i = 0; i < response.length(); i++){
                        try {
                            JSONObject jsonObject = response.getJSONObject(i);
                            cau = jsonObject.getInt("cau");
                            ndcauhoi = jsonObject.getString("noidungcauhoi");
                            hcauhoi = jsonObject.getString("hinhcauhoi");
                            a = jsonObject.getString("a");
                            b = jsonObject.getString("b");
                            c = jsonObject.getString("c");
                            d = jsonObject.getString("d");
                            cdung = jsonObject.getString("caudung");
                            cdiemliet = jsonObject.getString("caudiemliet");
                            loaicauhoi = jsonObject.getString("loaicauhoi");
                            cauhoi_traloi ch = new cauhoi_traloi(cau,ndcauhoi,hcauhoi,a,b,c,d,cdung,cdiemliet,loaicauhoi);
                            modify.insert(ch);
                            arrayListcauhoi.add(ch);
//                            Cursor cursor = modify.finAll();
//                            arrayListcauhoi.add((cauhoi_traloi) cursor);


                        }catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                    Log.d("cauhoi", arrayListcauhoi.get(0).getNoidungcauhoi());
                    noidungcauhoi.setText(arrayListcauhoi.get(0).getNoidungcauhoi());
                    if(arrayListcauhoi.get(0).getA().isEmpty()){
                        dapan1.setVisibility(View.GONE);
                    }else {
                        dapan1.setText(arrayListcauhoi.get(0).getA());
                    }
                    if(arrayListcauhoi.get(0).getB().isEmpty()){
                        dapan2.setVisibility(View.GONE);
                    }else {
                        dapan2.setText(arrayListcauhoi.get(0).getB());
                    }
                    if(arrayListcauhoi.get(0).getC().isEmpty()){
                        dapan3.setVisibility(View.GONE);
                    }else {
                        dapan3.setText(arrayListcauhoi.get(0).getC());
                    }
                    if(arrayListcauhoi.get(0).getD().isEmpty()){
                        dapan4.setVisibility(View.GONE);
                    }else {
                        dapan4.setText(arrayListcauhoi.get(0).getD());
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(jsonArrayRequest);

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
                if(currentQuestionPosition+1 == arrayListcauhoi.size()){
                    Toast.makeText(SatHoachActivity.this, "Nộp bài bạn ơi!!!", Toast.LENGTH_SHORT).show();
                }
                if(currentQuestionPosition < arrayListcauhoi.size()) {
                    cauhoinguoidungchon = "";

                    dapan1.setVisibility(View.VISIBLE);
                    dapan2.setVisibility(View.VISIBLE);
                    dapan3.setVisibility(View.VISIBLE);
                    dapan4.setVisibility(View.VISIBLE);

                    socauhoi.setText(currentQuestionPosition + 1 + "/" + arrayListcauhoi.size());
                    noidungcauhoi.setText(arrayListcauhoi.get(currentQuestionPosition).getNoidungcauhoi());

                    if (arrayListcauhoi.get(currentQuestionPosition).getA().isEmpty()) {
                        dapan1.setVisibility(View.GONE);
                    } else {
                        dapan1.setText(arrayListcauhoi.get(currentQuestionPosition).getA());
                    }
                    if (arrayListcauhoi.get(currentQuestionPosition).getB().isEmpty()) {
                        dapan2.setVisibility(View.GONE);
                    } else {
                        dapan2.setText(arrayListcauhoi.get(currentQuestionPosition).getB());
                    }
                    if (arrayListcauhoi.get(currentQuestionPosition).getC().isEmpty()) {
                        dapan3.setVisibility(View.GONE);
                    } else {
                        dapan3.setText(arrayListcauhoi.get(currentQuestionPosition).getC());
                    }
                    if (arrayListcauhoi.get(currentQuestionPosition).getD().isEmpty()) {
                        dapan4.setVisibility(View.GONE);
                    } else {
                        dapan4.setText(arrayListcauhoi.get(currentQuestionPosition).getD());
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
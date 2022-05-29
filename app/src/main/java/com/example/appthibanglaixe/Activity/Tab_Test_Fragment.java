package com.example.appthibanglaixe.Activity;

import android.app.Activity;
import android.app.DownloadManager;
import android.app.VoiceInteractor;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.appthibanglaixe.Adapter.Cauhoi_traloiAdapter;
import com.example.appthibanglaixe.R;
import com.example.appthibanglaixe.model.cauhoi_traloi;
import com.example.appthibanglaixe.uliti.Server;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Tab_Test_Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Tab_Test_Fragment extends Fragment {
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
    private ArrayList<cauhoi_traloi> arrayListcauhoi = new ArrayList<>();
    private int currentQuestionPosition = 0;

//câu hỏi bắt đầu
    //private int currentQuestionPosition = 0;

    private String cauhoinguoidungchon = "";

    //lấy vị trí trang hiện tại
    private int mpage = 1;
    Toolbar toobarkiemtra;
    // Khai báo toobar
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Tab_Test_Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Tab_Test_Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Tab_Test_Fragment newInstance(String param1, String param2) {
        Tab_Test_Fragment fragment = new Tab_Test_Fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tab__test_,container,false);
        //Anhxa();
        final TextView timer = view.findViewById(R.id.ftt_txt_time);
        socauhoi = view.findViewById(R.id.ftt_txt_socauhoi);
        noidungcauhoi = view.findViewById(R.id.ftt_txt_noidungcauhoi);
        dapan1 =  view.findViewById(R.id.ftt_txt_cautraloi1);
        dapan2 = view.findViewById(R.id.ftt_txt_cautraloi2);
        dapan3 = view.findViewById(R.id.ftt_txt_cautraloi3);
        dapan4 = view.findViewById(R.id.ftt_txt_cautraloi4);
        imganh = view.findViewById(R.id.ftt_imganhcauhoi);

        chuyencau = view.findViewById(R.id.ftt_btn_chuyencau);
        toobarkiemtra = view.findViewById(R.id.ftt_toobar_kiemtra);
                //Getdulieucauhoi_traloi();
        Xulithoigian(timer);
        RequestQueue requestQueue = Volley.newRequestQueue(getActivity().getApplicationContext());
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
                            cauhoi_traloi ch = new cauhoi_traloi(cau,ndcauhoi,hcauhoi,a,b,c,d,cdung,cdiemliet);
                            arrayListcauhoi.add(ch);

                        }catch (Exception e){
                            e.printStackTrace();
                        }
                    }
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
                Toast.makeText(getActivity(), "Nộp bài", Toast.LENGTH_SHORT).show();
                }
            if(currentQuestionPosition < arrayListcauhoi.size()){
                cauhoinguoidungchon = "";

                dapan1.setVisibility(View.VISIBLE);
                dapan2.setVisibility(View.VISIBLE);
                dapan3.setVisibility(View.VISIBLE);
                dapan4.setVisibility(View.VISIBLE);

                socauhoi.setText(currentQuestionPosition+1 + "/" + arrayListcauhoi.size());
                noidungcauhoi.setText(arrayListcauhoi.get(currentQuestionPosition).getNoidungcauhoi());

                if(arrayListcauhoi.get(currentQuestionPosition).getA().isEmpty()){
                    dapan1.setVisibility(View.GONE);
                }
                else {
                    dapan1.setText(arrayListcauhoi.get(currentQuestionPosition).getA());
                }
                if(arrayListcauhoi.get(currentQuestionPosition).getB().isEmpty()){
                    dapan2.setVisibility(View.GONE);
                }
                else {
                    dapan2.setText(arrayListcauhoi.get(currentQuestionPosition).getB());
                }
                if(arrayListcauhoi.get(currentQuestionPosition).getC().isEmpty()){
                    dapan3.setVisibility(View.GONE);
                }
                else {
                    dapan3.setText(arrayListcauhoi.get(currentQuestionPosition).getC());
                }
                if (arrayListcauhoi.get(currentQuestionPosition).getD().isEmpty()){
                    dapan4.setVisibility(View.GONE);
                }
                else {
                    dapan4.setText(arrayListcauhoi.get(currentQuestionPosition).getD());
                    }
                }
            }
        });
        return view;
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
                getActivity().runOnUiThread(new Runnable() {
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

    private void XuliToobar() {
        AppCompatActivity activity = (AppCompatActivity) getActivity();

        ((AppCompatActivity)getActivity()).setSupportActionBar(toobarkiemtra);

        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toobarkiemtra.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.finish();
            }
        });
    }

    public void Getdulieucauhoi_traloi() {
        ArrayList<cauhoi_traloi> listch = new ArrayList<>();
        RequestQueue requestQueue = Volley.newRequestQueue(getActivity().getApplicationContext());
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
                                cauhoi_traloi ch = new cauhoi_traloi(cau,ndcauhoi,hcauhoi,a,b,c,d,cdung,cdiemliet);
                                arrayListcauhoi.add(ch);

                            }catch (Exception e){
                                e.printStackTrace();
                            }
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(jsonArrayRequest);
    }
}
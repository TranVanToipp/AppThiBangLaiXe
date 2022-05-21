package com.example.appthibanglaixe.Activity;

import android.app.DownloadManager;
import android.app.VoiceInteractor;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
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

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Tab_Test_Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Tab_Test_Fragment extends Fragment {
    // khai báo
    ArrayList<cauhoi_traloi> mangcauhoi;
    Cauhoi_traloiAdapter cauhoiTraloiAdapter;
    int page = 1;

    int id = 0;


//câu hỏi bắt đầu
    private int currentQuestionPosition = 0;

    private String cauhoinguoidungchon = "";
    ListView lstchoi;

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


        mangcauhoi = new ArrayList<>();
        cauhoiTraloiAdapter = new Cauhoi_traloiAdapter(getActivity(),mangcauhoi);



          //  lstchoi.setAdapter(cauhoiTraloiAdapter);



        toobarkiemtra = view.findViewById(R.id.ftt_toobar_kiemtra);

            Getdulieucauhoi_traloi(page);

        return inflater.inflate(R.layout.fragment_tab__test_, container, false);
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

    private void Getdulieucauhoi_traloi(int Page) {
        RequestQueue requestQueue = Volley.newRequestQueue(getActivity().getApplicationContext());
        String Duongdan = Server.Duongdancauhoi_dapan + String.valueOf(Page);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, Duongdan, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                int cau = 0;
                String ndcauhoi = "";
                String hcauhoi = "";
                String a = "";
                String b = "";
                String c = "";
                String d = "";
                String cdung = "";
                String cdiemliet = "";

                if(response != null) {
                    try {
                        JSONArray jsonArray = new JSONArray(response);
                        for(int i = 0; i < jsonArray.length(); i++){
                            JSONObject jsonObject = jsonArray.getJSONObject(i);
                            cau = jsonObject.getInt("cau");
                            ndcauhoi = jsonObject.getString("noidungcauhoi");
                            hcauhoi = jsonObject.getString("hinhcauhoi");
                            a = jsonObject.getString("a");
                            b = jsonObject.getString("b");
                            c = jsonObject.getString("c");
                            d = jsonObject.getString("d");
                            cdung = jsonObject.getString("caudung");
                            cdiemliet = jsonObject.getString("caudiemliet");
                            mangcauhoi.add(new cauhoi_traloi(cau,ndcauhoi,hcauhoi,a,b,c,d,cdung,cdiemliet));
                            cauhoiTraloiAdapter.notifyDataSetChanged();
                        }
                    }catch (JSONException e){
                        e.printStackTrace();
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> para = new HashMap<String, String>();
                para.put("cau",String.valueOf(id));
                return para;
            }
        };
        requestQueue.add(stringRequest);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);

    }
}
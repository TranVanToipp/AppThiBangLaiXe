package com.example.appthibanglaixe.Activity.FragmentBienBao;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.appthibanglaixe.Adapter.BienBaoAdapter;
import com.example.appthibanglaixe.R;
import com.example.appthibanglaixe.model.bienbao;
import com.example.appthibanglaixe.uliti.Server;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BienChiDanFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BienChiDanFragment extends Fragment {
    ListView lstbienbaochidan;
    ArrayList<bienbao> arrayListBienBaoChiDan;
    BienBaoAdapter bienBaoAdapter;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public BienChiDanFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BienChiDanFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BienChiDanFragment newInstance(String param1, String param2) {
        BienChiDanFragment fragment = new BienChiDanFragment();
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
        View view = inflater.inflate(R.layout.fragment_bien_chi_dan, container, false);
        lstbienbaochidan = view.findViewById(R.id.fbc_lst_bienbaochidan);
        XulijsonBienBaoChiDan();
        arrayListBienBaoChiDan = new ArrayList<>();
        bienBaoAdapter = new BienBaoAdapter(getActivity(), arrayListBienBaoChiDan);
        lstbienbaochidan.setAdapter(bienBaoAdapter);
        // Inflate the layout for this fragment
        return view;
    }

    private void XulijsonBienBaoChiDan() {
        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Server.Duongdanbienbao3, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                if(response != null){
                    String hinhanh = "";
                    String noidung = "";
                    for(int i = 0 ;i < response.length(); i++){
                        try {
                            JSONObject jsonObject = response.getJSONObject(i);
                            hinhanh = jsonObject.getString("hinhbienbao");
                            noidung = jsonObject.getString("noidungbienbao");
                            arrayListBienBaoChiDan.add(new bienbao(hinhanh, noidung));
                            bienBaoAdapter.notifyDataSetChanged();
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
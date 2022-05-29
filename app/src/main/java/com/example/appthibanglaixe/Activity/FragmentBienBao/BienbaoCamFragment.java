package com.example.appthibanglaixe.Activity.FragmentBienBao;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
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
 * Use the {@link BienbaoCamFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BienbaoCamFragment extends Fragment {
    ArrayList<bienbao> arraybienbao1;
    ListView lstbienbaocam;
    BienBaoAdapter bienBaoAdapter;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public BienbaoCamFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BienbaoCamFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BienbaoCamFragment newInstance(String param1, String param2) {
        BienbaoCamFragment fragment = new BienbaoCamFragment();
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
        View view = inflater.inflate(R.layout.fragment_bienbao_cam,container, false);

        lstbienbaocam = view.findViewById(R.id.fb_lstbienbaocam);
        Xulijsonbienbao();
        arraybienbao1 = new ArrayList();
        bienBaoAdapter = new BienBaoAdapter(getActivity(),arraybienbao1);
        lstbienbaocam.setAdapter(bienBaoAdapter);
        // Inflate the layout for this fragment
        return view;
    }

    private void Xulijsonbienbao() {
        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Server.Duongdanbienbao1, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                if (response != null) {
                    String hinhbba = "";
                    String noidung = "";

                    for(int i = 0; i< response.length(); i++){
                        try {
                            JSONObject jsonObject = response.getJSONObject(i);
                            //Toast.makeText(BienBaoActivity.this, "hình biển bao"+ jsonObject.getInt("hinhbienbao"), Toast.LENGTH_SHORT).show();
                            hinhbba = jsonObject.getString("hinhbienbao");
                            noidung = jsonObject.getString("noidungbienbao");
//                            Log.d("cauhoi", noidung);
                            arraybienbao1.add(new bienbao(hinhbba, noidung));
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
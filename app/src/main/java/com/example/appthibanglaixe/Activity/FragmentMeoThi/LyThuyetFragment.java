package com.example.appthibanglaixe.Activity.FragmentMeoThi;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.appthibanglaixe.Adapter.MeoThiAdapter;
import com.example.appthibanglaixe.R;
import com.example.appthibanglaixe.model.meothiGroup;
import com.example.appthibanglaixe.model.meothiIterm;
import com.example.appthibanglaixe.uliti.Server;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LyThuyetFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LyThuyetFragment extends Fragment {
    private ExpandableListView expandableListView;
    ArrayList<meothiGroup> mListGroup;
//    ArrayList<meothiIterm> Itermlist;
     Map<meothiGroup, ArrayList<meothiIterm>> mListIterm;
    MeoThiAdapter meothiAdapter;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
//    private Object meothiIterm;

    public LyThuyetFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment LyThuyetFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static LyThuyetFragment newInstance(String param1, String param2) {
        LyThuyetFragment fragment = new LyThuyetFragment();
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
        View view = inflater.inflate(R.layout.fragment_ly_thuyet, container, false);
        expandableListView = view.findViewById(R.id.expandablelistview);
//        //XuLiJsonLyThuyet();
//        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
//        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Server.Duongdanlytuyet, new Response.Listener<JSONArray>() {
//            @Override
//            public void onResponse(JSONArray response) {
//                if(response != null){
//                    int idmeo = 0;
//                    String nd_thi = "";
//                    String loai = "";
//
//                    for(int i = 0; i < response.length(); i++){
//                        try {
//                            JSONObject jsonObject = response.getJSONObject(i);
//                            idmeo = jsonObject.getInt("idmeothi");
//                            nd_thi = jsonObject.getString("noidungmeothi");
//                            loai = jsonObject.getString("loai");
//                            mListGroup.add(new meothiGroup(idmeo,loai));
//                            //Itermlist.add(new meothiIterm(idmeo, nd_thi));
//                            Itermlist.add(new meothiIterm(idmeo, nd_thi));
//                            meothiAdapter.notifyDataSetChanged();
//                        }catch (Exception e){
//                            e.printStackTrace();
//                        }
//
//                    }
//                }
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//
//            }
//        });
//        requestQueue.add(jsonArrayRequest);
//        mListGroup = new ArrayList<>();
//        Itermlist = new ArrayList<>();
//        itermmeo = (ArrayList<meothiIterm>) mListIterm;
//        meothiIterm = itermmeo;
        mListIterm = getListIterm();
        ///itemlisst = mlisstiterm
        mListGroup = new ArrayList<>(mListIterm.keySet());
        meothiAdapter = new MeoThiAdapter(getActivity(), mListGroup, mListIterm);
        expandableListView.setAdapter(meothiAdapter);
        return view;
    }

    private Map<meothiGroup, ArrayList<meothiIterm>> getListIterm() {
        Map<meothiGroup, ArrayList<meothiIterm>> listMap = new HashMap<>();

            meothiGroup meothiGroup = new meothiGroup(1, "khái niệm và quy tăc");
            meothiGroup meothiGroup1 = new meothiGroup(1, "Hệ thống biển báo ");
            meothiGroup meothiGroup2 = new meothiGroup(1, "sa hình ");
            ArrayList<meothiIterm> itermiterm = new ArrayList<>();

            itermiterm.add(new meothiIterm(1, "Mấy câu hỏi khái niệm hiểu như thế nào"));
            itermiterm.add(new meothiIterm(2, "Mấy câu hỏi khái niệm hiểu như thế nào"));
            itermiterm.add(new meothiIterm(3, "Mấy câu hỏi khái niệm hiểu như thế nào"));
            ArrayList<meothiIterm>itermiterm2 = new ArrayList<>();
            itermiterm.add(new meothiIterm(4, "chú ý để hỏi bài 1 đằng đáp án khác"));
            itermiterm.add(new meothiIterm(5, "chú ý để hỏi bài 1 đằng đáp án khác"));
            itermiterm.add(new meothiIterm(6, "chú ý để hỏi bài 1 đằng đáp án khác"));
            ArrayList<meothiIterm>itermiterm3 = new ArrayList<>();
            itermiterm.add(new meothiIterm(7, "chú ý quan sát"));
            itermiterm.add(new meothiIterm(8, "không làm gì cả"));
            listMap.put(meothiGroup, itermiterm);
            listMap.put(meothiGroup1, itermiterm2);
            listMap.put(meothiGroup2, itermiterm3);
            return listMap;


    }

    private void XuLiJsonLyThuyet() {
        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Server.Duongdanlytuyet, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                if(response != null){
                    int idmeo = 0;
                    String nd_thi = "";
                    String loai = "";

                    for(int i = 0; i < response.length(); i++){
                        try {
                            JSONObject jsonObject = response.getJSONObject(i);
                            idmeo = jsonObject.getInt("idmeothi");
                            nd_thi = jsonObject.getString("noidungmeothi");
                            loai = jsonObject.getString("loai");
                            mListGroup.add(new meothiGroup(idmeo,loai));
//                            Log.d("index1", arrayList.get(0).getLoai());

                            meothiAdapter.notifyDataSetChanged();
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
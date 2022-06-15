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
import com.example.appthibanglaixe.data.sqDuLieu;
import com.example.appthibanglaixe.model.itemMeo;
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
    List<meothiGroup> mListGroup;
//    ArrayList<meothiIterm> Itermlist;
     Map<meothiGroup, List<itemMeo>> mListIterm;
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
        sqDuLieu duLieu = new sqDuLieu(getActivity());
        mListIterm = getListIterm(duLieu);
        mListGroup = new ArrayList<>(mListIterm.keySet());
        meothiAdapter = new MeoThiAdapter(getActivity(), mListGroup, mListIterm);
        expandableListView.setAdapter(meothiAdapter);
        return view;
    }

    private Map<meothiGroup, List<itemMeo>> getListIterm( sqDuLieu duLieu) {
        Map<meothiGroup, List<itemMeo>> listMap = new HashMap<>();
        ArrayList<meothiIterm> values = duLieu.getMeoTHi("1","1");
            meothiGroup meothiGroup = new meothiGroup(1, "khái niệm và quy tăc");
            meothiGroup meothiGroup1 = new meothiGroup(2, "Hệ thống biển báo ");
            meothiGroup meothiGroup2 = new meothiGroup(3, "sa hình ");
            List<itemMeo> Iterm1 = new ArrayList<>();

        Iterm1.add(new itemMeo(1,values.get(0).getNoidung()));
            List<itemMeo>Iterm2 = new ArrayList<>();
        ArrayList<meothiIterm> values2 = duLieu.getMeoTHi("1","2");
        Iterm2.add(new itemMeo(2, values2.get(0).getNoidung()));
            List<itemMeo>Iterm3 = new ArrayList<>();
            ArrayList<meothiIterm> values3 = duLieu.getMeoTHi("1","3");
        Iterm3.add(new itemMeo(3, values3.get(0).getNoidung()));
            listMap.put(meothiGroup, Iterm1);
            listMap.put(meothiGroup1, Iterm2);
            listMap.put(meothiGroup2, Iterm3);
            return listMap;
    }
}
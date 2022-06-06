package com.example.appthibanglaixe.Activity;

import static com.example.appthibanglaixe.R.menu.menu_luyentap;

import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.text.Html;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;

import com.example.appthibanglaixe.Adapter.TimKiemAdapter;
import com.example.appthibanglaixe.R;
import com.example.appthibanglaixe.data.sqDuLieu;
import com.example.appthibanglaixe.model.cauhoi_traloi;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Tab_practice_Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Tab_practice_Fragment extends Fragment {

    Toolbar toobarluyentap;
    ListView lsttimkiem;
    sqDuLieu dulieu;
    SearchView svsearch;
    TimKiemAdapter timKiemAdapter;
    List<cauhoi_traloi> listcauhoi;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Tab_practice_Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Tab_practice_Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Tab_practice_Fragment newInstance(String param1, String param2) {
        Tab_practice_Fragment fragment = new Tab_practice_Fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tab_practice_, container, false);
        toobarluyentap = view.findViewById(R.id.ftp_toobar_luyenlap);
        lsttimkiem = view.findViewById(R.id.ftp_lsttimkiem);
        svsearch = view.findViewById(R.id.searchView);
        listcauhoi = new ArrayList<>();
        dulieu = new sqDuLieu(getActivity());
        ArrayList<cauhoi_traloi> values = dulieu.getCauHoiTraLoi();
        timKiemAdapter = new TimKiemAdapter(getActivity(),values,listcauhoi);
        lsttimkiem.setAdapter(timKiemAdapter);
        Xulitoobarluyentap();
        svsearch.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                timKiemAdapter.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                timKiemAdapter.getFilter().filter(newText);
                return false;
            }
        });
        return view;
    }

    private void Xulitoobarluyentap() {
        AppCompatActivity activity = (AppCompatActivity) getActivity();

        ((AppCompatActivity)getActivity()).setSupportActionBar(toobarluyentap);

        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toobarluyentap.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.finish();
            }
        });
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.menu_luyentap,menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.ml_huongdan:
                Showhuongdanthi();
                break;
            default:
                break;
        }
        //return super.onOptionsItemSelected(item);
        return false;
    }

    public void Showhuongdanthi() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.layout_huongdanthi_dialog, null, false);

        TextView txt1 = view.findViewById(R.id.lhd_txt1);
        TextView txt2 = view.findViewById(R.id.lhd_txt2);
        TextView txt3 = view.findViewById(R.id.lhd_txt3);


        builder.setView(view);
        builder.setTitle("Hướng dẫn làm bài thi")
                .setNegativeButton("Đã hiểu", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
        builder.show();
    }

}
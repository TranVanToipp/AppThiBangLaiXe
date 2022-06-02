package com.example.appthibanglaixe.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.widget.Toolbar;
import androidx.viewpager2.widget.ViewPager2;

import com.example.appthibanglaixe.Adapter.OnLyThuyetAdapter;
import com.example.appthibanglaixe.R;
import com.example.appthibanglaixe.data.sqDuLieu;
import com.example.appthibanglaixe.model.cauhoi_traloi;
import com.example.appthibanglaixe.model.lythuyet;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class HocLyThuyetActivity extends AppCompatActivity {
    Toolbar toobarhoclythuet;
    ListView lstlythuet;
    sqDuLieu dulieu;
    Activity activity;
    OnLyThuyetAdapter adapter;
    ArrayList<cauhoi_traloi> arrayList;
    int index;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hoc_ly_thuyet);
        Anhxa();
        XuliToobar();
        dulieu = new sqDuLieu(this);
        //int i = laydulieu();

        ArrayList<lythuyet> values = dulieu.getdulieulythuyet();
        adapter = new OnLyThuyetAdapter(activity,values);
        lstlythuet.setAdapter(adapter);
        lstlythuet.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                index = position;
//                sendata();
            }

            private void sendata() {
               // Intent intent = new Intent(HocLyThuyetActivity.this,)
            }
        });
    }

    private int laydulieu() {
        Intent intent = getIntent();
        int i = (int) intent.getSerializableExtra("data");
        return i;
    }

    private void XuliToobar() {
        setSupportActionBar(toobarhoclythuet);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toobarhoclythuet.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void Anhxa() {
        toobarhoclythuet = findViewById(R.id.ahl_toobarlythuyet);
        lstlythuet = findViewById(R.id.ahlt_lstlythuyet);
    }
}
package com.example.appthibanglaixe.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager2.widget.ViewPager2;

import com.example.appthibanglaixe.R;
import com.google.android.material.tabs.TabLayout;

public class HocLyThuyetActivity extends AppCompatActivity {
    Toolbar toobarhoclythuet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hoc_ly_thuyet);
        Anhxa();
        XuliToobar();
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

    }
}
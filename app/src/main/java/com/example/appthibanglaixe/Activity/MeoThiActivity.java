package com.example.appthibanglaixe.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager2.widget.ViewPager2;

import com.example.appthibanglaixe.Adapter.Fragment_MeoThi_Adapter;
import com.example.appthibanglaixe.R;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MeoThiActivity extends AppCompatActivity {
    Toolbar toobarmeothi;

    private TabLayout mtablayout;
    private ViewPager2 mviewpage;

    private Fragment_MeoThi_Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meo_thi);
        Anhxa();
        XulitoobarMeothi();
        adapter = new Fragment_MeoThi_Adapter(this);
        mviewpage.setAdapter(adapter);
        new TabLayoutMediator(mtablayout, mviewpage, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                switch (position){
                    case 0:
                        tab.setText("Mẹo Lý thuyết");
                        break;

                    case 1:
                        tab.setText("Mẹo Thực hành");
                        break;
                }
            }
        }).attach();
    }

    private void XulitoobarMeothi() {
        setSupportActionBar(toobarmeothi);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toobarmeothi.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void Anhxa() {
        toobarmeothi = findViewById(R.id.amt_toobar_meothi);

        mtablayout = findViewById(R.id.amt_tablayout);
        mviewpage = findViewById(R.id.amt_viewpage);
    }
}
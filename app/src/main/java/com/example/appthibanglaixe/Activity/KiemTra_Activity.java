package com.example.appthibanglaixe.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import androidx.appcompat.widget.Toolbar;

import com.example.appthibanglaixe.R;

public class KiemTra_Activity extends AppCompatActivity {
   //Toolbar toobar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

         //toobar = (Toolbar) findViewById(R.id.ftt_toobar_kiemtra);
        ActionToobar();
    }

    private void ActionToobar() {

//        setSupportActionBar(toobar);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        toobar.setNavigationOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                finish();
//            }
//        });
    }
}
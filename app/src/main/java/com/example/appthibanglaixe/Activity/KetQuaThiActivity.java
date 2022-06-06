package com.example.appthibanglaixe.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.appthibanglaixe.R;
import com.example.appthibanglaixe.data.DbContract;
import com.example.appthibanglaixe.data.sqDuLieu;
import com.example.appthibanglaixe.model.bode;
import com.example.appthibanglaixe.model.cauhoi_traloi;

import java.util.ArrayList;

public class KetQuaThiActivity extends AppCompatActivity {
    TextView txtKQT,txtDiem, txtSoCauDung, txtcausai;
    ImageView img;
    Button btnLamLai, btnQuayLai;
    sqDuLieu duLieu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ket_qua_thi);
        AnhXa();
        int i = laydulieu()-1;
        int ii = laydulieu();
        duLieu = new sqDuLieu(this);
        ArrayList<bode> valuse = duLieu.getDuLieuBoDe();
        ArrayList<cauhoi_traloi> val = duLieu.getAllPeople(ii);
        if(valuse.get(i).getKetqua().equals("0"))
            txtKQT.setText("Thi Trượt\n(Bạn chưa chọn đáp án nào cả)");
        else
            txtKQT.setText(valuse.get(i).getKetqua());
        int diem =Integer.valueOf(valuse.get(i).getDiem())*4;
        txtDiem.setText(String.valueOf(diem));
        txtSoCauDung.setText(valuse.get(i).getDiem());
        int causai = 25-Integer.valueOf(valuse.get(i).getDiem());
        txtcausai.setText(String.valueOf(causai));
//        if(valuse.get(i).getKetqua().equals("THI DAU")){
//            Glide.with(getApplicationContext()).load(R.drawable.hinhshdau).into(img);
//        }
//        else
//            Glide.with(getApplicationContext()).load(R.drawable.hinhshtruot).into(img);
        btnLamLai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //update(ii);
                sendata(ii);
            }
        });
        btnQuayLai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quayLai();
            }
        });
    }
    private void update(int i){
        ContentValues val = new ContentValues();
        val.put("CauNDChon","");
        duLieu.Update(DbContract.MenuEntry.TABLE_NAME,val, " sobode = "+i,null);

    }
    public void sendata(int i){
        Intent intent = new Intent(this, SatHoachActivity.class);
        intent.putExtra("data",i);
        startActivity(intent);
    }
    private void quayLai(){
        Intent intent = new Intent(this,Tab_Test_Fragment.class);
        startActivity(intent);
    }
    public void AnhXa(){
        txtKQT = findViewById(R.id.txtKQT);
        txtDiem = findViewById(R.id.txtDiem);
        txtSoCauDung = findViewById(R.id.txtSocaudung);
        txtcausai = findViewById(R.id.txtCausai);
        img = findViewById(R.id.imgAnh);
        btnLamLai = findViewById(R.id.btnLamLai);
        btnQuayLai = findViewById(R.id.btnQuayLai);
    }
    private int laydulieu() {
        Intent intent = getIntent();
        int i = (int) intent.getSerializableExtra("bode");
        return i;
    }

}
package com.example.appthibanglaixe.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.appthibanglaixe.R;
import com.example.appthibanglaixe.model.bienbao;
import com.example.appthibanglaixe.model.bode;
import com.example.appthibanglaixe.model.cauhoi_traloi;

import java.util.ArrayList;

public class Cauhoi_traloiAdapter extends BaseAdapter {
    Activity activity;
    ArrayList<bode>arrayList;

    public Cauhoi_traloiAdapter(Activity activity, ArrayList<bode> arrayList) {
        this.activity = activity;
        this.arrayList = arrayList;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);

    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    //có dữ liệu gán lại, đỡ cho chúng ta khi có dữ liệu load đi load lại nhiều lần
    public class ViewHolder {
        public TextView txtsocauhoi, txtbode;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
    if(convertView == null){
        viewHolder = new ViewHolder();
        LayoutInflater layoutInflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = layoutInflater.inflate(R.layout.layout_cus_bode,null);

        viewHolder.txtsocauhoi = convertView.findViewById(R.id.ll_txtsocau);
        viewHolder.txtbode = convertView.findViewById(R.id.ll_txtsode);


        convertView.setTag(viewHolder);
    }else {
        viewHolder = (Cauhoi_traloiAdapter.ViewHolder) convertView.getTag();
    }
    bode bd = (bode) getItem(position);

        int a = 0;

        while (a < arrayList.size()){

            String bode = arrayList.get(a).getSobode();

            viewHolder.txtbode.setText(bode);
            a += 25;

        }
            return convertView;
        }
    }

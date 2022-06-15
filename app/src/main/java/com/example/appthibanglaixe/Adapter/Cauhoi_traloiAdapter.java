package com.example.appthibanglaixe.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.appthibanglaixe.R;
import com.example.appthibanglaixe.model.bienbao;
import com.example.appthibanglaixe.model.bode;
import com.example.appthibanglaixe.model.cauhoi_traloi;

import java.util.ArrayList;

public class Cauhoi_traloiAdapter extends BaseAdapter {
    Activity activity;
    String cau;
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

    public class ViewHolder {
        public TextView txtcau;
        public TextView txtbode;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Cauhoi_traloiAdapter.ViewHolder viewHolder = null;
        if(convertView == null){
            viewHolder = new ViewHolder();
            LayoutInflater layoutInflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.layout_cus_bode, null);
            viewHolder.txtcau = (TextView) convertView.findViewById(R.id.ftt_txtsocau);
            viewHolder.txtbode = (TextView) convertView.findViewById(R.id.ftt_txtsode);

            convertView.setTag(viewHolder);
        }else {
            viewHolder = (Cauhoi_traloiAdapter.ViewHolder) convertView.getTag();
        }
        bode bd = (bode) getItem(position);
        if(bd.getDiem().equals(""))
            cau = "0";
        else cau = bd.getDiem();
        viewHolder.txtcau.setText("Đúng: "+cau+"/"+bd.getSocau()+" câu");
        viewHolder.txtbode.setText("Bộ đề: "+bd.getSobode());

        return convertView;
    }

}

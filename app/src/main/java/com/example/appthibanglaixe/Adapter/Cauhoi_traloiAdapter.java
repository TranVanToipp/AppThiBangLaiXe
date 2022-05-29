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
import com.example.appthibanglaixe.model.cauhoi_traloi;

import java.util.ArrayList;

public class Cauhoi_traloiAdapter extends BaseAdapter {
    Activity activity;
    ArrayList<cauhoi_traloi>arrayList;

    public Cauhoi_traloiAdapter(Activity activity, ArrayList<cauhoi_traloi> arrayList) {
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
        public TextView txtcau, txtnoidung, txthinh, txta, txtb, txtc, txtd, txtcaudung, txtcaudiemliet;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;

        viewHolder = new ViewHolder();
        LayoutInflater layoutInflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = layoutInflater.inflate(R.layout.layoutkiemtra,null);

        viewHolder.txtcau = convertView.findViewById(R.id.socauhoi);
        viewHolder.txtnoidung = convertView.findViewById(R.id.noidungcauhoi);
        viewHolder.txthinh = convertView.findViewById(R.id.hinhcauhoi);

        viewHolder.txta = convertView.findViewById(R.id.a);
        viewHolder.txtb = convertView.findViewById(R.id.b);
        viewHolder.txtc = convertView.findViewById(R.id.c);
        viewHolder.txtd = convertView.findViewById(R.id.d);
        viewHolder.txtcaudung = convertView.findViewById(R.id.caudung);
        viewHolder.txtcaudiemliet = convertView.findViewById(R.id.caudiemliet);

        convertView.setTag(viewHolder);
        cauhoi_traloi choi = (cauhoi_traloi) getItem(position);
        if (choi != null){
            viewHolder.txtcau.setText("câu:" + 1+choi.getCau());
            viewHolder.txtnoidung.setText(choi.getNoidungcauhoi());
            viewHolder.txta.setText(choi.getA());
            viewHolder.txtb.setText(choi.getB());
            viewHolder.txtc.setText(choi.getC());
            viewHolder.txtd.setText(choi.getD());
        }
        return convertView;
    }
}

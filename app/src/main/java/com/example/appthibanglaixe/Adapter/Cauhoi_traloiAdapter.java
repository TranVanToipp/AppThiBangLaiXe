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
        public TextView txtsocauhoi, txtnoidungcauhoi, txtcautraloi1, txtcautraloi2, txtcautraloi3, txtcautraloi4;
        public ImageView imganhcauhoi;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;

            viewHolder = new ViewHolder();
            LayoutInflater layoutInflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.fragment_tab__test_,null);

        viewHolder.txtsocauhoi = convertView.findViewById(R.id.ftt_txt_socautraloi);
        viewHolder.txtnoidungcauhoi = convertView.findViewById(R.id.ftt_txt_noidungcauhoi);
        viewHolder.txtcautraloi1 = convertView.findViewById(R.id.ftt_txt_cautraloi1);
        viewHolder.txtcautraloi2 = convertView.findViewById(R.id.ftt_txt_cautraloi2);
        viewHolder.txtcautraloi3 = convertView.findViewById(R.id.ftt_txt_cautraloi3);
        viewHolder.txtcautraloi4 = convertView.findViewById(R.id.ftt_txt_cautraloi4);

        convertView.setTag(viewHolder);
        cauhoi_traloi choi = (cauhoi_traloi) getItem(position);
        if (choi != null){
            viewHolder.txtsocauhoi.setText("câu:" + 1+choi.getCau());
            viewHolder.txtnoidungcauhoi.setText(choi.getNoidungcauhoi());
            viewHolder.txtcautraloi1.setText(choi.getA());
            viewHolder.txtcautraloi2.setText(choi.getB());
            viewHolder.txtcautraloi3.setText(choi.getC());
            viewHolder.txtcautraloi4.setText(choi.getD());
        }
        return convertView;
    }
}

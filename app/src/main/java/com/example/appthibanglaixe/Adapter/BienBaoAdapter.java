package com.example.appthibanglaixe.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.appthibanglaixe.R;
import com.example.appthibanglaixe.model.bienbao;

import java.util.ArrayList;

public class BienBaoAdapter extends BaseAdapter {
    Context context;
    ArrayList<bienbao> arrayListbienbao;

    public BienBaoAdapter(Context context, ArrayList<bienbao> arrayListbienbao) {
        this.context = context;
        this.arrayListbienbao = arrayListbienbao;
    }

    @Override
    public int getCount() {
        return arrayListbienbao.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayListbienbao.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    //có dữ liệu gán lại, đỡ cho chúng ta khi có dữ liệu load đi load lại nhiều lần
    public class ViewHolder {
        public TextView txtnoidung;
        public ImageView imgbienbao;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if(convertView == null){
            viewHolder = new ViewHolder();
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.cus_bienbao, null);
            viewHolder.txtnoidung = convertView.findViewById(R.id.cb_txtnoidung);
            viewHolder.imgbienbao = convertView.findViewById(R.id.cb_img_bienbao);

            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        bienbao bb = (bienbao) getItem(position);
        viewHolder.txtnoidung.setText(bb.getNoidungbienbao());
        //Glide.with(context).load(bb.getHinhbienbao()).placeholder(R.drawable.icon).error(R.drawable.hinhanhlythuethome).into(viewHolder.imgbienbao);
        viewHolder.imgbienbao.setTag(bb.getHinhbienbao());
//        String tenhih= bb.getHinhbienbao();
//        viewHolder.imgbienbao.setBackgroundResource();
        return convertView;
    }
}

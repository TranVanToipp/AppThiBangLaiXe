package com.example.appthibanglaixe.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.appthibanglaixe.R;
import com.example.appthibanglaixe.data.sqDuLieu;
import com.example.appthibanglaixe.model.bienbao;
import com.example.appthibanglaixe.model.cauhoi_traloi;
import com.example.appthibanglaixe.model.lythuyet;

import java.util.ArrayList;

public class OnLyThuyetAdapter extends BaseAdapter {
    Context context;
    ArrayList<lythuyet>arrayList;
    public OnLyThuyetAdapter( Context context, ArrayList<lythuyet> valuse) {
        this.context = context;
        this.arrayList = valuse;
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
        public TextView txtnoidung;
        public TextView txtsocau, txtTienDo;
        public ImageView imghinhanh;
        public TextView txtcaudiemliet;
        public ProgressBar bgbtiendo;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        OnLyThuyetAdapter.ViewHolder viewHolder = null;
        if(convertView == null){
            viewHolder = new ViewHolder();
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.layout_cus_hoclythuyet, null);
            viewHolder.imghinhanh = convertView.findViewById(R.id.lch_imghinh);
            viewHolder.txtnoidung = convertView.findViewById(R.id.lch_txtloai);
            viewHolder.txtsocau = convertView.findViewById(R.id.lch_socau);
            viewHolder.txtcaudiemliet = convertView.findViewById(R.id.lch_caudiemliet);
            viewHolder.bgbtiendo = convertView.findViewById(R.id.lch_pbctientrinh);
            viewHolder.txtTienDo = convertView.findViewById(R.id.lch_tongcauhoi);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        lythuyet lt = (lythuyet) getItem(position);
        viewHolder.txtnoidung.setText(lt.getLoaicauhoi());
        viewHolder.txtsocau.setText("Gồm có: "+lt.getSocauhoi()+" câu");
        viewHolder.txtcaudiemliet.setText(lt.getCaudiemliet());
        int cau = Integer.valueOf(lt.getSocauhoi());
        viewHolder.bgbtiendo.setMax(cau);
        if(lt.getTiendo().isEmpty())
            viewHolder.bgbtiendo.setProgress(0);
        else {
            int tdo=Integer.valueOf(lt.getTiendo());
            viewHolder.bgbtiendo.setProgress(tdo);
        }
        if(lt.getTiendo().isEmpty()){
            viewHolder.txtTienDo.setText("0/"+cau);
        }
        else
            viewHolder.txtTienDo.setText(lt.getTiendo()+"/"+cau);

        Glide.with(convertView).load(lt.getHinhanh()).placeholder(R.drawable.icon).into(viewHolder.imghinhanh);
        return convertView;
    }
}

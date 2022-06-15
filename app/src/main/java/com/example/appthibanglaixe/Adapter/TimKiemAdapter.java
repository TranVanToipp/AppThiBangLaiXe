package com.example.appthibanglaixe.Adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.TextView;

import com.example.appthibanglaixe.R;
import com.example.appthibanglaixe.model.cauhoi_traloi;

import java.util.ArrayList;
import java.util.List;

public class TimKiemAdapter extends BaseAdapter {
    Activity activity;
    ArrayList<cauhoi_traloi> arrayList;
    List<cauhoi_traloi> adater;

    public TimKiemAdapter(Activity activity, ArrayList<cauhoi_traloi> arrayList, List<cauhoi_traloi> arrList) {
        this.activity = activity;
        this.arrayList = arrayList;
        this.adater = arrayList;
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

    public class ViewHolder{
        TextView txtnoidung;
        TextView txtdapandung;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TimKiemAdapter.ViewHolder viewHolder = null;
        if(convertView == null){
            viewHolder = new ViewHolder();
            LayoutInflater layoutInflater = (LayoutInflater) activity.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.layout_timkiem, null);
            viewHolder.txtnoidung = convertView.findViewById(R.id.lt_txtnoidung);
            viewHolder.txtdapandung = convertView.findViewById(R.id.lt_txtdapan);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
            cauhoi_traloi ch = (cauhoi_traloi) getItem(position);
            viewHolder.txtnoidung.setText(ch.getNoidungcauhoi());
            if(ch.getCaudung().equals("a")){
                viewHolder.txtdapandung.setText("Đáp án: "+ch.getA());
            }else if(ch.getCaudung().equals("b")){
                viewHolder.txtdapandung.setText("Đáp án: "+ch.getB());
            }else if(ch.getCaudung().equals("c")){
                viewHolder.txtdapandung.setText("Đáp án: "+ch.getC());
            }else if(ch.getCaudung().equals("d")){
                viewHolder.txtdapandung.setText("Đáp án: "+ch.getD());
            }
            else viewHolder.txtdapandung.setText("Chưa cập nhật!");

        }
        return convertView;
    }

    public Filter getFilter(){
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                String search = constraint.toString();
                if(search.isEmpty()){
                    arrayList = (ArrayList<cauhoi_traloi>) adater;
                }else {
                    List<cauhoi_traloi> lstseach = new ArrayList<>();
                    for(cauhoi_traloi ch: adater){
                        if(ch.getNoidungcauhoi().toLowerCase().contains(search.toLowerCase())){
                            lstseach.add(ch);
                        }
                    }
                    arrayList = (ArrayList<cauhoi_traloi>) lstseach;
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = arrayList;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                arrayList = (ArrayList<cauhoi_traloi>) results.values;
                notifyDataSetChanged();
            }
        };
    }
}

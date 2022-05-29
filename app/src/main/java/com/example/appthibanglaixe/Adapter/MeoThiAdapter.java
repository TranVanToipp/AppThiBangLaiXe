package com.example.appthibanglaixe.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.example.appthibanglaixe.R;
import com.example.appthibanglaixe.model.meothiGroup;
import com.example.appthibanglaixe.model.meothiIterm;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MeoThiAdapter extends BaseExpandableListAdapter {
    Activity activity;
    private ArrayList<meothiGroup> mListGroup;
    private Map<meothiGroup, ArrayList<meothiIterm>> mListIterm;


    public MeoThiAdapter(Activity activity, ArrayList<meothiGroup> mListGroup, Map<meothiGroup, ArrayList<meothiIterm>> mListIterm) {
        this.activity = activity;
        this.mListGroup = mListGroup;
        this.mListIterm = mListIterm;
    }

    @Override
    public int getGroupCount() {
        if(mListGroup != null){
            return mListGroup.size();
        }
        return 0;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        if(mListGroup!= null && mListIterm!= null){
            return mListIterm.get(mListGroup.get(groupPosition)).size();
        }
        return 0;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return mListGroup.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return mListIterm.get(mListGroup.get(groupPosition)).get(childPosition);

    }

    @Override
    public long getGroupId(int groupPosition) {
        meothiGroup meothiGroup = mListGroup.get(groupPosition);
        return meothiGroup.getId();
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        meothiIterm meothiIterm = mListIterm.get(mListGroup.get(groupPosition)).get(childPosition);
        return meothiIterm.getId();
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.meothi_group, parent, false);
        }
        TextView txtgroup = convertView.findViewById(R.id.mg_tvmeothi_group);
        meothiGroup meothiGroup = mListGroup.get(groupPosition);
        txtgroup.setText(meothiGroup.getLoai());
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.meothi_iterm, parent, false);
        }
        TextView txtiterm = convertView.findViewById(R.id.mi_tvmeothi_iterm);
        meothiIterm meothiIterm = mListIterm.get(mListGroup.get(groupPosition)).get(childPosition);
        txtiterm.setText(meothiIterm.getNoidung());
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}

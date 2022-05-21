package com.example.appthibanglaixe.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.appthibanglaixe.Activity.Tab_Home_Fragment;
import com.example.appthibanglaixe.Activity.Tab_Test_Fragment;
import com.example.appthibanglaixe.Activity.Tab_Uses_Fragment;
import com.example.appthibanglaixe.Activity.Tab_practice_Fragment;

public class ViewPageAdapter extends FragmentStatePagerAdapter {
    public ViewPageAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new Tab_Home_Fragment();
            case 1:
                return new Tab_Test_Fragment();
            case 2:
                return new Tab_practice_Fragment();
            case 3:
                return new Tab_Uses_Fragment();
            default:
                return new Tab_Home_Fragment();
        }

    }

    @Override
    public int getCount() {
        return 4;
    }
}

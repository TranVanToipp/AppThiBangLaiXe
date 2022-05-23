package com.example.appthibanglaixe.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.appthibanglaixe.Activity.FragmentMeoThi.LyThuyetFragment;
import com.example.appthibanglaixe.Activity.FragmentMeoThi.ThucHanhFragment;

public class Fragment_MeoThi_Adapter extends FragmentStateAdapter {
    public Fragment_MeoThi_Adapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new LyThuyetFragment();

            case 1:
                return new ThucHanhFragment();

            default:
                return new LyThuyetFragment();
        }

    }

    @Override
    public int getItemCount() {
        return 2;
    }
}

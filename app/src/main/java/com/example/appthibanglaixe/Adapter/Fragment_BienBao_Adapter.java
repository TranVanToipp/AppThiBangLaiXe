package com.example.appthibanglaixe.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.appthibanglaixe.Activity.FragmentBienBao.BienChiDanFragment;
import com.example.appthibanglaixe.Activity.FragmentBienBao.BienHieuLenhFragment;
import com.example.appthibanglaixe.Activity.FragmentBienBao.BienbaoCamFragment;

public class Fragment_BienBao_Adapter extends FragmentStateAdapter {
    public Fragment_BienBao_Adapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new BienbaoCamFragment();

            case 1:
                return new BienChiDanFragment();

            case 2:
                return new BienHieuLenhFragment();

            default:
                return new BienbaoCamFragment();
        }

    }

    @Override
    public int getItemCount() {
        return 3;
    }
}

package com.example.appthibanglaixe.Activity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.bumptech.glide.Glide;
import com.example.appthibanglaixe.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Tab_Home_Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Tab_Home_Fragment extends Fragment {
    ViewFlipper imgquangcao;
    ImageView imghoclythuyet, imgmeothi, imgbienbao, imgtracuuluat;
    private View mView;

    private DrawerLayout mDrawerLayout;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Tab_Home_Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Tab_Home_Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Tab_Home_Fragment newInstance(String param1, String param2) {
        Tab_Home_Fragment fragment = new Tab_Home_Fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);


        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);

        }
    }

    @Override
    public void onResume() {

        super.onResume();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_tab__home_,container,false);
        Toolbar toolbar = view.findViewById(R.id.ftt_toobar);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        mDrawerLayout = view.findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this.getActivity(), mDrawerLayout, toolbar, R.string.nav_drawer_open, R.string.nav_drawer_close);
        mDrawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        //////////////////////////////////////////////////////
        imgquangcao = view.findViewById(R.id.fth_img_quangcao);
        //ActionViewFlipper();
        ActionViewFlipper();
        imghoclythuyet = view.findViewById(R.id.fth_img_hoclythuyet);
        imgmeothi = view.findViewById(R.id.fth_imgmeothi);
        imgbienbao = view.findViewById(R.id.fth_img_bienbao);
        imgtracuuluat = view.findViewById(R.id.fth_imgtracuuluat);


        //bắt xự kiện học lý thuyết
        imghoclythuyet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgtracuuluat.setBackgroundResource(R.drawable.background_khonghienthi);
                imgbienbao.setBackgroundResource(R.drawable.background_khonghienthi);
                imghoclythuyet.setBackgroundResource(R.drawable.background_home);
                imgmeothi.setBackgroundResource(R.drawable.background_khonghienthi);
                Intent intent = new Intent(getActivity(), HocLyThuyetActivity.class);
                startActivity(intent);
                //Toast.makeText(getActivity(), "Cùng mình chuyển qua học lý thueets rồi thi nhé!!!", Toast.LENGTH_SHORT).show();
            }
        });

        //bắt xự kiện chuyển sang trang mẹo thi
        imgmeothi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgmeothi.setBackgroundResource(R.drawable.background_home);
                imgbienbao.setBackgroundResource(R.drawable.background_khonghienthi);
                imghoclythuyet.setBackgroundResource(R.drawable.background_khonghienthi);
                imgtracuuluat.setBackgroundResource(R.drawable.background_khonghienthi);
                Intent intent = new Intent(getActivity(), MeoThiActivity.class);
                startActivity(intent);
            }
        });
        // bắt xự kiện biển báo
        imgbienbao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgbienbao.setBackgroundResource(R.drawable.background_home);
                imgtracuuluat.setBackgroundResource(R.drawable.background_khonghienthi);
                imghoclythuyet.setBackgroundResource(R.drawable.background_khonghienthi);
                imgmeothi.setBackgroundResource(R.drawable.background_khonghienthi);
                Intent intent = new Intent(getActivity(), BienBaoActivity.class);
                startActivity(intent);
            }
        });
        //bắt xự kiên tra cứu luật
        imgtracuuluat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgtracuuluat.setBackgroundResource(R.drawable.background_home);
                imgbienbao.setBackgroundResource(R.drawable.background_khonghienthi);
                imghoclythuyet.setBackgroundResource(R.drawable.background_khonghienthi);
                imgmeothi.setBackgroundResource(R.drawable.background_khonghienthi);
                Dialogtracuuluat();
            }

            private void Dialogtracuuluat() {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                LayoutInflater inflater1 = getLayoutInflater();
                View view = inflater1.inflate(R.layout.layout_dialog_tracuuluat, null, false);
                TextView txt1 = view.findViewById(R.id.ldt_txt1);
                builder.setView(view);
                builder.setTitle("Thông báo").setNegativeButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.show();
            }
        });

        //return inflater.inflate(R.layout.fragment_tab__uses_, container, false);
        return view;
    }




    private void ActionViewFlipper() {
        List<String> mangquangcao = new ArrayList<>();
        //mangquangcao.add("https://images.search.yahoo.com/search/images;_ylt=Awr9Iks6SYtiVF8A5ZNXNyoA;_ylu=Y29sbwNncTEEcG9zAzEEdnRpZAMEc2VjA3BpdnM-?p=h%C3%ACnh+%E1%BA%A3nh+lu%E1%BA%ADt+giao+th%C3%B4ng+%C4%91%C6%B0%E1%BB%9Dng+b%E1%BB%99&fr2=piv-web#id=79&iurl=https%3A%2F%2Ftinbanxe.vn%2Fuploads%2Fcar%2Fbien-bao-giao-thong.jpg&action=click");
        mangquangcao.add("http://mauweb.monamedia.net/thegioididong/wp-content/uploads/2017/12/banner-Le-hoi-phu-kien-800-300.png");
        mangquangcao.add("http://mauweb.monamedia.net/thegioididong/wp-content/uploads/2017/12/banner-HC-Tra-Gop-800-300.png");
        mangquangcao.add("http://mauweb.monamedia.net/thegioididong/wp-content/uploads/2017/12/banner-big-ky-nguyen-800-300.jpg");

        for (int i = 0; i <  mangquangcao.size(); i++){
            ImageView imageView = new ImageView(getActivity().getApplicationContext());
            Glide.with(getActivity().getApplicationContext()).load(mangquangcao.get(i)).into(imageView);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imgquangcao.addView(imageView);
        }
        imgquangcao.setFlipInterval(5000);
        imgquangcao.setAutoStart(true);
    }
}
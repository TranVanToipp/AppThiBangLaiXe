package com.example.appthibanglaixe;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.appthibanglaixe.Adapter.ViewPageAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private ViewPager mViewPage;
    private BottomNavigationView mbottomNavigationView;
    // khai báo toobar
    Toolbar toobar;
    private DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Anhxa();
        //khởi tạo adapter view page
        ViewPageAdapter viewPageAdapter = new ViewPageAdapter(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        mViewPage.setAdapter(viewPageAdapter);
        XuliTabMenuHome();
    }

    private void XuLiToolbar() {
        //Toolbar toolbar = findViewById(R.id.toobar);
        setSupportActionBar(toobar);
        mDrawerLayout = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, mDrawerLayout, toobar, R.string.nav_drawer_open, R.string.nav_drawer_close);
        mDrawerLayout.addDrawerListener(toggle);
        toggle.syncState();
    }

    public boolean onNavigationItermSelected(MenuItem item){
        int id = item.getItemId();
        if(id == R.id.mh_menu_homepage){

        }else if(id == R.id.mh_menu_test){

        }else if(id == R.id.mh_menu_practice){

        }
        mDrawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }


    private void XuliTabMenuHome() {
    // xự kiện chuyển page
        mViewPage.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        mbottomNavigationView.getMenu().findItem(R.id.mh_menu_homepage).setChecked(true);
                        break;
                    case 1:
                        mbottomNavigationView.getMenu().findItem(R.id.mh_menu_test).setChecked(true);
                        break;
                    case 2:
                        mbottomNavigationView.getMenu().findItem(R.id.mh_menu_practice).setChecked(true);
//                        Tab_practice_Fragment.Showhuongdanthi();
                        break;
                        //menu tab Tôi:<item android:id="@+id/mh_menu_uses" android:title="Tôi"
                    //        android:icon="@drawable/ic_baseline_person_24"/>
//                    case 3:
//                        mbottomNavigationView.getMenu().findItem(R.id.mh_menu_uses).setChecked(true);
//                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    mbottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()){
                case R.id.mh_menu_homepage:
                    mViewPage.setCurrentItem(0);
                    break;
                case R.id.mh_menu_test:
                    mViewPage.setCurrentItem(1);
                    break;
                case R.id.mh_menu_practice:
                    mViewPage.setCurrentItem(2);
                    break;
//                case R.id.mh_menu_uses:
//                    mViewPage.setCurrentItem(3);
//                    break;
            }
            return true;
        }
    });
    }

    private void Anhxa() {
        mViewPage = findViewById(R.id.view_pager);
        mbottomNavigationView = findViewById(R.id.bottom_navigation);
    }

    long countTime;
    Toast toast;
    @Override
    public void onBackPressed() {
        if(countTime+2000>System.currentTimeMillis()){
            toast.cancel();
            super.onBackPressed();
            return;
        }
        else{
            toast = Toast.makeText(this, "Nhấn Back 1 lần nữa để thoát", Toast.LENGTH_SHORT);
            toast.show();
        }
        countTime = System.currentTimeMillis();
    }
}
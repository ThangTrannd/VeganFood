package vn.fpoly.veganfood.activity.splash;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import me.relex.circleindicator.CircleIndicator;
import vn.fpoly.veganfood.R;
import vn.fpoly.veganfood.activity.login.ForgotPass;
import vn.fpoly.veganfood.activity.login.LoginActivity;

public class SplashActivity1 extends AppCompatActivity {
    private TextView tv_next;
    private ViewPager viewPager;
    private RelativeLayout layoutBottom;
    private CircleIndicator circleIndicator;
    private TextView tv_skip;

    private ViewPagerAdapter viewPagerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_blank);
        unitUI();
        initListener();
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewPager.setAdapter(viewPagerAdapter);

        circleIndicator.setViewPager(viewPager);
    }

    private void unitUI(){
        tv_next = findViewById(R.id.tv_nexts);
        viewPager = findViewById(R.id.view_pager);
        layoutBottom = findViewById(R.id.layout_bottom);
        circleIndicator = findViewById(R.id.circle);
        tv_skip = findViewById(R.id.tv_skip);
    }

    private void initListener(){
        tv_skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager.setCurrentItem(3);
            }
        });

        tv_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(viewPager.getCurrentItem() < 2)  {
                    viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
                }
            }
        });

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                 if(position == 2) {
                     tv_skip.setVisibility(View.GONE);
                     layoutBottom.setVisibility(View.GONE);
                 } else {
                     tv_skip.setVisibility(View.VISIBLE);
                     layoutBottom.setVisibility(View.VISIBLE);
                 }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
//        tv_next.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(SplashActivity1.this, SplashActivity2.class));
//            }
//        });
    }
}
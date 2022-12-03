package vn.fpoly.veganfood.activity.splash;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import me.relex.circleindicator.CircleIndicator;
import vn.fpoly.veganfood.R;
import vn.fpoly.veganfood.activity.login.LoginActivity;
import vn.fpoly.veganfood.activity.main.HomeFragment;
import vn.fpoly.veganfood.activity.main.MainActivity;

public class SplashNewBie extends AppCompatActivity {
    private TextView tv_next;
    private ViewPager viewPager;
    private CircleIndicator circleIndicator;
    private TextView tv_skip;

    private ViewPagerAdapter viewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_newbie);
        unitUI();
        initListener();

    }

    private void unitUI() {
        tv_next = findViewById(R.id.tv_next);
        circleIndicator = findViewById(R.id.circle);
        tv_skip = findViewById(R.id.tv_skip);
        viewPager = findViewById(R.id.view_pager);
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewPager.setAdapter(viewPagerAdapter);

        circleIndicator.setViewPager(viewPager);
    }

    private void initListener() {

        tv_skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager.setCurrentItem(3);
            }
        });

        tv_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (viewPager.getCurrentItem() < 2) {
                    viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
                }
                else{
                    startActivity(new Intent(getApplicationContext(), MainActivity.class
                    ));
                    finish();
                }
            }
        });

        viewPager.setAdapter(viewPagerAdapter);
        circleIndicator.setViewPager(viewPager);

    }
}
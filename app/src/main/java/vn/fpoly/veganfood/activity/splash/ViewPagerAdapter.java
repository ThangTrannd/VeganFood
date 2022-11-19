package vn.fpoly.veganfood.activity.splash;

import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import vn.fpoly.veganfood.fragment.StartFragment;
import vn.fpoly.veganfood.fragment.MidleFragment;
import vn.fpoly.veganfood.fragment.EndFragment;

public class ViewPagerAdapter extends FragmentStatePagerAdapter{
    public ViewPagerAdapter(@NonNull FragmentManager fm, int behaviorResumeOnlyCurrentFragment) {
        super(fm);
    }

    @NonNull
    @Override
    public androidx.fragment.app.Fragment getItem(int position) {
        switch (position) {
            case 1:
                return new MidleFragment();
            case 2:
                return new EndFragment();
            default:
                return new StartFragment();
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

}

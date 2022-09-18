package vn.fpoly.veganfood.activity.splash;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import vn.fpoly.veganfood.fragment.BlankFragment;
import vn.fpoly.veganfood.fragment.OnBoardingFragment;
import vn.fpoly.veganfood.fragment.OnboardingFragment1;

public class ViewPagerAdapter extends FragmentStatePagerAdapter{
    public ViewPagerAdapter(@NonNull FragmentManager fm, int behaviorResumeOnlyCurrentFragment) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new BlankFragment();
            case 1:
                return new OnBoardingFragment();
            case 2:
                return new OnboardingFragment1();
            default:
                return new BlankFragment();
        }
    }

    @Override
    public int getCount() {
        return 3;
    }



//
//    @Override
//    public int getItemCount() {
//        return 2;
//    }
}

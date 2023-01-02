package vn.fpoly.veganfood.feature.registerAcc;
import com.gemvietnam.base.viper.ViewFragment;

import vn.fpoly.veganfood.feature.base.TCCBaseActivity;

public class RegisterAccountActivity extends TCCBaseActivity {
    @Override
    public ViewFragment onCreateFirstFragment() {
        return (ViewFragment) new RegisterAccountPresenter(this).getFragment();
    }
}

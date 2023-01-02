package vn.fpoly.veganfood.feature.login;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import vn.fpoly.veganfood.R;
import vn.fpoly.veganfood.feature.base.TCCBaseActivity;
import com.gemvietnam.base.viper.ViewFragment;

public class LoginActivity extends TCCBaseActivity{

    @Override
    public ViewFragment onCreateFirstFragment() {
        return (ViewFragment) new LoginPresenter(this).getFragment();
    }
}
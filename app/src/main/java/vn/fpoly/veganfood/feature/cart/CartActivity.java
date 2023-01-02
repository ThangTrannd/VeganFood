package vn.fpoly.veganfood.feature.cart;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import vn.fpoly.veganfood.R;
import vn.fpoly.veganfood.feature.base.TCCBaseActivity;
import vn.fpoly.veganfood.feature.order.OrderPresenter;
import com.gemvietnam.base.viper.ViewFragment;

public class CartActivity extends TCCBaseActivity {

    @Override
    public ViewFragment onCreateFirstFragment() {
        return (ViewFragment) new CartPresenter(this).getFragment();
    }
}
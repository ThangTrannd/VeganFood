package vn.fpoly.veganfood.feature.product_detail;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import vn.fpoly.veganfood.R;
import vn.fpoly.veganfood.feature.base.TCCBaseActivity;
import vn.fpoly.veganfood.feature.login.LoginPresenter;
import com.gemvietnam.base.viper.ViewFragment;

public class ProductDetailActivity extends TCCBaseActivity {

    @Override
    public ViewFragment onCreateFirstFragment() {
        return (ViewFragment) new ProductDetailPresenter(this).getFragment();
    }
}
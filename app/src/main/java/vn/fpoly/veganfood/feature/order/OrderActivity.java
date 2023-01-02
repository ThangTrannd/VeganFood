package vn.fpoly.veganfood.feature.order;

import android.content.Intent;

import vn.fpoly.veganfood.feature.base.TCCBaseActivity;
import vn.fpoly.veganfood.feature.product_detail.ProductDetailPresenter;
import com.gemvietnam.base.viper.ViewFragment;

import vn.zalopay.sdk.ZaloPaySDK;

public class OrderActivity extends TCCBaseActivity {
    @Override
    public ViewFragment onCreateFirstFragment() {
        return (ViewFragment) new OrderPresenter(this).getFragment();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        ZaloPaySDK.getInstance().onResult(intent);
    }
}

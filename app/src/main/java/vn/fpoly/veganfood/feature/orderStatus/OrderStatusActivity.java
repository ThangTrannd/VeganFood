package vn.fpoly.veganfood.feature.orderStatus;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;

import vn.fpoly.veganfood.dialog.DialogUtils;
import vn.fpoly.veganfood.feature.base.TCCBaseActivity;
import vn.fpoly.veganfood.feature.registerAcc.RegisterAccountPresenter;
import vn.fpoly.veganfood.model.UserInfoResult;
import vn.fpoly.veganfood.network.NetWorkController;
import vn.fpoly.veganfood.network.TCCCallback;
import com.gemvietnam.base.viper.ViewFragment;

import retrofit2.Call;
import retrofit2.Response;

public class OrderStatusActivity extends TCCBaseActivity {

    private MyBroadcastReceiver receiver;

    OrderStatusPresenter orderStatusPresenter;
    @Override
    public ViewFragment onCreateFirstFragment() {
        orderStatusPresenter = new OrderStatusPresenter(this);
        return (ViewFragment) orderStatusPresenter.getFragment();
    }

    private class MyBroadcastReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            Bundle extras = intent.getExtras();
            String state = extras.getString("extra");
            Log.e("XXX",state);
            DialogUtils.showProgressDialog(getViewContext());
            if(state.equals("Đơn hàng của bạn đã được xác nhận")) {
                orderStatusPresenter.shipping(state);
            }else if(state.equals("Đơn hàng của bạn đã giao xong")) {
                orderStatusPresenter.finishOrder(state);
            }
//            updateView(state);// update your textView in the main layout
        }
    }

    private void getOrderIcon() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        receiver = new MyBroadcastReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.my.app.onMessageReceived");
        registerReceiver(receiver, intentFilter);
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        try {
            unregisterReceiver(receiver);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}

package vn.fpoly.veganfood.feature.orderStatus;

import vn.fpoly.veganfood.dialog.DialogUtils;
import vn.fpoly.veganfood.feature.registerAcc.RegisterAccountContract;
import vn.fpoly.veganfood.feature.registerAcc.RegisterAccountFragment;
import vn.fpoly.veganfood.feature.registerAcc.RegisterAccountInteractor;
import vn.fpoly.veganfood.model.ProductsResult;
import vn.fpoly.veganfood.model.RegisterResult;
import vn.fpoly.veganfood.model.UserCurrentResult;
import vn.fpoly.veganfood.network.TCCCallback;
import com.gemvietnam.base.viper.Presenter;
import com.gemvietnam.base.viper.interfaces.ContainerView;

import retrofit2.Call;
import retrofit2.Response;

public class OrderStatusPresenter extends Presenter<OrderStatusContract.View, OrderStatusContract.Interactor>
        implements OrderStatusContract.Presenter{
    public OrderStatusPresenter(ContainerView containerView) {
        super(containerView);
    }
    @Override
    public void start() {

    }

    @Override
    public OrderStatusContract.Interactor onCreateInteractor() {
        return new OrderStatusInteractor(this);
    }

    @Override
    public OrderStatusContract.View onCreateView() {
        return OrderStatusFragment.getInstance();
    }

    @Override
    public void getUserCurrentOrder(String token) {
        DialogUtils.showProgressDialog(getViewContext());
        mInteractor.getUserCurrentOrder(new TCCCallback<UserCurrentResult>() {
            @Override
            public void onTCTCSuccess(Call<UserCurrentResult> call, Response<UserCurrentResult> response) {
                DialogUtils.dismissProgressDialog();
                mView.getUserCurrentOrderSuccess(response.body());
            }

            @Override
            public void onTCTCFailure(Call<UserCurrentResult> call) {
                DialogUtils.dismissProgressDialog();
            }
        }, token);
    }


    @Override
    public void getItemsInOrder(String token, int orderId) {
        DialogUtils.showProgressDialog(getViewContext());
        mInteractor.getItemsInOrder(new TCCCallback<ProductsResult>() {
            @Override
            public void onTCTCSuccess(Call<ProductsResult> call, Response<ProductsResult> response) {
                mView.getItemsInOrderSuccess(response.body());
                DialogUtils.dismissProgressDialog();
            }

            @Override
            public void onTCTCFailure(Call<ProductsResult> call) {
                DialogUtils.dismissProgressDialog();
            }
        }, token, orderId);
    }

    @Override
    public void shipping(String shipping) {
        mView.updateUIShipping(shipping);
    }

    @Override
    public void finishOrder(String finishOrder) {
        mView.finishOrder(finishOrder);
    }

    @Override
    public void userCancelOrder(String token, int orderId) {
        DialogUtils.showProgressDialog(getViewContext());
        mInteractor.userCancelOrder(new TCCCallback<RegisterResult>() {
            @Override
            public void onTCTCSuccess(Call<RegisterResult> call, Response<RegisterResult> response) {
                DialogUtils.dismissProgressDialog();
                mView.cancelOrderSuccess();
            }

            @Override
            public void onTCTCFailure(Call<RegisterResult> call) {
                DialogUtils.dismissProgressDialog();
            }
        }, token, orderId);
    }
}

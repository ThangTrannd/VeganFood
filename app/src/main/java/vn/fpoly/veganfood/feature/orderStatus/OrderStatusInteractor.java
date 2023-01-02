package vn.fpoly.veganfood.feature.orderStatus;

import vn.fpoly.veganfood.feature.registerAcc.RegisterAccountContract;
import vn.fpoly.veganfood.model.ProductsResult;
import vn.fpoly.veganfood.model.RegisterResult;
import vn.fpoly.veganfood.model.UserCurrentResult;
import vn.fpoly.veganfood.network.NetWorkController;
import vn.fpoly.veganfood.network.TCCCallback;
import com.gemvietnam.base.viper.Interactor;

public class OrderStatusInteractor extends Interactor<OrderStatusContract.Presenter>
        implements OrderStatusContract.Interactor{

    public OrderStatusInteractor(OrderStatusContract.Presenter presenter) {
        super(presenter);
    }

    @Override
    public void getUserCurrentOrder(TCCCallback<UserCurrentResult> callback, String token) {
        NetWorkController.getUserCurrentOrder(callback, token);
    }

    @Override
    public void getItemsInOrder(TCCCallback<ProductsResult> callback, String token, int orderId) {
        NetWorkController.getItemsInOrder(callback, token, orderId);
    }

    @Override
    public void userCancelOrder(TCCCallback<RegisterResult> callback, String token, int orderId) {
        NetWorkController.userCancelOrder(callback, token, orderId);
    }
}

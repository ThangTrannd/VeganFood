package vn.fpoly.veganfood.feature.orderStatus;

import vn.fpoly.veganfood.feature.registerAcc.RegisterAccountContract;
import vn.fpoly.veganfood.model.ProductResult;
import vn.fpoly.veganfood.model.ProductsResult;
import vn.fpoly.veganfood.model.RegisterResult;
import vn.fpoly.veganfood.model.SessionIdResult;
import vn.fpoly.veganfood.model.UserCurrentResult;
import vn.fpoly.veganfood.network.TCCCallback;
import com.gemvietnam.base.viper.interfaces.IInteractor;
import com.gemvietnam.base.viper.interfaces.IPresenter;
import com.gemvietnam.base.viper.interfaces.PresentView;

import retrofit2.Response;

public interface OrderStatusContract {
    interface Interactor extends IInteractor<Presenter> {
        void getUserCurrentOrder(TCCCallback<UserCurrentResult> callback, String token);
        void getItemsInOrder(TCCCallback<ProductsResult> callback, String token, int orderId);
        void userCancelOrder(TCCCallback<RegisterResult> callback, String token, int orderId);
    }

    interface View extends PresentView<Presenter> {
        void getUserCurrentOrderSuccess(UserCurrentResult userCurrentResult);
        void getItemsInOrderSuccess(ProductsResult productsResult);
        void updateUIShipping(String shipping);
        void finishOrder(String finishOrder);
        void cancelOrderSuccess();
    }

    interface Presenter extends IPresenter<View, Interactor> {
        void getUserCurrentOrder(String token);
        void getItemsInOrder(String token, int orderId);
        void shipping(String shipping);
        void finishOrder(String finishOrder);
        void userCancelOrder(String token, int orderId);
    }
}

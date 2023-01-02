package vn.fpoly.veganfood.feature.order;

import vn.fpoly.veganfood.feature.product_detail.ProductDetailContract;
import vn.fpoly.veganfood.model.CartInfoResult;
import vn.fpoly.veganfood.model.ProductResult;
import vn.fpoly.veganfood.model.ProductsSessionResult;
import vn.fpoly.veganfood.model.RegisterResult;
import vn.fpoly.veganfood.model.SessionIdResult;
import vn.fpoly.veganfood.model.UserInfoResult;
import vn.fpoly.veganfood.network.TCCCallback;
import com.gemvietnam.base.viper.interfaces.IInteractor;
import com.gemvietnam.base.viper.interfaces.IPresenter;
import com.gemvietnam.base.viper.interfaces.PresentView;

import retrofit2.Response;

public interface OrderContract {
    interface Interactor extends IInteractor<Presenter> {
        void itemsInShoppingSession(TCCCallback<ProductsSessionResult> callback, String token, int sessionId);
        void getUserInfo(TCCCallback<UserInfoResult> callback, String token);
        void getCartInfo(TCCCallback<CartInfoResult> callback, String token, int sessionId);
        void confirmOrder(TCCCallback<RegisterResult> callback, String token, int sessionId, String provider, String phoneNumber, String address, String note);
        void addItemToShoppingSession(TCCCallback<RegisterResult> callback, String token, int sessionId, int productId, int quantity, String size);
        void deleteItemInShoppingSession(TCCCallback<RegisterResult> callback, String token, int itemId,  int sessionId);
    }

    interface View extends PresentView<Presenter> {
        void initViewDetail(Response<ProductsSessionResult> data);
        void getCartInfoSuccess(Response<CartInfoResult> data);
        void getCartInfoFail();
        void getUserInfoSuccess(Response<UserInfoResult> data);
        void confirmOrderSuccess(Response<RegisterResult> data);
    }

    interface Presenter extends IPresenter<View, Interactor> {
        void itemsInShoppingSession(String token, int sessionId);
        void getUserInfo(String token);
        void getCartInfo(String token, int sessionId);
        void confirmOrder(String token, int sessionId, String provider, String phoneNumber, String address, String note);
        void addItemToShoppingSession(String token, int sessionId, int productId, int quantity, String size);
        void deleteItemInShoppingSession(String token, int itemId,  int sessionId);
    }
}

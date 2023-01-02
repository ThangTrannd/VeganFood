package vn.fpoly.veganfood.feature.cart;

import vn.fpoly.veganfood.feature.order.OrderContract;
import vn.fpoly.veganfood.model.CartInfoResult;
import vn.fpoly.veganfood.model.ProductsSessionResult;
import vn.fpoly.veganfood.model.RegisterResult;
import vn.fpoly.veganfood.model.UserInfoResult;
import vn.fpoly.veganfood.network.TCCCallback;
import com.gemvietnam.base.viper.interfaces.IInteractor;
import com.gemvietnam.base.viper.interfaces.IPresenter;
import com.gemvietnam.base.viper.interfaces.PresentView;

import retrofit2.Response;

public interface CartContract {
    interface Interactor extends IInteractor<Presenter> {
        void itemsInShoppingSession(TCCCallback<ProductsSessionResult> callback, String token, int sessionId);
        void getCartInfo(TCCCallback<CartInfoResult> callback, String token, int sessionId);
        void addItemToShoppingSession(TCCCallback<RegisterResult> callback, String token, int sessionId, int productId, int quantity, String size);
        void deleteItemInShoppingSession(TCCCallback<RegisterResult> callback, String token, int itemId,  int sessionId);
    }

    interface View extends PresentView<Presenter> {
        void initViewDetail(Response<ProductsSessionResult> data);
        void getCartInfoSuccess(Response<CartInfoResult> data);
        void getCartInfoFail();
    }

    interface Presenter extends IPresenter<View, Interactor> {
        void itemsInShoppingSession(String token, int sessionId);
        void getCartInfo(String token, int sessionId);
        void addItemToShoppingSession(String token, int sessionId, int productId, int quantity, String size);
        void deleteItemInShoppingSession(String token, int itemId,  int sessionId);
    }
}

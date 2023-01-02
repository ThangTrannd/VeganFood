package vn.fpoly.veganfood.feature.order;

import vn.fpoly.veganfood.feature.product_detail.ProductDetailContract;
import vn.fpoly.veganfood.model.CartInfoResult;
import vn.fpoly.veganfood.model.ProductResult;
import vn.fpoly.veganfood.model.ProductsSessionResult;
import vn.fpoly.veganfood.model.RegisterResult;
import vn.fpoly.veganfood.model.UserInfoResult;
import vn.fpoly.veganfood.network.NetWorkController;
import vn.fpoly.veganfood.network.TCCCallback;
import com.gemvietnam.base.viper.Interactor;

public class OrderInteractor extends Interactor<OrderContract.Presenter>
        implements OrderContract.Interactor{
    public OrderInteractor(OrderContract.Presenter presenter) {
        super(presenter);
    }

    @Override
    public void itemsInShoppingSession(TCCCallback<ProductsSessionResult> callback, String token, int sessionId) {
        NetWorkController.itemsInShoppingSession(callback, token, sessionId);
    }

    @Override
    public void getUserInfo(TCCCallback<UserInfoResult> callback, String token) {
        NetWorkController.getUserInfo(callback, token);
    }

    @Override
    public void getCartInfo(TCCCallback<CartInfoResult> callback, String token, int sessionId) {
        NetWorkController.getCartInfo(callback, token, sessionId);
    }

    @Override
    public void confirmOrder(TCCCallback<RegisterResult> callback, String token, int sessionId, String provider, String phoneNumber, String address, String note) {
        NetWorkController.confirmOrder(callback, token, sessionId, provider, phoneNumber, address, note);
    }

    @Override
    public void addItemToShoppingSession(TCCCallback<RegisterResult> callback, String token, int sessionId, int productId, int quantity, String size) {
        NetWorkController.addItemToShoppingSession(callback, token, sessionId, productId, quantity, size);
    }

    @Override
    public void deleteItemInShoppingSession(TCCCallback<RegisterResult> callback, String token, int itemId, int sessionId) {
        NetWorkController.deleteItemInShoppingSession(callback, token, itemId, sessionId);
    }
}

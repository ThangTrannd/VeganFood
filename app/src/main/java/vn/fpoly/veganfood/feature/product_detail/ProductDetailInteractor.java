package vn.fpoly.veganfood.feature.product_detail;

import com.gemvietnam.base.viper.Interactor;
import vn.fpoly.veganfood.model.ProductResult;
import vn.fpoly.veganfood.model.ProductsSessionResult;
import vn.fpoly.veganfood.model.RegisterResult;
import vn.fpoly.veganfood.model.SessionIdResult;
import vn.fpoly.veganfood.network.NetWorkController;
import vn.fpoly.veganfood.network.TCCCallback;

public class ProductDetailInteractor extends Interactor<ProductDetailContract.Presenter>
        implements ProductDetailContract.Interactor{
    public ProductDetailInteractor(ProductDetailContract.Presenter presenter) {
        super(presenter);
    }


    @Override
    public void getProductDetail(TCCCallback<ProductResult> callback, int id) {
        NetWorkController.getProductById(callback, id);
    }

    @Override
    public void getUserShoppingSession(TCCCallback<SessionIdResult> callback, String token) {
        NetWorkController.getUserShoppingSession(callback, token);
    }

    @Override
    public void createShoppingSession(TCCCallback<RegisterResult> callback, String token) {
        NetWorkController.createShoppingSession(callback, token);
    }

    @Override
    public void itemsInShoppingSession(TCCCallback<ProductsSessionResult> callback, String token, int sessionId) {
        NetWorkController.itemsInShoppingSession(callback, token, sessionId);
    }

    @Override
    public void addItemToShoppingSession(TCCCallback<RegisterResult> callback, String token, int sessionId, int productId, int quantity, String size) {
        NetWorkController.addItemToShoppingSession(callback, token, sessionId, productId, quantity, size);
    }

    @Override
    public void addFavItem(TCCCallback<RegisterResult> callback, String token, int productId) {
        NetWorkController.addFavItem(callback, token, productId);
    }

    @Override
    public void checkFav(TCCCallback<RegisterResult> callback, String token, int productId) {
        NetWorkController.checkFav(callback, token, productId);
    }

    @Override
    public void deleteFavItem(TCCCallback<RegisterResult> callback, String token, int productId) {
        NetWorkController.deleteFavItem(callback, token, productId);
    }

    @Override
    public void deleteItemInShoppingSession(TCCCallback<RegisterResult> callback, String token, int itemId, int sessionId) {
        NetWorkController.deleteItemInShoppingSession(callback, token, itemId, sessionId);
    }
}
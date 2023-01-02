package vn.fpoly.veganfood.network;

import vn.fpoly.veganfood.domain.DomainSwitcher;
import vn.fpoly.veganfood.model.CartInfoResult;
import vn.fpoly.veganfood.model.CategoriesResult;
import vn.fpoly.veganfood.model.DataTestResult;
import vn.fpoly.veganfood.model.FavoriteProductsResult;
import vn.fpoly.veganfood.model.LoginResult;
import vn.fpoly.veganfood.model.NotifiResult;
import vn.fpoly.veganfood.model.ProductResult;
import vn.fpoly.veganfood.model.ProductsByCategoryResult;
import vn.fpoly.veganfood.model.ProductsResult;
import vn.fpoly.veganfood.model.ProductsSessionResult;
import vn.fpoly.veganfood.model.RegisterResult;
import vn.fpoly.veganfood.model.SessionIdResult;
import vn.fpoly.veganfood.model.UserCurrentResult;
import vn.fpoly.veganfood.model.UserInfoResult;
import vn.fpoly.veganfood.model.UserOrderResult;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;

public class NetWorkController {
    private NetWorkController() {
    }
    public static Gson getGson() {
        return new GsonBuilder()
                .setLenient()
                .create();
    }


    // TODO : Dong sua test api
    private static TCCAPI getAPIBuilder() {
        return DomainSwitcher.getInstance().getApiClient(TCCAPI.class);
    }


    public static void getListDataTest(TCCCallback<DataTestResult> callback, String token, String contractId, String billCycle) {
        Call<DataTestResult> call = getAPIBuilder().getListDataTest(token, contractId, billCycle);
        call.enqueue(callback);
    }
    public static void getListCategories(TCCCallback<CategoriesResult> callback) {
        Call<CategoriesResult> call = getAPIBuilder().getListCategories();
        call.enqueue(callback);
    }
    public static void getListCategories(TCCCallback<CategoriesResult> callback, int id) {
        Call<CategoriesResult> call = getAPIBuilder().getListCategories(id);
        call.enqueue(callback);
    }

    public static void getProductById(TCCCallback<ProductResult> callback, int id) {
        Call<ProductResult> call = getAPIBuilder().getProductById(id);
        call.enqueue(callback);
    }
    public static void getListProduct(TCCCallback<ProductsResult> callback) {
        Call<ProductsResult> call = getAPIBuilder().getListProduct("");
        call.enqueue(callback);
    }
    public static void sendResetPasswordEmail(TCCCallback<LoginResult> callback, String email) {
        Call<LoginResult> call = getAPIBuilder().sendResetPasswordEmail(email);
        call.enqueue(callback);
    }
    public static void getListProductByCategory(TCCCallback<ProductsByCategoryResult> callback, int id) {
        Call<ProductsByCategoryResult> call = getAPIBuilder().getListProductByCategory(id);
        call.enqueue(callback);
    }
    public static void getListProductByFavorite(TCCCallback<FavoriteProductsResult> callback, String token) {
        Call<FavoriteProductsResult> call = getAPIBuilder().getUserFavoriteItems(token);
        call.enqueue(callback);
    }
    public static void loginWithPass(TCCCallback<LoginResult> callback, String username, String pass, String type, String token_device) {
        Call<LoginResult> call = getAPIBuilder().loginWithPass(username, pass, type, token_device);
        call.enqueue(callback);
    }

    public static void registerAcc(TCCCallback<RegisterResult> callback, String name, String username, String password, String email, String phoneNumber) {
        Call<RegisterResult> call = getAPIBuilder().registerAcc(name, username, password, email, phoneNumber);
        call.enqueue(callback);
    }


    public static void getUserShoppingSession(TCCCallback<SessionIdResult> callback, String token) {
        Call<SessionIdResult> call = getAPIBuilder().getUserShoppingSession(token);
        call.enqueue(callback);
    }
    public static void createShoppingSession(TCCCallback<RegisterResult> callback, String token) {
        Call<RegisterResult> call = getAPIBuilder().createShoppingSession(token);
        call.enqueue(callback);
    }

    public static void getUserInfo(TCCCallback<UserInfoResult> callback, String token) {
        Call<UserInfoResult> call = getAPIBuilder().getUserInfo(token);
        call.enqueue(callback);
    }

    public static void itemsInShoppingSession(TCCCallback<ProductsSessionResult> callback, String token, int sessionId) {
        Call<ProductsSessionResult> call = getAPIBuilder().itemsInShoppingSession(token, sessionId);
        call.enqueue(callback);
    }

    public static void deleteItemInShoppingSession(TCCCallback<RegisterResult> callback, String token, int itemId, int sessionId) {
        Call<RegisterResult> call = getAPIBuilder().deleteItemInShoppingSession(token, itemId, sessionId);
        call.enqueue(callback);
    }

    public static void addFavItem(TCCCallback<RegisterResult> callback, String token, int sessionId) {
        Call<RegisterResult> call = getAPIBuilder().addFavItem(token, sessionId);
        call.enqueue(callback);
    }

    public static void reOrder(TCCCallback<RegisterResult> callback, String token, int orderId, String note) {
        Call<RegisterResult> call = getAPIBuilder().reOrder(token, orderId, note);
        call.enqueue(callback);
    }

    public static void deleteFavItem(TCCCallback<RegisterResult> callback, String token, int sessionId) {
        Call<RegisterResult> call = getAPIBuilder().deleteFavItem(token, sessionId);
        call.enqueue(callback);
    }

    public static void getItemsInOrder(TCCCallback<ProductsResult> callback, String token, int orderId) {
        Call<ProductsResult> call = getAPIBuilder().getItemsInOrder(token, orderId);
        call.enqueue(callback);
    }

    public static void userCancelOrder(TCCCallback<RegisterResult> callback, String token, int orderId) {
        Call<RegisterResult> call = getAPIBuilder().userCancelOrder(token, orderId);
        call.enqueue(callback);
    }

    public static void checkFav(TCCCallback<RegisterResult> callback, String token, int productId) {
        Call<RegisterResult> call = getAPIBuilder().checkFav(token, productId);
        call.enqueue(callback);
    }


    public static void getPromoteNotifications(TCCCallback<NotifiResult> callback) {
        Call<NotifiResult> call = getAPIBuilder().getPromoteNotifications("");
        call.enqueue(callback);
    }

    public static void getNewsNotifications(TCCCallback<NotifiResult> callback) {
        Call<NotifiResult> call = getAPIBuilder().getNewsNotifications("");
        call.enqueue(callback);
    }

    public static void getUserOrder(TCCCallback<UserOrderResult> callback, String token) {
        Call<UserOrderResult> call = getAPIBuilder().getUserOrder(token);
        call.enqueue(callback);
    }

    public static void getUserCurrentOrder(TCCCallback<UserCurrentResult> callback, String token) {
        Call<UserCurrentResult> call = getAPIBuilder().getUserCurrentOrder(token);
        call.enqueue(callback);
    }

    public static void updateUserAddress(TCCCallback<RegisterResult> callback, String token, String address, String phoneNumber) {
        Call<RegisterResult> call = getAPIBuilder().updateUserAddress(token, address, phoneNumber);
        call.enqueue(callback);
    }

    public static void getCartInfo(TCCCallback<CartInfoResult> callback, String token, int sessionId) {
        Call<CartInfoResult> call = getAPIBuilder().getCartInfo(token, sessionId);
        call.enqueue(callback);
    }

    public static void deleteShoppingSession(TCCCallback<RegisterResult> callback, String token, int sessionId) {
        Call<RegisterResult> call = getAPIBuilder().deleteShoppingSession(token, sessionId);
        call.enqueue(callback);
    }

    public static void addItemToShoppingSession(TCCCallback<RegisterResult> callback, String token, int sessionId, int productId, int quantity, String size) {
        Call<RegisterResult> call = getAPIBuilder().addItemToShoppingSession(token, sessionId, productId, quantity, size);
        call.enqueue(callback);
    }

    public static void confirmOrder(TCCCallback<RegisterResult> callback, String token, int sessionId, String provider, String phoneNumber, String address, String note) {
        Call<RegisterResult> call = getAPIBuilder().confirmOrder(token, sessionId, provider, phoneNumber, address, note);
        call.enqueue(callback);
    }
}

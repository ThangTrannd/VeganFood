package vn.fpoly.veganfood.network;

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

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface TCCAPI {
    @FormUrlEncoded
    @POST("getDebitByContract")
    Call<DataTestResult> getListDataTest(@Field("token") String token,
                                         @Field("contractId") String provinceId,
                                         @Field("billCycle") String complainerPhone);

    @POST("product_categories")
    Call<CategoriesResult> getListCategories();

    @FormUrlEncoded
    @POST("product_category")
    Call<CategoriesResult> getListCategories(@Field("id") int id);


    @FormUrlEncoded
    @POST("product")
    Call<ProductResult> getProductById(@Field("id") int id);

    @FormUrlEncoded
    @POST("products")
    Call<ProductsResult> getListProduct(@Field("token") String token);

    @FormUrlEncoded
    @POST("user/send_reset_email")
    Call<LoginResult> sendResetPasswordEmail(@Field("email") String email);

    @FormUrlEncoded
    @POST("get_products_by_category")
    Call<ProductsByCategoryResult> getListProductByCategory(@Field("categoryId") int id);

    @FormUrlEncoded
    @POST("fav/items")
    Call<FavoriteProductsResult> getUserFavoriteItems(@Field("token") String token);

    @FormUrlEncoded
    @POST("login")
    Call<LoginResult> loginWithPass(@Field("username") String username,
                                    @Field("password") String password,
                                    @Field("type") String type,
                                    @Field("token_device") String token_device);

    @FormUrlEncoded
    @POST("signup")
    Call<RegisterResult> registerAcc(@Field("name") String name,
                                     @Field("username") String username,
                                     @Field("password") String password,
                                     @Field("email") String email,
                                     @Field("phoneNumber") String phoneNumber);

    @FormUrlEncoded
    @POST("shopping_session/get_session_id")
    Call<SessionIdResult> getUserShoppingSession(@Field("token") String token);

    @FormUrlEncoded
    @POST("shopping_session/create_session")
    Call<RegisterResult> createShoppingSession(@Field("token") String token);

    @FormUrlEncoded
    @POST("user_info")
    Call<UserInfoResult> getUserInfo(@Field("token") String token);

    @FormUrlEncoded
    @POST("shopping_session/get_cart_info")
    Call<CartInfoResult> getCartInfo(@Field("token") String token,
                                     @Field("sessionId") int sessionId);

    @FormUrlEncoded
    @POST("shopping_session/delete_session")
    Call<RegisterResult> deleteShoppingSession(@Field("token") String token,
                                     @Field("sessionId") int sessionId);

    @FormUrlEncoded
    @POST("update_user_address")
    Call<RegisterResult> updateUserAddress(@Field("token") String token,
                                           @Field("address") String address,
                                           @Field("phoneNumber") String phoneNumber);

    @FormUrlEncoded
    @POST("shopping_session/items")
    Call<ProductsSessionResult> itemsInShoppingSession(@Field("token") String token,
                                                       @Field("sessionId") int sessionId);
    @FormUrlEncoded
    @POST("shopping_session/delete_item")
    Call<RegisterResult> deleteItemInShoppingSession(@Field("token") String token,
                                                     @Field("itemId") int itemId,
                                                       @Field("sessionId") int sessionId);
    @FormUrlEncoded
    @POST("fav/add")
    Call<RegisterResult> addFavItem(@Field("token") String token,
                                    @Field("productId") int productId);

    @FormUrlEncoded
    @POST("order/re_order")
    Call<RegisterResult> reOrder(@Field("token") String token,
                                    @Field("orderId") int orderId,
                                    @Field("note") String note);

    @FormUrlEncoded
    @POST("fav/delete")
    Call<RegisterResult> deleteFavItem(@Field("token") String token,
                                    @Field("productId") int productId);

    @FormUrlEncoded
    @POST("order/get_user_orders")
    Call<UserOrderResult> getUserOrder(@Field("token") String token);


    @FormUrlEncoded
    @POST("user/current-order")
    Call<UserCurrentResult> getUserCurrentOrder(@Field("token") String token);

    @FormUrlEncoded
    @POST("order/get_items")
    Call<ProductsResult> getItemsInOrder(@Field("token") String token,
                                            @Field("orderId") int orderId);

    @FormUrlEncoded
    @POST("order/cancel_order")
    Call<RegisterResult> userCancelOrder(@Field("token") String token,
                                         @Field("orderId") int orderId);

    @FormUrlEncoded
    @POST("fav/check_loved")
    Call<RegisterResult> checkFav(@Field("token") String token,
                                         @Field("productId") int productId);

    //lấy thông báo khuyến mại
    @FormUrlEncoded
    @POST("notification/promote")
    Call<NotifiResult> getPromoteNotifications(@Field("token") String token);

    //lấy thông báo tin tức
    @FormUrlEncoded
    @POST("notification/news")
    Call<NotifiResult> getNewsNotifications(@Field("token") String token);

    @FormUrlEncoded
    @POST("shopping_session/add_item")
    Call<RegisterResult> addItemToShoppingSession(@Field("token") String token,
                                     @Field("sessionId") int sessionId,
                                     @Field("productId") int productId,
                                     @Field("quantity") int quantity,
                                     @Field("size") String size);

    @FormUrlEncoded
    @POST("order/confirm_order")
    Call<RegisterResult> confirmOrder(@Field("token") String token,
                                                  @Field("sessionId") int sessionId,
                                                  @Field("provider") String provider,
                                                  @Field("phoneNumber") String phoneNumber,
                                                  @Field("address") String address,
                                                @Field("note") String note);
}

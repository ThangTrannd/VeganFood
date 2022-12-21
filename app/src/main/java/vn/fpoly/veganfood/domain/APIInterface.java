package vn.fpoly.veganfood.domain;

import com.google.gson.JsonObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import vn.fpoly.veganfood.model.home.Category;
import vn.fpoly.veganfood.model.login.LoginResponce;
import vn.fpoly.veganfood.model.login.RegisterData;
import vn.fpoly.veganfood.model.login.RegisterResponse;
import vn.fpoly.veganfood.model.product.Product;

public interface APIInterface {

    @Headers({
            "Accept: text/plain",
            "Content-Type: application/json-patch+json"
    })

    @POST("/users/register")
    Call<RegisterResponse> register(
            @Body JsonObject jwt
    );

    @POST("/users/login")
    Call<LoginResponce> login(
            @Body JsonObject jwt
    );

    @GET("/product/getproduct")
    Call<List<Product>> getProducts(
            @Header("Authorization") String dev_token
    );

    @GET("/category/getcategory")
    Call<List<Category>> getCategory(
            @Header("Authorization") String dev_token
    );

    @GET("/category/getcategory")
    Call<List<Category>> getUserInfo(
            @Header("Authorization") String dev_token
    );

    @GET("/category/getcategory")
    Call<List<Category>> updateUser(
            @Header("Authorization") String dev_token
    );




}

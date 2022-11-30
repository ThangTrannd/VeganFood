package vn.fpoly.veganfood.domain;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import vn.fpoly.veganfood.model.User;
import vn.fpoly.veganfood.model.login.LoginResponce;

public interface APIInterface {

    @Headers({
            "Accept: text/plain",
            "Content-Type: application/json-patch+json"
    })

    @POST("/auth/register")
    Call<User> register(
            @Body User user
    );

    @POST("/users/login")
    Call<LoginResponce> login(
            @Body JsonObject jsonObject
    );

}

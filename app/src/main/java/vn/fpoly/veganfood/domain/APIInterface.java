package vn.fpoly.veganfood.domain;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import vn.fpoly.veganfood.model.login.LoginResponce;
import vn.fpoly.veganfood.model.login.User;

public interface APIInterface {

    @Headers({
            "Accept: text/plain",
            "Content-Type: application/json-patch+json"
    })

    @POST("/users/register")
    Call<User> register(
            @Body JsonObject jwt
    );

    @POST("/users/login")
    Call<LoginResponce> login(
            @Body JsonObject jwt
    );

}

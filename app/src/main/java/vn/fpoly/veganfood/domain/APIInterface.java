package vn.fpoly.veganfood.domain;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import vn.fpoly.veganfood.model.User;
import vn.fpoly.veganfood.model.login.LoginData;
import vn.fpoly.veganfood.model.login.LoginResponse;

public interface APIInterface {

    @Headers({
            "Accept: text/plain",
            "Content-Type: application/json-patch+json"
    })

    @POST("/users/login")
    Call<LoginResponse> login(
            @Body LoginData loginData
    );

    Call<User> re(
            @Field("access_token") String access_token
    );

}

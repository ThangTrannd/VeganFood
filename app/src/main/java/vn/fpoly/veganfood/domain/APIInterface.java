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

public interface APIInterface {

    @FormUrlEncoded
    @POST("/auth/register")
    Call<User> register(
            @Field("email") String email,
            @Field("password") String password,
            @Field("userName") String userName
    );
    Call<User> login(
            @Field("access_token") String access_token
    );

}

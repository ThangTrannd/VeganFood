package vn.fpoly.veganfood.domain;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface APIInterface {
    @Headers({
            "Accept: text/plain",
            "Content-Type: application/json-patch+json"
    })
    @POST("/auth/register")
    Call<Data> getData(@Body JsonObject jwt);
}

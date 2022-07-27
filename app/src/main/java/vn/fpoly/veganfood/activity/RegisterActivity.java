package vn.fpoly.veganfood.activity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;

import com.google.gson.JsonObject;

import java.io.UnsupportedEncodingException;
import java.security.Key;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.spec.SecretKeySpec;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import vn.fpoly.veganfood.R;
import vn.fpoly.veganfood.domain.APIInterface;
import vn.fpoly.veganfood.domain.Data;
import vn.fpoly.veganfood.domain.Jdt;

public class RegisterActivity extends AppCompatActivity {
    String jwt = "";
    private AppCompatImageView logo;
    private EditText etUser;
    private EditText etPass;
    private EditText etRePass;
    private AppCompatButton btnRes;
    String content = "";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        System.out.println("jwt"+generateJwt());
        logo = findViewById(R.id.logo);
        etUser = findViewById(R.id.etUser);
        etPass = findViewById(R.id.etPass);
        etRePass = findViewById(R.id.etRePass);
        btnRes = findViewById(R.id.btnRes);
        btnRes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a = generateJwt();
                Retrofit retrofit = new Retrofit.Builder().baseUrl("https://dev-id.vplay.vn")
                        .addConverterFactory(GsonConverterFactory.create()).build();
                APIInterface APIInterface = retrofit.create(APIInterface.class);
                // chuyển jwt thành 1 jsonobject
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("jwt", a);
                //truyền đường link vào api và lấy ra 1 chuỗi string
                Call<Data> call = APIInterface.getData( jsonObject);
                call.enqueue(new Callback<Data>() {
                    @Override
                    public void onResponse(Call<Data> call, Response<Data> response) {
                        //content = response.body().getMessage();
                        Toast.makeText(RegisterActivity.this, "abc", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<Data> call, Throwable t) {
                        Toast.makeText(RegisterActivity.this, "Error", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }

    private String generateJwt(){

        Map<String, Object> clam = new HashMap();
        clam.put("email", "thang123@gmail.com");
        clam.put("password", "123456");
        clam.put("userName", "thang123");
        Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

        jwt = Jwts.builder().setHeaderParam("alg", "HS256").setHeaderParam("typ", "JWT").
                setClaims(clam).signWith(key).compact();
        return jwt;
    }
}
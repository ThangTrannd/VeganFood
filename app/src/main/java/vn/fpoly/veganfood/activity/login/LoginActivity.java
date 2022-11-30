package vn.fpoly.veganfood.activity.login;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;

import com.google.gson.JsonObject;

import java.security.Key;
import java.util.HashMap;
import java.util.Map;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import vn.fpoly.veganfood.R;
import vn.fpoly.veganfood.activity.main.MainActivity;
import vn.fpoly.veganfood.domain.APIInterface;
import vn.fpoly.veganfood.model.User;
import vn.fpoly.veganfood.model.login.LoginResponce;

public class LoginActivity extends AppCompatActivity {
    private EditText etUserName;
    private EditText etPassWord;
    private CheckBox chkRemember;
    private TextView tvForgot, tvRegister;
    private AppCompatButton btnLogin;
    private AppCompatImageView imgFb;
    private AppCompatImageView imgGg;
    private String access_token;
    private ImageView show_pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
    }

    private void initView() {
        etUserName = findViewById(R.id.etUserName);
        etPassWord = findViewById(R.id.etPassWord);
        chkRemember = findViewById(R.id.chkRemember);
        tvForgot = findViewById(R.id.tvForgot);
        tvRegister = findViewById(R.id.tvRegister);
        btnLogin = findViewById(R.id.btnLogin);
        imgFb = findViewById(R.id.imgFb);
        imgGg = findViewById(R.id.imgGg);
        show_pass = findViewById(R.id.show_pass);

        show_pass.setImageResource(R.drawable.hide);
        show_pass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (etPassWord.getTransformationMethod().equals(HideReturnsTransformationMethod.getInstance())) {
                    //if pass is visible then hide it
                    etPassWord.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    //change icon
                    show_pass.setImageResource(R.drawable.hide);
                } else {
                    etPassWord.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    show_pass.setImageResource(R.drawable.view);
                }
            }
        });

        tvForgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, ForgotPass.class));
            }
        });
        tvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            }
        });
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String passWord = etPassWord.getText().toString();
                String userName = etUserName.getText().toString();

                if (userName.isEmpty())
                    Toast.makeText(LoginActivity.this,
                            "Bạn cần nhập đầy đủ username",
                            Toast.LENGTH_SHORT).show();
                else if (passWord.isEmpty()) {
                    Toast.makeText(LoginActivity.this, "Bạn cần nhập đầy đủ password", Toast.LENGTH_SHORT).show();
                } else {
                    Retrofit retrofit = new Retrofit.Builder().baseUrl("  ")
                            .addConverterFactory(GsonConverterFactory.create()).build();
                    APIInterface apiInterface = retrofit.create(APIInterface.class);
                    JsonObject jsonObject = new JsonObject();
                    jsonObject.addProperty("username", userName);
                    jsonObject.addProperty("password", passWord);
                    System.out.println(jsonObject);
                    Call<LoginResponce> call = apiInterface.login(jsonObject);
                    call.enqueue(new Callback<LoginResponce>() {
                        @Override
                        public void onResponse(Call<LoginResponce> call, Response<LoginResponce> response) {
                            System.out.println(response.body());
                            if (response.code() == 200){
                                startActivity(new Intent(LoginActivity.this, MainActivity.class));
                            }
                            else{
                                Toast.makeText(LoginActivity.this, "Bạn nhập sai tài khoản hoặc mật khẩu ", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<LoginResponce> call, Throwable t) {
                            Log.e("Thangtran",t.toString());
                        }
                    });
                }
            }
        });

    }

}
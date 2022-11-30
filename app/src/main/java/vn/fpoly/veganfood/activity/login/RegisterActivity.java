package vn.fpoly.veganfood.activity.login;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.google.gson.JsonObject;

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

public class RegisterActivity extends AppCompatActivity {

    private EditText edtUserName;
    private EditText edtPassword;
    private EditText edtEmail;
    private AppCompatButton btnResgister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initView();
    }
    private void initView(){
        edtUserName = findViewById(R.id.edtUserName);
        edtPassword = findViewById(R.id.edtPassword);
        edtEmail = findViewById(R.id.edtEmail);
        btnResgister = findViewById(R.id.btnResgister);
        btnResgister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Retrofit retrofit = new Retrofit.Builder().baseUrl("https://demofoods.herokuapp.com")
//                        .addConverterFactory(GsonConverterFactory.create()).build();
//                APIInterface apiInterface = retrofit.create(APIInterface.class);
//                JsonObject jsonObject = new JsonObject();
//                jsonObject.addProperty("username", userName);
//                jsonObject.addProperty("password", passWord);
//                System.out.println(jsonObject);
//                Call<LoginResponce> call = apiInterface.login(jsonObject);
//                call.enqueue(new Callback<LoginResponce>() {
//                    @Override
//                    public void onResponse(Call<LoginResponce> call, Response<LoginResponce> response) {
//                        System.out.println(response);
//                        if (response.code() == 200){
//                            startActivity(new Intent(LoginActivity.this, MainActivity.class));
//                        }
//                        else{
//                            Toast.makeText(LoginActivity.this, "Bạn nhập sai tài khoản hoặc mật khẩu ", Toast.LENGTH_SHORT).show();
//                        }
//                    }
//
//                    @Override
//                    public void onFailure(Call<LoginResponce> call, Throwable t) {
//                        Log.e("Thangtran",t.toString());
//                    }
//                });
//
//                if (userName.isEmpty())
//                    Toast.makeText(RegisterActivity.this, "Bạn cần nhập đầy đủ username", Toast.LENGTH_SHORT).show();
//                else if (passWord.isEmpty())
//                    Toast.makeText(RegisterActivity.this, "Bạn cần nhập đầy đủ password", Toast.LENGTH_SHORT).show();
//                else{
//                    Toast.makeText(RegisterActivity.this, "success", Toast.LENGTH_SHORT).show();
//                    startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
//                }
//            }
            }
        });
    }
}
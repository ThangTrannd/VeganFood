package vn.fpoly.veganfood.activity.login;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import vn.fpoly.veganfood.R;
import vn.fpoly.veganfood.activity.main.MainActivity;
import vn.fpoly.veganfood.domain.APIInterface;
import vn.fpoly.veganfood.model.login.LoginResponce;
import vn.fpoly.veganfood.model.login.RegisterResponse;

public class ActivityRegister extends AppCompatActivity{
    private EditText edtUserName;
    private EditText edtPassword;
    private EditText edtPhone;
    private EditText edtAddress;
    private ImageView showPas;
    private EditText edtEmail;
    private AppCompatButton btnResgister;
    SharedPreferences shaPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        shaPref = getApplicationContext().getSharedPreferences("Sharef", Context.MODE_PRIVATE);
        initView();
        initListener();
    }
    private void initView(){
        edtUserName = (EditText) findViewById(R.id.edtUserName);
        edtPassword = (EditText) findViewById(R.id.edtPassword);
        showPas = (ImageView) findViewById(R.id.show_pas);
        edtEmail = (EditText) findViewById(R.id.edtEmail);
        edtPhone = (EditText) findViewById(R.id.edtPhone);
        edtAddress = (EditText) findViewById(R.id.edtAddress);
        btnResgister = (AppCompatButton) findViewById(R.id.btnResgister);
    }
    private void initListener(){
        btnResgister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edtEmail.getText().toString().isEmpty() || edtPassword.getText().toString().isEmpty() || edtUserName.getText().toString().isEmpty()
                    || edtPhone.getText().toString().isEmpty() || edtAddress.getText().toString().isEmpty()){
                    Toast.makeText(ActivityRegister.this, "Bạn cần nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                }
                else{
                    Retrofit retrofit = new Retrofit.Builder().baseUrl("https://demoapishop.up.railway.app")
                            .addConverterFactory(GsonConverterFactory.create()).build();
                    APIInterface jsonHolderApi = retrofit.create(APIInterface.class);
                    JsonObject jsonObject = new JsonObject();
                    jsonObject.addProperty("id", 1);
                    jsonObject.addProperty("username", edtUserName.getText().toString());
                    jsonObject.addProperty("password", edtPassword.getText().toString());
                    jsonObject.addProperty("phone", edtPhone.getText().toString());
                    jsonObject.addProperty("email", edtEmail.getText().toString());
                    jsonObject.addProperty("avatar", "");
                    jsonObject.addProperty("dateuser", "");
                    jsonObject.addProperty("address", edtAddress.getText().toString());
                    Call<RegisterResponse> call = jsonHolderApi.register(jsonObject);
                    call.enqueue(new Callback<RegisterResponse>() {
                        @Override
                        public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {
                            if (response.code() == 200){
                                Toast.makeText(ActivityRegister.this, "Bạn đã đăng kí thành công", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(ActivityRegister.this,ActivityLogin.class));
                                finish();
                            }
                            else {
                                Toast.makeText(ActivityRegister.this, "Bạn tạo tài khoản không thành công", Toast.LENGTH_SHORT).show();
                            }

                        }

                        @Override
                        public void onFailure(Call<RegisterResponse> call, Throwable t) {
                            System.out.println(t);
                        }
                    });
                }
            }
        });

    }

}
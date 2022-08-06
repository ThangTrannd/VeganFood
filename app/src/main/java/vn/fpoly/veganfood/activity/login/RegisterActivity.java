package vn.fpoly.veganfood.activity.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import vn.fpoly.veganfood.R;
import vn.fpoly.veganfood.activity.main.MainActivity;
import vn.fpoly.veganfood.domain.APIInterface;
import vn.fpoly.veganfood.model.User;

public class RegisterActivity extends AppCompatActivity {

    private EditText edtUserName;
    private EditText edtPassword;
    private EditText edtEmail;
    private AppCompatButton btnResgister;

    String jwt = "";

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
                Retrofit retrofit = new Retrofit.Builder().baseUrl(getString(R.string.domain))
                        .addConverterFactory(GsonConverterFactory.create()).build();
                APIInterface APIInterface = retrofit.create(APIInterface.class);
                String email = edtEmail.getText().toString();
                String passWord = edtPassword.getText().toString();
                String userName = edtUserName.getText().toString();

                if (userName.isEmpty())
                    Toast.makeText(RegisterActivity.this, "Bạn cần nhập đầy đủ username", Toast.LENGTH_SHORT).show();
                else if (passWord.isEmpty())
                    Toast.makeText(RegisterActivity.this, "Bạn cần nhập đầy đủ password", Toast.LENGTH_SHORT).show();
                else{
                    Toast.makeText(RegisterActivity.this, "success", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
//                    Call<User> call = APIInterface.register(email,passWord,userName);
//                    call.enqueue(new Callback<User>() {
//                        @Override
//                        public void onResponse(Call<User> call, Response<User> response) {
//                            Toast.makeText(RegisterActivity.this, "Đăng kí thành công", Toast.LENGTH_SHORT).show();
//                            startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
//                        }
//
//                        @Override
//                        public void onFailure(Call<User> call, Throwable t) {
//                            Toast.makeText(RegisterActivity.this, "Error", Toast.LENGTH_SHORT).show();
//                        }
//                    });
                }
            }
        });
    }
}
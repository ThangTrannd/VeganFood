package vn.fpoly.veganfood.activity.login;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
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
import vn.fpoly.veganfood.R;
import vn.fpoly.veganfood.activity.main.MainActivity;
import vn.fpoly.veganfood.domain.APIInterface;
import vn.fpoly.veganfood.model.User;

public class LoginActivity extends AppCompatActivity {
    private EditText etUserName;
    private EditText etPassWord;
    private CheckBox chkRemember;
    private TextView tvForgot,tvRegister;
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
    private void initView(){
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
                if(etPassWord.getTransformationMethod().equals(HideReturnsTransformationMethod.getInstance())) {
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
                startActivity(new Intent(LoginActivity.this,ForgotPass.class));
            }
        });
        tvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
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
                }
                else{
                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
//                JsonObject jsonObject = new JsonObject();
//                jsonObject.addProperty("access_token", generateJwt());
//                System.out.println("access_token :"+jsonObject);
//                Call<User> call = APIInterface.login();
//                call.enqueue(new Callback<User>() {
//                    @Override
//                    public void onResponse(Call<User> call, Response<User> response) {
//                        Toast.makeText(LoginActivity.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
//
//                    }
//
//                    @Override
//                    public void onFailure(Call<User> call, Throwable t) {
//                        Toast.makeText(LoginActivity.this, "Error", Toast.LENGTH_SHORT).show();
//                    }
//                });
                }





            }
        });

    }

    private String generateJwt() {

        String passWord = etPassWord.getText().toString();
        String userName = etUserName.getText().toString();

        Map<String, Object> clam = new HashMap<>();
        clam.put("password", passWord);
        clam.put("userName", userName);
        Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
        access_token = Jwts.builder().setHeaderParam("alg", "HS256").setHeaderParam("typ", "JWT").
                setClaims(clam).signWith(key).compact();
        return access_token;

    }


}
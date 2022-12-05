package vn.fpoly.veganfood.activity.login;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import vn.fpoly.veganfood.R;

public class ActivityLogin extends AppCompatActivity{
 LoginButton imgFb;
  private CallbackManager callbackManager;
    private LoginManager loginManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        initView();
        initListener();

    }
    private void initView(){
        imgFb= findViewById(R.id.imgFb);
   callbackManager = CallbackManager.Factory.create();

    }

    private  void initListener() {
//        imgFb.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
//            @Override
//            public void onSuccess(LoginResult loginResult) {
//                Toast.makeText(getApplicationContext(), "Dawng nhap thanh cong", Toast.LENGTH_LONG).show();
//            }
//
//            @Override
//            public void onCancel() {
//
//            }
//
//            @Override
//            public void onError(@NonNull FacebookException error) {
//               Toast.makeText(getApplicationContext(),error.getMessage(),Toast.LENGTH_LONG).show();
//            }
//        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }
}
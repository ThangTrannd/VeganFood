package vn.fpoly.veganfood.activity;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;

import vn.fpoly.veganfood.R;

public class LoginActivity extends AppCompatActivity {
    private EditText etUserName;
    private EditText etPassWord;
    private CheckBox chkRemember;
    private TextView tvPorgot;
    private AppCompatButton btnRes;
    private AppCompatImageView imgFb;
    private AppCompatImageView imgGg;

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
        tvPorgot = findViewById(R.id.tvPorgot);
        btnRes = findViewById(R.id.btnRes);
        imgFb = findViewById(R.id.imgFb);
        imgGg = findViewById(R.id.imgGg);
    }
}
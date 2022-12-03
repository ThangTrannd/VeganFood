package vn.fpoly.veganfood.activity.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import vn.fpoly.veganfood.R;
import vn.fpoly.veganfood.activity.main.MainActivity;
import vn.fpoly.veganfood.activity.main.ProfileFragment;

public class ResetPassActivity extends AppCompatActivity {
   private Button btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_pass);

        btnBack = findViewById(R.id.btnBack);

        initListener();
    }

    private void initListener() {
       btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ResetPassActivity.this, MainActivity.class));
                finish();
            }
        });
    }
}
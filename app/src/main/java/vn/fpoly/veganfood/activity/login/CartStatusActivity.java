package vn.fpoly.veganfood.activity.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import vn.fpoly.veganfood.R;
import vn.fpoly.veganfood.activity.main.MainActivity;

public class CartStatusActivity extends AppCompatActivity {
  private TextView tv_Undo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_status);

        tv_Undo = findViewById(R.id.tv_Undo);
        initListener();
    }

    private void initListener() {
        tv_Undo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CartStatusActivity.this, MainActivity .class));
                finish();
            }
        });
    }
}
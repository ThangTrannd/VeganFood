package vn.fpoly.veganfood.activity.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import vn.fpoly.veganfood.R;
import vn.fpoly.veganfood.activity.main.MainActivity;

public class ProductDetailActivity extends AppCompatActivity {
    private ImageView ivBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_product_details);

        ivBack = findViewById(R.id.ivBack);
        initListener();
    }

    private void initListener() {
        startActivity(new Intent(ProductDetailActivity.this, MainActivity.class));
        finish();
    }
}
package vn.fpoly.veganfood.activity.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import vn.fpoly.veganfood.R;
import vn.fpoly.veganfood.activity.main.MainActivity;

public class ProductActivity extends AppCompatActivity {
    private ImageView ivBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_list_product);

        ivBack = findViewById(R.id.ivBack);
        initListener();
    }

    private void initListener(){
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ProductActivity.this, MainActivity.class));
                finish();
            }
        });
    }

}
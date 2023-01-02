package vn.fpoly.veganfood.feature.order;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import vn.fpoly.veganfood.R;
import vn.fpoly.veganfood.feature.orderStatus.OrderStatusActivity;
import vn.fpoly.veganfood.home.activityhome.HomeActivity;
import vn.fpoly.veganfood.model.ProductSessionModel;

public class ConfirmSuccessOrderActivty extends AppCompatActivity {

    Button btnflow, btnBackHome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_success_order_activty);
        btnflow = findViewById(R.id.btn_flow);
        btnBackHome = findViewById(R.id.btn_back_home);

        btnflow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), OrderStatusActivity.class);
                startActivity(i);
                finish();
            }
        });
        btnBackHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), HomeActivity.class);
                startActivity(i);
                finish();
            }
        });
    }
}
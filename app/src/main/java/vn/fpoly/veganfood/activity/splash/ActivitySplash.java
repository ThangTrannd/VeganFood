package vn.fpoly.veganfood.activity.splash;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;

import vn.fpoly.veganfood.R;

public class ActivitySplash extends AppCompatActivity {
    TextView tvHello;
    LottieAnimationView lottie;
    ImageView img_Logo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        tvHello = findViewById(R.id.tvHello);
        lottie = findViewById(R.id.lottie);
        img_Logo = findViewById(R.id.img_Logo);

        tvHello.animate().translationY(-400).setDuration(2700).setStartDelay(0);
        lottie.animate().translationX(2000).setDuration(2000).setStartDelay(2900);
//        img_Logo.animate().translationY(400).setDuration(2000).setStartDelay(2900);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(getApplicationContext(), ActivitySplashNewBie.class));
                finish();
            }
        },5000);
    }
}
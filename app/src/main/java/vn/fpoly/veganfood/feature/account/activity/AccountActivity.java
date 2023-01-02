package vn.fpoly.veganfood.feature.account.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import vn.fpoly.veganfood.databinding.ActivityAccountBinding;


public class AccountActivity extends AppCompatActivity {
    private ActivityAccountBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAccountBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}
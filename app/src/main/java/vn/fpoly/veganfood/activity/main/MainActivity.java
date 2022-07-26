package vn.fpoly.veganfood.activity.main;

import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import vn.fpoly.veganfood.R;
import vn.fpoly.veganfood.activity.home.FragmentHome;
import vn.fpoly.veganfood.activity.product.FragmentProduct;
import vn.fpoly.veganfood.activity.profile.FragmentProfile;
import vn.fpoly.veganfood.activity.shoppingcard.FragmentShopping;

public class MainActivity extends AppCompatActivity{
    private BottomNavigationView bottomNav;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        statusBarColor();

    }
    private void initView(){
        bottomNav = findViewById(R.id.bottomNav);
        setUpBottomNavigation();
    }
    private void setUpBottomNavigation(){
        FragmentHome fragmentHome = new FragmentHome();
        FragmentProduct fragmentProduct = new FragmentProduct();
        FragmentProfile fragmentProfile = new FragmentProfile();
        FragmentShopping fragmentShopping = new FragmentShopping();
        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragmentHome).commit();
        bottomNav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.home:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragmentHome).commit();
                        return true;

                    case R.id.favourite:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragmentProduct).commit();
                        return true;

                    case R.id.profile:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragmentProfile).commit();
                        return true;

                    case R.id.shopping:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragmentShopping).commit();
                        return true;
                }
                return false;
            }
        });
    }

    private void statusBarColor(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.green,this.getTheme()));
        } else  if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.green));
        }
    }

}
package vn.fpoly.veganfood.activity.main;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import vn.fpoly.veganfood.R;

public class MainActivity extends AppCompatActivity{
    private BottomNavigationView bottomNav;
    private AppCompatImageView ivMenu;
    private AppCompatImageView ivNotify;
    private AppCompatTextView tvTitle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        ivMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        ivNotify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
    private void initView(){
        bottomNav = findViewById(R.id.bottomNav);
        ivMenu = findViewById(R.id.ivMenu);
        ivNotify = findViewById(R.id.ivNotify);
        tvTitle = findViewById(R.id.tvTitle);
        setUpBottomNavigation();
    }
    private void setUpBottomNavigation(){
        HomeFragment homeFragment = new HomeFragment();
        FavouriteFragment favouriteFragment = new FavouriteFragment();
        ProfileFragment profileFragment = new ProfileFragment();
        ShoppingFragment shoppingFragment = new ShoppingFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.container,homeFragment).commit();
        bottomNav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.home:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, homeFragment).commit();
                        tvTitle.setText("Product");
                        return true;

                    case R.id.favourite:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, favouriteFragment).commit();
                        tvTitle.setText("Favourite");
                        return true;

                    case R.id.profile:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, profileFragment).commit();
                        tvTitle.setText("Profile");
                        return true;

                    case R.id.shopping:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, shoppingFragment).commit();
                        tvTitle.setText("Shopping");
                        return true;
                }
                return false;
            }
        });
    }

}
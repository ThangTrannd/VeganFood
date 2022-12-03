package vn.fpoly.veganfood.activity.main;

import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import vn.fpoly.veganfood.R;
<<<<<<< Updated upstream
import vn.fpoly.veganfood.activity.favourite.FavouriteFragment;
import vn.fpoly.veganfood.activity.home.HomeFragment;
import vn.fpoly.veganfood.activity.profile.ProfileFragment;
import vn.fpoly.veganfood.activity.shoppingcard.ShoppingFragment;
=======
import vn.fpoly.veganfood.activity.favourite.FragmentFavourite;
import vn.fpoly.veganfood.activity.home.FragmentHome;
import vn.fpoly.veganfood.activity.profile.FragmentProfile;
import vn.fpoly.veganfood.activity.shoppingcard.FragmentShopping;
>>>>>>> Stashed changes

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
<<<<<<< Updated upstream
        HomeFragment homeFragment = new HomeFragment();
        FavouriteFragment favouriteFragment = new FavouriteFragment();
        ProfileFragment profileFragment = new ProfileFragment();
        ShoppingFragment shoppingFragment = new ShoppingFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.container,homeFragment).commit();
=======
        FragmentHome fragmentHome = new FragmentHome();
        FragmentFavourite fragmentFavourite = new FragmentFavourite();
        FragmentProfile fragmentProfile = new FragmentProfile();
        FragmentShopping fragmentShopping = new FragmentShopping();
        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragmentHome).commit();
>>>>>>> Stashed changes
        bottomNav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.home:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, homeFragment).commit();
                        return true;

                    case R.id.favourite:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragmentFavourite).commit();
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
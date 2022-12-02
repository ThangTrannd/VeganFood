package vn.fpoly.veganfood.activity.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import vn.fpoly.veganfood.R;
import vn.fpoly.veganfood.activity.login.CategoryActivity;
import vn.fpoly.veganfood.activity.login.LoginActivity;
import vn.fpoly.veganfood.activity.login.ProductActivity;
import vn.fpoly.veganfood.activity.login.ProductDetailActivity;
import vn.fpoly.veganfood.activity.login.ProductFilterActivity;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {
   private ConstraintLayout constrantLayoutEndown1;

   private AppCompatTextView tv_All,tv_All2;
   private AppCompatImageView ivButton_add, ivFilter;
    public HomeFragment() {
        // Required empty public constructor
    }


    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        constrantLayoutEndown1 = view.findViewById(R.id.constrantLayoutEndown1);
        tv_All = view.findViewById(R.id.tvAll);
        tv_All2 = view.findViewById(R.id.tvAll2);
        ivButton_add = view.findViewById(R.id.ivButton_add);
        ivFilter = view.findViewById(R.id.ivFilter);
        initListener();
    }

    private void initUI() {

    }

    private void initListener() {
        constrantLayoutEndown1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), ProductDetailActivity.class));
            }
        });

        tv_All.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), CategoryActivity.class));

            }
        });

        tv_All2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), ProductActivity.class));

            }
        });

        ivButton_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), LoginActivity.class));
            }
        });

        ivFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), ProductFilterActivity.class));
            }
        });
    }

}
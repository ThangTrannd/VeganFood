package vn.fpoly.veganfood.activity.product;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.Fragment;

import vn.fpoly.veganfood.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentProduct#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentProduct extends Fragment {

    private AppCompatImageView ivBack;

    public FragmentProduct() {
        // Required empty public constructor
    }

    public static FragmentProduct newInstance(String param1, String param2) {
        FragmentProduct fragment = new FragmentProduct();
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
        return inflater.inflate(R.layout.fragment_product, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
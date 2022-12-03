package vn.fpoly.veganfood.activity.shoppingcard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import vn.fpoly.veganfood.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentShopping#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentShopping extends Fragment {

    public FragmentShopping() {
        // Required empty public constructor
    }

    public static FragmentShopping newInstance(String param1, String param2) {
        FragmentShopping fragment = new FragmentShopping();
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
        return inflater.inflate(R.layout.fragment_shopping, container, false);
    }
}
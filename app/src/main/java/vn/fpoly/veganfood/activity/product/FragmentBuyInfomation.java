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
 * Use the {@link FragmentBuyInfomation#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentBuyInfomation extends Fragment {

    private AppCompatImageView ivBack;

    public FragmentBuyInfomation() {
        // Required empty public constructor
    }

    public static FragmentBuyInfomation newInstance(String param1, String param2) {
        FragmentBuyInfomation fragment = new FragmentBuyInfomation();
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
        return inflater.inflate(R.layout.fragment_endbuy, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
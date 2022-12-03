package vn.fpoly.veganfood.activity.profile;

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
 * Use the {@link FragmentAboutUs#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentAboutUs extends Fragment {

    private AppCompatImageView ivBack;

    public FragmentAboutUs() {
        // Required empty public constructor
    }

    public static FragmentAboutUs newInstance(String param1, String param2) {
        FragmentAboutUs fragment = new FragmentAboutUs();
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
        return inflater.inflate(R.layout.fragment_about_us, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ivBack = view.findViewById(R.id.iv_Back);
        FragmentProfile fragmentProfile = new FragmentProfile();
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, fragmentProfile).commit();
            }
        });
    }
}
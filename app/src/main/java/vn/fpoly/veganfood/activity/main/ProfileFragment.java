package vn.fpoly.veganfood.activity.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import vn.fpoly.veganfood.R;
import vn.fpoly.veganfood.activity.profile.AboutUsFragment;
import vn.fpoly.veganfood.activity.profile.LogoutFragment;
import vn.fpoly.veganfood.activity.profile.SignOutFragment;
import vn.fpoly.veganfood.activity.profile.UserInfoFragment;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProfileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProfileFragment extends Fragment {

    private ImageView ivAvatar;
    private ConstraintLayout user_info,change_pass,about_us,history,logout,signout;
    private TextView tv_profile;

    public ProfileFragment() {
        // Required empty public constructor
    }

    public static ProfileFragment newInstance(String param1, String param2) {
        ProfileFragment fragment = new ProfileFragment();
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
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ivAvatar = view.findViewById(R.id.ivAvatar);
        user_info = view.findViewById(R.id.user_info);
        change_pass = view.findViewById(R.id.change_pass);
        about_us = view.findViewById(R.id.about_us);
        history = view.findViewById(R.id.history);
        logout = view.findViewById(R.id.logout);
        signout = view.findViewById(R.id.signout);
        AboutUsFragment aboutUsFragment = new AboutUsFragment();
        UserInfoFragment userInfoFragment = new UserInfoFragment();
        SignOutFragment signOutFragment = new SignOutFragment();
        LogoutFragment logoutFragment = new LogoutFragment();
        ivAvatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        user_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container,userInfoFragment).commit();
            }
        });
        change_pass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        about_us.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container,aboutUsFragment).commit();
            }
        });
        history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction().add(R.id.container,logoutFragment).commit();
            }
        });
        signout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction().add(R.id.container,signOutFragment).commit();
            }
        });
    }
}
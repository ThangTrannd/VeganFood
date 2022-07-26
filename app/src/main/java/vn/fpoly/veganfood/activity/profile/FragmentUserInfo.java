package vn.fpoly.veganfood.activity.profile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.Fragment;

import vn.fpoly.veganfood.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentUserInfo#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentUserInfo extends Fragment {

    private AppCompatImageView ivBack,ivAvatarUser;
    private EditText tvUsername,tvPhone,tvEmail;
    private Button btnSave;
    public FragmentUserInfo() {
        // Required empty public constructor
    }

    public static FragmentUserInfo newInstance(String param1, String param2) {
        FragmentUserInfo fragment = new FragmentUserInfo();
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
        return inflater.inflate(R.layout.fragment_user_info, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ivBack = view.findViewById(R.id.iv_Back);
        ivAvatarUser = view.findViewById(R.id.iv_avatar_user);
        tvUsername = view.findViewById(R.id.tv_username);
        tvPhone = view.findViewById(R.id.tv_phone);
        tvEmail = view.findViewById(R.id.tv_email);
        btnSave = view.findViewById(R.id.btnSave);
        FragmentProfile fragmentProfile = new FragmentProfile();
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, fragmentProfile).commit();
            }
        });
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, fragmentProfile).commit();
            }
        });
    }
}
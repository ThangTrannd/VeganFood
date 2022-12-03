package vn.fpoly.veganfood.activity.profile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;

import vn.fpoly.veganfood.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LogoutFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LogoutFragment extends Fragment {

    private AppCompatButton btnCancel;
    private AppCompatButton btnOK;




    public LogoutFragment() {
        // Required empty public constructor
    }

    public static LogoutFragment newInstance(String param1, String param2) {
        LogoutFragment fragment = new LogoutFragment();
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
        return inflater.inflate(R.layout.logout_dialog, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btnCancel = view.findViewById(R.id.btnCancel);
        btnOK = view.findViewById(R.id.btnOK);
        ProfileFragment profileFragment = new ProfileFragment();
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container,profileFragment).commit();

            }
        });
        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().finish();
            }
        });
    }
}
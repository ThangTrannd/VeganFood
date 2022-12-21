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
import vn.fpoly.veganfood.activity.home.FragmentHome;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentSignOut#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentSignOut extends Fragment {

    private AppCompatButton btnCancel;
    private AppCompatButton btnOK;

    public FragmentSignOut() {
        // Required empty public constructor
    }

    public static FragmentSignOut newInstance(String param1, String param2) {
        FragmentSignOut fragment = new FragmentSignOut();
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
        return inflater.inflate(R.layout.signout_dialog, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btnCancel = view.findViewById(R.id.buttonNo);
        btnOK = view.findViewById(R.id.buttonYes);
        FragmentProfile fragmentProfile = new FragmentProfile();
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, fragmentProfile).commit();

            }
        });
        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentHome fragmentHome = new FragmentHome();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container,fragmentHome).commit();
            }
        });
    }
}
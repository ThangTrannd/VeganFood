package vn.fpoly.veganfood.activity.notification;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import vn.fpoly.veganfood.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentNotify#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentNotify extends Fragment {


    public FragmentNotify() {
        // Required empty public constructor
    }


    public static FragmentNotify newInstance(String param1, String param2) {
        FragmentNotify fragment = new FragmentNotify();
        Bundle args = new Bundle();

        fragment.setArguments(args);
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
        return inflater.inflate(R.layout.fragment_notify, container, false);
    }
}
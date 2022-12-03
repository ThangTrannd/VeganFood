package vn.fpoly.veganfood.activity.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import vn.fpoly.veganfood.R;
/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    private ImageView ivSearch;
    private TextView tvShowCategory;
    private TextView tvShowEndow;
    private TextView tvShowEndow1;

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

        initUI(view);
        initListener();
    }

    private void initUI(View view) {
        ivSearch = view.findViewById(R.id.iv_search);
        tvShowCategory = view.findViewById(R.id.tv_showCategory);
        tvShowEndow = view.findViewById(R.id.tv_showEndow);
        tvShowEndow1 = view.findViewById(R.id.tv_showEndow1);
    }

    private void initListener() {

    }

}
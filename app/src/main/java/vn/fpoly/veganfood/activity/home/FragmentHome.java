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
import androidx.recyclerview.widget.RecyclerView;

import vn.fpoly.veganfood.R;
/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentHome#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentHome extends Fragment {

    private ImageView ivSearch;
    private TextView tvShowCategory;
    private TextView tvShowEndow;
    private TextView tvShowEndow1;
    private RecyclerView rcvCategory;
    private RecyclerView rcvEndow;
    private RecyclerView rcvEndow1;

    

    public FragmentHome() {
        // Required empty public constructor
    }


    public static FragmentHome newInstance(String param1, String param2) {
        FragmentHome fragment = new FragmentHome();
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
        rcvCategory = view.findViewById(R.id.rcv_category);
        rcvEndow = view.findViewById(R.id.rcv_endow);
        rcvEndow1 = view.findViewById(R.id.rcv_endow1);
    }

    private void initListener() {
        ivSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentSearch fragmentSearch = new FragmentSearch();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container,fragmentSearch).commit();
            }
        });
        tvShowCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentCategory fragmentCategory = new FragmentCategory();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container,fragmentCategory).commit();
            }
        });
        tvShowEndow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container,aboutUsFragment).commit();
            }
        });
        tvShowEndow1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container,aboutUsFragment).commit();
            }
        });
    }

}
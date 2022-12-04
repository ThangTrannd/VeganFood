package vn.fpoly.veganfood.activity.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import vn.fpoly.veganfood.R;
import vn.fpoly.veganfood.activity.home.adapter.CategoryAdapter;
import vn.fpoly.veganfood.activity.home.adapter.ListProductAdapter;
import vn.fpoly.veganfood.activity.product.FragmentProduct;
import vn.fpoly.veganfood.model.home.Category;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentCategory#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentCategory extends Fragment {

    private ImageView ivBack;
    private ImageView ivSearch;
    private RecyclerView rcv;
    private List<Category> listCate = new ArrayList<>();
    private CategoryAdapter categoryAdapter;

    public FragmentCategory() {
        // Required empty public constructor
    }

    public static FragmentCategory newInstance(String param1, String param2) {
        FragmentCategory fragment = new FragmentCategory();
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
        return inflater.inflate(R.layout.fragment_category, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        createListCate();
        ivBack = view.findViewById(R.id.iv_back);
        ivSearch = view.findViewById(R.id.iv_search);
        rcv = view.findViewById(R.id.rcv);
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentHome fragmentHome = new FragmentHome();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container,fragmentHome).commit();
            }
        });
        ivSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("Đang làm");
            }
        });
        categoryAdapter = new CategoryAdapter(listCate);
        rcv.setLayoutManager(new GridLayoutManager(requireContext(),3));
        rcv.setAdapter(categoryAdapter);
        categoryAdapter.setOnItemClickListener(new CategoryAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                FragmentProduct fragmentProduct = new FragmentProduct();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container,fragmentProduct).commit();
            }
        });
    }
    private List createListCate(){
        listCate.add(new Category(R.drawable.img_1,"Gà quay"));
        listCate.add(new Category(R.drawable.img_1,"Gà quay"));
        listCate.add(new Category(R.drawable.img_1,"Gà quay"));
        listCate.add(new Category(R.drawable.img_1,"Gà quay"));
        listCate.add(new Category(R.drawable.img_1,"Gà quay"));
        return listCate;
    }
}
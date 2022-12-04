package vn.fpoly.veganfood.activity.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import vn.fpoly.veganfood.R;
import vn.fpoly.veganfood.activity.home.adapter.CategoryAdapter;
import vn.fpoly.veganfood.activity.home.adapter.EndowAdapter;
import vn.fpoly.veganfood.activity.home.adapter.ListProductAdapter;
import vn.fpoly.veganfood.activity.product.FragmentProduct;
import vn.fpoly.veganfood.activity.product.FragmentProductDetail;
import vn.fpoly.veganfood.model.home.Category;
import vn.fpoly.veganfood.model.home.Endow;
import vn.fpoly.veganfood.model.product.Product;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentHome#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentHome extends Fragment {

    private ImageView ivSearch;
    private TextView tvShowCategory;
    private TextView tvShowEndow;
    private TextView tvProducts;
    private RecyclerView rcvCategory;
    private RecyclerView rcvEndow;
    private RecyclerView rcvEndow1;
    private CategoryAdapter categoryAdapter;
    private EndowAdapter endowAdapter;
    private ListProductAdapter listProductAdapter;
    private List<Category> listCate = new ArrayList<>();
    private List<Endow> listEndow = new ArrayList<>();
    private List<Product> listProduct = new ArrayList<>();

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
        createListCate();
        createListEndow();
        createListProduct();
        ivSearch = view.findViewById(R.id.iv_search);
        tvShowCategory = view.findViewById(R.id.tv_showCategory);
        tvShowEndow = view.findViewById(R.id.tv_showEndow);
        tvProducts = view.findViewById(R.id.tv_showEndow1);
        rcvCategory = view.findViewById(R.id.rcv_category);
        rcvEndow = view.findViewById(R.id.rcv_endow);
        rcvEndow1 = view.findViewById(R.id.rcv_endow1);
        categoryAdapter = new CategoryAdapter(listCate);
        endowAdapter = new EndowAdapter(listEndow);
        listProductAdapter = new ListProductAdapter(listProduct);
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
        tvProducts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentProduct fragmentProduct = new FragmentProduct();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container,fragmentProduct).commit();
            }
        });

        rcvCategory.setLayoutManager(new LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false));
        rcvEndow.setLayoutManager(new LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false));
        rcvEndow1.setLayoutManager(new LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false));
        rcvCategory.setAdapter(categoryAdapter);
        rcvEndow.setAdapter(endowAdapter);
        rcvEndow1.setAdapter(listProductAdapter);

        categoryAdapter.setOnItemClickListener(new CategoryAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                FragmentProduct fragmentProduct = new FragmentProduct();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container,fragmentProduct).commit();
            }
        });
        listProductAdapter.setOnItemClickAddListener(new ListProductAdapter.OnItemClickAddListener() {
            @Override
            public void onItemClickAdd(int position) {
                Toast.makeText(requireContext(), position, Toast.LENGTH_SHORT).show();
            }
        });
        listProductAdapter.setOnItemClickListener(new ListProductAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                FragmentProductDetail fragmentProductDetail = new FragmentProductDetail();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container,fragmentProductDetail).commit();
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
    private List createListEndow(){
        listEndow.add(new Endow(R.drawable.img_3));
        listEndow.add(new Endow(R.drawable.img_3));
        listEndow.add(new Endow(R.drawable.img_3));
        listEndow.add(new Endow(R.drawable.img_3));
        listEndow.add(new Endow(R.drawable.img_3));
        listEndow.add(new Endow(R.drawable.img_3));
        return listEndow;
    }
    private List createListProduct(){
        listProduct.add(new Product(R.drawable.img,"Gà quay",32,32000));
        listProduct.add(new Product(R.drawable.img,"Gà quay",32,32000));
        listProduct.add(new Product(R.drawable.img,"Gà quay",32,32000));
        listProduct.add(new Product(R.drawable.img,"Gà quay",32,32000));
        listProduct.add(new Product(R.drawable.img,"Gà quay",32,32000));
        return listProduct;
    }

}
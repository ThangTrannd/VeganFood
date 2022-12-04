package vn.fpoly.veganfood.activity.product;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import vn.fpoly.veganfood.R;
import vn.fpoly.veganfood.activity.home.FragmentHome;
import vn.fpoly.veganfood.activity.home.adapter.CategoryAdapter;
import vn.fpoly.veganfood.activity.home.adapter.ListProductAdapter;
import vn.fpoly.veganfood.model.home.Category;
import vn.fpoly.veganfood.model.product.Product;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentProduct#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentProduct extends Fragment {

    private ImageView ivBack;
    private ImageView ivSearch;
    private RecyclerView rcv;
    private List<Product> listProduct = new ArrayList<>();
    private ListProductAdapter listProductAdapter;

    public FragmentProduct() {
        // Required empty public constructor
    }

    public static FragmentProduct newInstance(String param1, String param2) {
        FragmentProduct fragment = new FragmentProduct();
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
        return inflater.inflate(R.layout.fragment_product, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        createListProduct();
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
        listProductAdapter = new ListProductAdapter(listProduct);
        rcv.setLayoutManager(new GridLayoutManager(requireContext(),2));
        rcv.setAdapter(listProductAdapter);

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
    private List createListProduct(){
        listProduct.add(new Product(R.drawable.img,"Gà quay",32,32000));
        listProduct.add(new Product(R.drawable.img,"Gà quay",32,32000));
        listProduct.add(new Product(R.drawable.img,"Gà quay",32,32000));
        listProduct.add(new Product(R.drawable.img,"Gà quay",32,32000));
        listProduct.add(new Product(R.drawable.img,"Gà quay",32,32000));
        return listProduct;
    }
}
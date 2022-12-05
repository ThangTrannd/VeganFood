package vn.fpoly.veganfood.activity.shoppingcard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import vn.fpoly.veganfood.R;
import vn.fpoly.veganfood.activity.home.adapter.ListProductAdapter;
import vn.fpoly.veganfood.adapter.ProductAdapter;
import vn.fpoly.veganfood.model.product.Product;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentShopping#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentShopping extends Fragment {

    private RecyclerView rcv;
    private List<Product> listProduct = new ArrayList<>();
    private ProductAdapter productAdapter;


    public FragmentShopping() {
        // Required empty public constructor
    }

    public static FragmentShopping newInstance(String param1, String param2) {
        FragmentShopping fragment = new FragmentShopping();
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
        return inflater.inflate(R.layout.fragment_shopping, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rcv = view.findViewById(R.id.rcv_Product);
        createListProduct();
        productAdapter = new ProductAdapter(listProduct);
        rcv.setLayoutManager(new LinearLayoutManager(getActivity()));
        rcv.setAdapter(productAdapter);
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
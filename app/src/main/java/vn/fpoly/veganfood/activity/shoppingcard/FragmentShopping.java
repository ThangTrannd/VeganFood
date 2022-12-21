package vn.fpoly.veganfood.activity.shoppingcard;

import android.content.Context;
import android.content.SharedPreferences;
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

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import vn.fpoly.veganfood.R;
import vn.fpoly.veganfood.activity.home.adapter.ListProductAdapter;
import vn.fpoly.veganfood.adapter.ProductAdapter;
import vn.fpoly.veganfood.domain.APIInterface;
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
    SharedPreferences shaPref;

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
        shaPref = requireContext().getSharedPreferences("Sharef", Context.MODE_PRIVATE);
        rcv = view.findViewById(R.id.rcv_Product);
        createListProduct();
        productAdapter = new ProductAdapter(listProduct,getContext());
        rcv.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    private List createListProduct(){
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://demoapishop.up.railway.app")
                .addConverterFactory(GsonConverterFactory.create()).build();
        APIInterface jsonHolderApi = retrofit.create(APIInterface.class);
        System.out.println("Thắng check token" + shaPref.getString("TOKEN",""));
        Call<List<Product>> call = jsonHolderApi.getProducts("Bearer "+shaPref.getString("TOKEN",""));
        call.enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                System.out.println("Thắng \b" +response);
                if (response.code() == 200){
                    if (response.body() != null){
                        for (int i = 0; i < response.body().size(); i++) {
                            listProduct.add(response.body().get(i));
                        }
                        rcv.setAdapter(productAdapter);
                    }
                }
                else {
                    System.out.println("Thắng call Api home fail");
                }

            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {
                System.out.println(t);
            }
        });
        return listProduct;
    }
}
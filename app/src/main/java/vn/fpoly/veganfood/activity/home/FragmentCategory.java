package vn.fpoly.veganfood.activity.home;

import android.content.Context;
import android.content.SharedPreferences;
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

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import vn.fpoly.veganfood.R;
import vn.fpoly.veganfood.activity.home.adapter.CategoryAdapter;
import vn.fpoly.veganfood.activity.home.adapter.ListProductAdapter;
import vn.fpoly.veganfood.activity.product.FragmentProduct;
import vn.fpoly.veganfood.domain.APIInterface;
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
    SharedPreferences shaPref;

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
        shaPref = requireContext().getSharedPreferences("Sharef", Context.MODE_PRIVATE);
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
        categoryAdapter = new CategoryAdapter(listCate,getContext());
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
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://demoapishop.up.railway.app")
                .addConverterFactory(GsonConverterFactory.create()).build();
        APIInterface jsonHolderApi = retrofit.create(APIInterface.class);
        System.out.println("Thắng check token" + shaPref.getString("TOKEN",""));
        Call<List<Category>> call = jsonHolderApi.getCategory("Bearer "+shaPref.getString("TOKEN",""));
        call.enqueue(new Callback<List<Category>>() {
            @Override
            public void onResponse(Call<List<Category>> call, Response<List<Category>> response) {
                System.out.println("Thắng \b" +response.body());
                if (response.code() == 200){
                    if (response.body() != null){
                        for (int i = 0; i < response.body().size(); i++) {
                            listCate.add(response.body().get(i));
                        }
                    }
                    rcv.setAdapter(categoryAdapter);
                }

            }

            @Override
            public void onFailure(Call<List<Category>> call, Throwable t) {
                System.out.println(t);
            }
        });
        return listCate;
    }
}
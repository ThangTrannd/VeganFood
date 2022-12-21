package vn.fpoly.veganfood.activity.profile;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.Fragment;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import vn.fpoly.veganfood.R;
import vn.fpoly.veganfood.domain.APIInterface;
import vn.fpoly.veganfood.model.home.Category;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentUserInfo#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentUserInfo extends Fragment {

    private AppCompatImageView ivBack,ivAvatarUser;
    private EditText tvUsername,tvPhone,tvEmail;
    private Button btnSave;
    SharedPreferences shaPref;

    public FragmentUserInfo() {
        // Required empty public constructor
    }

    public static FragmentUserInfo newInstance(String param1, String param2) {
        FragmentUserInfo fragment = new FragmentUserInfo();
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
        return inflater.inflate(R.layout.fragment_user_info, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        shaPref = requireContext().getSharedPreferences("Sharef", Context.MODE_PRIVATE);
        ivBack = view.findViewById(R.id.iv_Back);
        ivAvatarUser = view.findViewById(R.id.iv_avatar_user);
        tvUsername = view.findViewById(R.id.tv_username);
        tvPhone = view.findViewById(R.id.tv_phone);
        tvEmail = view.findViewById(R.id.tv_email);
        btnSave = view.findViewById(R.id.btnSave);
        FragmentProfile fragmentProfile = new FragmentProfile();
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, fragmentProfile).commit();
            }
        });
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, fragmentProfile).commit();
            }
        });
    }
    private void getUserInfo(){
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
                    }
                }

            }

            @Override
            public void onFailure(Call<List<Category>> call, Throwable t) {
                System.out.println(t);
            }
        });
    }

    private void updateData(){
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

                    }
                }

            }

            @Override
            public void onFailure(Call<List<Category>> call, Throwable t) {
                System.out.println(t);
            }
        });
    }
}
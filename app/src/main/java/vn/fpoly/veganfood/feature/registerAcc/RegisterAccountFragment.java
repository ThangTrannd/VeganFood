package vn.fpoly.veganfood.feature.registerAcc;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.gemvietnam.base.viper.ViewFragment;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import butterknife.BindView;
import retrofit2.Call;
import retrofit2.Response;
import vn.fpoly.veganfood.R;
import vn.fpoly.veganfood.feature.login.LoginActivity;
import vn.fpoly.veganfood.model.RegisterResult;

public class RegisterAccountFragment extends ViewFragment<RegisterAccountContract.Presenter> implements RegisterAccountContract.View, View.OnClickListener{

    @BindView(R.id.btn_register)
    TextView btn_register;
    @BindView(R.id.ed_name)
    TextInputEditText ed_name;
    @BindView(R.id.ed_phone_number)
    TextInputEditText ed_phone_number;
    @BindView(R.id.ed_username)
    TextInputEditText ed_username;
    @BindView(R.id.ed_email)
    TextInputEditText ed_email;
    @BindView(R.id.ed_pass)
    TextInputEditText ed_pass;
    @BindView(R.id.ed_repass)
    TextInputEditText ed_repass;
    @BindView(R.id.lo_username)
    TextInputLayout lo_username;
    @BindView(R.id.lo_phone_number)
    TextInputLayout lo_phone_number;
    @BindView(R.id.lo_name)
    TextInputLayout lo_name;
    @BindView(R.id.lo_pass)
    TextInputLayout lo_pass;
    @BindView(R.id.lo_repass)
    TextInputLayout lo_repass;
    @BindView(R.id.lo_email)
    TextInputLayout lo_email;

    public static RegisterAccountFragment getInstance() {
        return new RegisterAccountFragment();
    }
    @Override
    protected int getLayoutId() {
        return R.layout.register_acc_fragment;
    }

    @Override
    public void initLayout() {
        super.initLayout();
        setListener();
    }

    private void setListener() {
        btn_register.setOnClickListener(this);
        ed_name.setOnClickListener(this);
        ed_phone_number.setOnClickListener(this);
        ed_username.setOnClickListener(this);
        ed_pass.setOnClickListener(this);
        ed_repass.setOnClickListener(this);
    }

    @Override
    public void registerAccSuccess(Response<RegisterResult> data) {
        Toast.makeText(getViewContext(), "Đăng ký thành công", Toast.LENGTH_LONG).show();
        Intent i = new Intent(getViewContext(), LoginActivity.class);
        startActivity(i);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_register:
                String name = ed_name.getText().toString().trim();
                String phoneNumber = ed_phone_number.getText().toString().trim();
                String username = ed_username.getText().toString().trim();
                String pass = ed_pass.getText().toString().trim();
                String rePass = ed_repass.getText().toString().trim();
                String email = ed_email.getText().toString().trim();
                String validNumber = "(84|0[3|5|7|8|9])+([0-9]{8})\\b";
                String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
                if(name.equals("")) {
                    lo_name.setError("Tên không được trống!");
                    return;
                }
                else if (!name.equals("")){
                    lo_name.setErrorEnabled(false);
                }

                if(phoneNumber.equals("")) {
                    lo_phone_number.setError("Số điện thoại không được trống!");
                    return;
                }
                else if (!phoneNumber.matches(validNumber)){
                    lo_phone_number.setError("Số điện thoại sai định dạng!");
                    return;
                }
                else if (!phoneNumber.equals("")){
                    lo_phone_number.setErrorEnabled(false);
                }


                if(email.equals("")) {
                    lo_email.setError("Email không được trống!");
                    return;
                }
                else if (!email.matches(emailPattern)){
                    lo_email.setError("Email sai định dạng!");
                    return;
                }
                else if (!email.equals("")){
                    lo_email.setErrorEnabled(false);
                }

                if(username.equals("")) {
                    lo_username.setError("Tên đăng nhập không được trống!");
                    return;
                }
                else if (!username.equals("")){
                    lo_username.setErrorEnabled(false);
                }

                if(pass.equals("")) {
                    lo_pass.setError("Mật khẩu không được trống!");
                    return;
                }
                else if (!pass.equals("")){
                    lo_pass.setErrorEnabled(false);
                }

                if(rePass.equals("")) {
                    lo_repass.setError("Mật khẩu xác nhận không được trống!");
                    return;
                }
                else if (!rePass.equals("")){
                    lo_repass.setErrorEnabled(false);
                }

                if(!pass.equals(rePass)) {
                    lo_repass.setError("Mật khẩu xác nhận không đúng!");
                    return;
                }
                mPresenter.registerAcc(name, username, pass, email, phoneNumber);
                break;
        }
    }
}

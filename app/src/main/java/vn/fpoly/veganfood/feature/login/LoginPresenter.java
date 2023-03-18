package vn.fpoly.veganfood.feature.login;

import android.widget.Toast;

import vn.fpoly.veganfood.dialog.DialogUtils;
import vn.fpoly.veganfood.model.LoginResult;
import vn.fpoly.veganfood.network.TCCCallback;
import com.gemvietnam.base.viper.Presenter;
import com.gemvietnam.base.viper.interfaces.ContainerView;

import retrofit2.Call;
import retrofit2.Response;

public class LoginPresenter extends Presenter<LoginContract.View, LoginContract.Interactor>
        implements LoginContract.Presenter {

    public LoginPresenter(ContainerView containerView) {
        super(containerView);
    }
    @Override
    public void start() {

    }

    @Override
    public LoginContract.Interactor onCreateInteractor() {
        return new LoginInteractor(this);
    }

    @Override
    public LoginContract.View onCreateView() {
        return LoginFragment.getInstance();
    }

    @Override
    public void loginWithPass(String username, String pass, String type, String token_device) {
        DialogUtils.showProgressDialog(getViewContext());
        System.out.println("Thắng 123 \b" + username +"\b"+ pass +"\b"+  type +"\b"+ token_device);
        mInteractor.loginWithPass(new TCCCallback<LoginResult>() {
            @Override
            public void onTCTCSuccess(Call<LoginResult> call, Response<LoginResult> response) {
                System.out.println("Thắng 123" + response.body().toString());
                DialogUtils.dismissProgressDialog();
                if(response.body().getIsSuccess()) {
                    mView.loginSuccess(response);
                }else {
                    Toast.makeText(getViewContext(), response.body().getErrorMessage(), Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onTCTCFailure(Call<LoginResult> call) {
                DialogUtils.dismissProgressDialog();
            }
        }, username, pass, type, token_device);
    }
}

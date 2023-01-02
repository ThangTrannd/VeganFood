package vn.fpoly.veganfood.feature.registerAcc;

import android.widget.Toast;
import com.gemvietnam.base.viper.Presenter;
import com.gemvietnam.base.viper.interfaces.ContainerView;

import retrofit2.Call;
import retrofit2.Response;
import vn.fpoly.veganfood.dialog.DialogUtils;
import vn.fpoly.veganfood.model.RegisterResult;
import vn.fpoly.veganfood.network.TCCCallback;

public class RegisterAccountPresenter extends Presenter<RegisterAccountContract.View, RegisterAccountContract.Interactor>
        implements RegisterAccountContract.Presenter{
    public RegisterAccountPresenter(ContainerView containerView) {
        super(containerView);
    }
    @Override
    public void start() {

    }

    @Override
    public RegisterAccountContract.Interactor onCreateInteractor() {
        return new RegisterAccountInteractor(this);
    }

    @Override
    public RegisterAccountContract.View onCreateView() {
        return RegisterAccountFragment.getInstance();
    }

    @Override
    public void registerAcc(String name, String username, String pass, String mail, String phone) {
        DialogUtils.showProgressDialog(getViewContext());
        mInteractor.registerAcc(new TCCCallback<RegisterResult>() {
            @Override
            public void onTCTCSuccess(Call<RegisterResult> call, Response<RegisterResult> response) {
                DialogUtils.dismissProgressDialog();
                if(response.body().getIsSuccess()){
                    mView.registerAccSuccess(response);
                }else {
                    Toast.makeText(getViewContext(), response.body().getErrorMessage(), Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onTCTCFailure(Call<RegisterResult> call) {
                DialogUtils.dismissProgressDialog();
            }
        }, name, username, pass, mail, phone);
    }
}

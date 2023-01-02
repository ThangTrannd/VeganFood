package vn.fpoly.veganfood.feature.login;

import vn.fpoly.veganfood.model.CategoriesResult;
import vn.fpoly.veganfood.model.DataTestResult;
import vn.fpoly.veganfood.model.LoginResult;
import vn.fpoly.veganfood.network.NetWorkController;
import vn.fpoly.veganfood.network.TCCCallback;
import com.gemvietnam.base.viper.Interactor;

public class LoginInteractor extends Interactor<LoginContract.Presenter>
        implements LoginContract.Interactor{
    public LoginInteractor(LoginContract.Presenter presenter) {
        super(presenter);
    }


    @Override
    public void loginWithPass(TCCCallback<LoginResult> callback, String username, String pass, String type, String token_device) {
        NetWorkController.loginWithPass(callback, username, pass, type, token_device);
    }

}

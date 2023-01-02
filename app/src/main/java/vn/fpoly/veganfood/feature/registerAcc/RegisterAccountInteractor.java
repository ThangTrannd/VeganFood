package vn.fpoly.veganfood.feature.registerAcc;

import com.gemvietnam.base.viper.Interactor;

import vn.fpoly.veganfood.model.RegisterResult;
import vn.fpoly.veganfood.network.NetWorkController;
import vn.fpoly.veganfood.network.TCCCallback;

public class RegisterAccountInteractor extends Interactor<RegisterAccountContract.Presenter>
        implements RegisterAccountContract.Interactor{
    public RegisterAccountInteractor(RegisterAccountContract.Presenter presenter) {
        super(presenter);
    }

    @Override
    public void registerAcc(TCCCallback<RegisterResult> callback, String name, String username, String password, String email, String phone) {
        NetWorkController.registerAcc(callback, name, username, password, email, phone);
    }
}

package vn.fpoly.veganfood.feature.login;

import vn.fpoly.veganfood.model.CategoriesResult;
import vn.fpoly.veganfood.model.DataTestResult;
import vn.fpoly.veganfood.model.LoginResult;
import vn.fpoly.veganfood.network.TCCCallback;
import com.gemvietnam.base.viper.interfaces.IInteractor;
import com.gemvietnam.base.viper.interfaces.IPresenter;
import com.gemvietnam.base.viper.interfaces.PresentView;

import retrofit2.Response;

public interface LoginContract {
    interface Interactor extends IInteractor<Presenter> {
        void loginWithPass(TCCCallback<LoginResult> callback, String username, String pass, String type, String token_device);
    }

    interface View extends PresentView<Presenter> {
        void loginSuccess(Response<LoginResult> data);
    }

    interface Presenter extends IPresenter<View, Interactor> {
        void loginWithPass(String username, String pass, String type, String token_device);
    }
}

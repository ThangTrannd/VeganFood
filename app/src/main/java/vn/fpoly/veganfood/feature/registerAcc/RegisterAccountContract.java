package vn.fpoly.veganfood.feature.registerAcc;

import com.gemvietnam.base.viper.interfaces.IInteractor;
import com.gemvietnam.base.viper.interfaces.IPresenter;
import com.gemvietnam.base.viper.interfaces.PresentView;

import retrofit2.Response;
import vn.fpoly.veganfood.model.RegisterResult;
import vn.fpoly.veganfood.network.TCCCallback;

public interface RegisterAccountContract {
    interface Interactor extends IInteractor<Presenter> {
        void registerAcc(TCCCallback<RegisterResult> callback, String name, String username, String pass, String mail, String phone);
    }

    interface View extends PresentView<Presenter> {
        void registerAccSuccess(Response<RegisterResult> data);
    }

    interface Presenter extends IPresenter<View, Interactor> {
        void registerAcc(String name, String username, String pass, String mail, String phone);
    }
}

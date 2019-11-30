package com.legend.account.contract;

import androidx.annotation.UiThread;

import com.legend.account.entity.UserEntity;
import com.legend.net.call.IHttpCallback;
import com.library.base.BaseModel;
import com.library.base.BaseView;
import com.trello.rxlifecycle3.LifecycleProvider;

/**
 * @创建人: Ailen
 * @创建时间: 2019/10/22 0022
 * @描述：账户VM订阅接口
 */
public interface AccountContract {
    interface AccountView extends BaseView {
        /*登录成功展示结果*/
        @UiThread
        void showResult(UserEntity data);
    }

    /*登录模块model接口.此处根据具体项目决定是否需要此接口层*/
    interface AccountModel extends BaseModel {
        void userLogin(String userName, String password, LifecycleProvider lifecycle, IHttpCallback<UserEntity> callback);

        void ckUserLogin(String userName, String password, LifecycleProvider lifecycle, IHttpCallback<UserEntity> callback);
    }


}

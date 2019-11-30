package com.legend.account.presenter;


import androidx.annotation.NonNull;

import com.google.gson.Gson;
import com.legend.account.contract.AccountContract;
import com.legend.account.entity.UserEntity;
import com.legend.account.model.AccountModel;
import com.legend.net.call.IHttpCallback;
import com.library.base.BasePresenter;
import com.utilcode.util.ToastUtils;

/**
 * @创建人: Ailen
 * @创建时间: 2019/10/22 0022
 * @描述：
 */
public class AccountPresenter extends BasePresenter<AccountContract.AccountView> {
    private AccountModel accountModel;

    public AccountPresenter(@NonNull AccountContract.AccountView view) {
        super(view);
        accountModel = new AccountModel();
    }

    public void login(String userName, String userPwd) {
        accountModel.userLogin(userName, userPwd,getView().getRxLifecycle(), new IHttpCallback<UserEntity>() {
            @Override
            public UserEntity convert(String data) {
                return new Gson().fromJson(data,UserEntity.class);
            }

            @Override
            public void onSuccess(UserEntity value) {
                getView().showResult(value);
            }

            @Override
            public void onError(int code, String desc) {
                ToastUtils.showLong(desc);
            }

            @Override
            public void onCancel() {
                ToastUtils.showLong("取消");
            }
        });
    }

    public void ckLogin(String userName, String userPwd) {
        accountModel.ckUserLogin(userName, userPwd,getView().getRxLifecycle(), new IHttpCallback<UserEntity>() {
            @Override
            public UserEntity convert(String data) {
                return new Gson().fromJson(data,UserEntity.class);
            }

            @Override
            public void onSuccess(UserEntity value) {
                getView().showResult(value);
            }

            @Override
            public void onError(int code, String desc) {
                ToastUtils.showLong(desc);
            }

            @Override
            public void onCancel() {
                ToastUtils.showLong("取消");
            }
        });
    }



}

package com.legend.account.model;

import com.google.gson.Gson;
import com.legend.account.contract.AccountContract;
import com.legend.account.entity.UserEntity;
import com.legend.net.call.IHttpCallback;
import com.library.ihttp.IHttp;
import com.trello.rxlifecycle3.LifecycleProvider;
import com.utilcode.util.LogUtils;

import java.util.TreeMap;

/**
 * @创建人: Ailen
 * @创建时间: 2019/10/22 0022
 * @描述：
 */
public class AccountModel implements AccountContract.AccountModel {

    @Override
    public void userLogin(String userName, String password, LifecycleProvider lifecycle, IHttpCallback callback) {
        /**
         * 构建请求参数
         */
        TreeMap<String, Object> request = new TreeMap<>();
        request.put("username", userName);
        request.put("password", password);
        /**
         * 发送请求
         */
        IHttp http = new IHttp.Builder()
                .post()
                .apiUrl("open/login")
                .lifecycle(lifecycle)
                .addParameter(request)
//                .setBodyString(new Gson().toJson(request),true)
                .build();
        http.execute(callback);
    }

    @Override
    public void ckUserLogin(String userName, String password, LifecycleProvider lifecycle, IHttpCallback<UserEntity> callback) {
        /**
         * 构建请求参数
         */
        TreeMap<String, Object> request = new TreeMap<>();
        request.put("phone", "18729311990");
        request.put("veCode", "1111");
        request.put("type", "2");
        LogUtils.e(new Gson().toJson(request));
        /**
         * 发送请求
         */
        IHttp http = new IHttp.Builder()
                .post()
                .baseUrl("http://120.79.212.1:8081/")
                .apiUrl("zsd-api/app/memberbasic/login")
                .lifecycle(lifecycle)
                .setBodyString(new Gson().toJson(request),true)
                .build();
        http.execute(callback);
    }
}
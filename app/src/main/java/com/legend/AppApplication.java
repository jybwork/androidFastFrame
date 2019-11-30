package com.legend;

import android.app.Application;

import com.library.base.BaseApplication;
import com.library.ihttp.IHttp;
import com.utilcode.util.LogUtils;
import com.utilcode.util.SharedPreferencesUtil;

import java.util.concurrent.TimeUnit;

/**
 * @创建人: Ailen
 * @创建时间: 2019/10/16 0016
 * @描述：应用
 */
public class AppApplication extends BaseApplication {
    private static final int TIMEOUT = 20;

    @Override
    public void onCreate() {
        super.onCreate();
        LogUtils.getConfig().setConsoleSwitch(BuildConfig.DEBUG);
        SharedPreferencesUtil.init(this);

        //初始化网络请求
        IHttp.Configure.get()
                .baseUrl(BuildConfig.API_URL)//配置baseUrl
                .timeout(TIMEOUT)//配置超时时间
                .timeUnit(TimeUnit.SECONDS)//时间单位
                .showLog(BuildConfig.DEBUG)
                .init(this);

    }
}

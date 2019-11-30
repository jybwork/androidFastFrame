package com.library.base;

import android.app.Application;

/**
 * @创建人: Ailen
 * @创建时间: 2019/10/24 0024
 * @描述：
 */
public class BaseApplication extends Application {
    private static BaseApplication mContext = null;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
    }

    /**
     * 获取应用公用对象
     *
     * @return 应用对象
     */
    public static BaseApplication _getmContext() {
        return mContext;
    }
}

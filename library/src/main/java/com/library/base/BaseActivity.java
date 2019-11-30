package com.library.base;


import android.graphics.Color;
import android.os.Bundle;
import android.view.InflateException;

import androidx.annotation.Nullable;

import com.jaeger.library.StatusBarUtil;;
import com.trello.rxlifecycle3.LifecycleProvider;
import com.trello.rxlifecycle3.components.support.RxAppCompatActivity;
import com.utilcode.util.ActivityUtils;
import com.utilcode.util.ToastUtils;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @创建人: Ailen
 * @创建时间: 2019/10/9 0009.
 * @描述：activity基类
 */
public abstract class BaseActivity extends RxAppCompatActivity implements IActivity,BaseView {
    protected BaseActivity mContext;

    private Unbinder mUnbinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        try {
            int layoutResID = initView(savedInstanceState);
            //如果initView返回0,框架则不会调用setContentView(),当然也不会 Bind ButterKnife
            if (layoutResID != 0) {
                setContentView(layoutResID);
                //绑定到butterknife
                mUnbinder = ButterKnife.bind(this);
                setStatusBar();
                initData(savedInstanceState);
            }
        } catch (Exception e) {
            if (e instanceof InflateException) throw e;
            e.printStackTrace();
        }
    }

    @Override
    public void setStatusBar() {
        StatusBarUtil.setColor(this, Color.parseColor("#000000"));
    }


    @Override
    public void showDialog() {
        ToastUtils.showLong("开始");
    }

    @Override
    public void closeDialog() {
        ToastUtils.showLong("结束");
    }

    @Override
    public LifecycleProvider getRxLifecycle() {
        return this;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityUtils.finishActivity(this);
        if (mUnbinder != null && mUnbinder != Unbinder.EMPTY)
            mUnbinder.unbind();
        this.mUnbinder = null;
    }
}
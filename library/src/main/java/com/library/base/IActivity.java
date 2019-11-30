package com.library.base;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;

/**
 * @创建人: Ailen
 * @创建时间: 2019/10/16 0016
 * @描述：activity接口$
 */
public interface IActivity extends BaseView {
    /**
     * 初始化 View, 如果 {@link #initView(Bundle)} 返回 0, 框架则不会调用 {@link Activity#setContentView(int)}
     *
     * @param savedInstanceState
     * @return
     */
    int initView(@Nullable Bundle savedInstanceState);

    /**
     * 初始化数据
     *
     * @param savedInstanceState
     */
    void initData(@Nullable Bundle savedInstanceState);

    /**
     * 初始化状态栏颜色
     */
    void setStatusBar();

}

package com.library.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * @创建人: Ailen
 * @创建时间: 2019/10/16 0016
 * @描述：fragment接口
 */
public interface IFragment extends BaseView {

    /**
     * 初始化 View
     *
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    int initView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState);

    /**
     * 初始化数据
     *
     * @param savedInstanceState
     */
    void initData(@Nullable Bundle savedInstanceState);
}

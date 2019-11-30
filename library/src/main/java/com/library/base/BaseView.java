package com.library.base;

import com.trello.rxlifecycle3.LifecycleProvider;

/**
 * @创建人: Ailen
 * @创建时间: 2019/10/21 0021
 * @描述：
 */
public interface BaseView {
    /**
     * RxLifecycle用于绑定组件生命周期
     *
     * @return
     */
    LifecycleProvider getRxLifecycle();

    /**
     * 显示加载框
     */
    void showDialog();

    /**
     * 关闭加载框
     */
    void closeDialog();
}

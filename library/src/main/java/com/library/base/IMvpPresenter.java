package com.library.base;

import androidx.annotation.NonNull;
import androidx.annotation.UiThread;

/**
 * @创建人: Ailen
 * @创建时间: 2019/10/24 0024
 * @描述：
 */
public interface IMvpPresenter<V extends BaseView> {


    /**
     * 判断 presenter 是否与 view 建立联系，防止出现内存泄露状况
     *
     * @return {@code true}: 联系已建立<br>{@code false}: 联系已断开
     */
    boolean isViewAttach();

    /**
     * 将 View 从 Presenter 移除
     */
    @UiThread
    void detachView();



}

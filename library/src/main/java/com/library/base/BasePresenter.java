package com.library.base;

import androidx.annotation.NonNull;
import androidx.annotation.UiThread;

import com.library.ihttp.proxy.MvpViewProxy;

import java.lang.ref.WeakReference;

/**
 * @创建人: Ailen
 * @创建时间: 2019/10/22 0022
 * @描述：
 */
public class BasePresenter<V extends BaseView> implements IMvpPresenter<V> {

    // 防止 Activity 不走 onDestory() 方法，所以采用弱引用来防止内存泄漏
    private WeakReference<V> mViewRef;

    public BasePresenter(@NonNull V view) {
        attachView(view);
    }

    @UiThread
    public void attachView(V view) {
        mViewRef = new WeakReference<V>(view);
    }

    public V getView() {
        return mViewRef.get();
    }

    @Override
    public boolean isViewAttach() {
        return mViewRef != null && mViewRef.get() != null;
    }

    @Override
    @UiThread
    public void detachView() {
        if (mViewRef != null) {
            mViewRef.clear();
            mViewRef = null;
        }
    }
}

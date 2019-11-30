package com.library.base;

import android.content.Context;
import android.os.Bundle;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.trello.rxlifecycle3.components.support.RxFragment;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @创建人: Ailen
 * @创建时间: 2019/10/16 0016
 * @描述：fragment基类
 */
public abstract class BaseFragment extends RxFragment implements IFragment {
    private boolean isViewCreated; // 界面是否已创建完成
    private boolean isVisibleToUser; // 是否对用户可见
    private boolean isDataLoaded; // 数据是否已请求

    protected Context mContext;//上下文对象

    private Unbinder mUnbinder;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (mContext == null) return;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = null;
        try {

            rootView = inflater.inflate(initView(inflater, container, savedInstanceState), null);
            //如果initView返回null,框架则不会调用initData(),当然也不会 Bind ButterKnife
            if (rootView != null) {
                //绑定到butterknife
                mUnbinder = ButterKnife.bind(this, rootView);
                initData(savedInstanceState);
            }
        } catch (Exception e) {
            if (e instanceof InflateException) throw e;
            e.printStackTrace();
        }
        return rootView;
    }

    /**
     * 第一次可见时触发调用,此处实现具体的数据请求逻辑
     */
    protected abstract void lazyLoadData();

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        this.isVisibleToUser = isVisibleToUser;
        tryLoadData();
    }

    /**
     * 保证在initData后触发
     */
    @Override
    public void onResume() {
        super.onResume();
        isViewCreated = true;
        tryLoadData();
    }

    /**
     * ViewPager场景下，判断父fragment是否可见
     */
    private boolean isParentVisible() {
        Fragment fragment = getParentFragment();
        return fragment == null || (fragment instanceof BaseFragment && ((BaseFragment) fragment).isVisibleToUser);
    }

    /**
     * ViewPager场景下，当前fragment可见时，如果其子fragment也可见，则让子fragment请求数据
     */
    private void dispatchParentVisibleState() {
        FragmentManager fragmentManager = getChildFragmentManager();
        List<Fragment> fragments = fragmentManager.getFragments();
        if (fragments.isEmpty()) {
            return;
        }
        for (Fragment child : fragments) {
            if (child instanceof BaseFragment && ((BaseFragment) child).isVisibleToUser) {
                ((BaseFragment) child).tryLoadData();
            }
        }
    }

    public void tryLoadData() {
        if (isViewCreated && isVisibleToUser && isParentVisible() && !isDataLoaded) {
            lazyLoadData();
            isDataLoaded = true;
            //通知子Fragment请求数据
            dispatchParentVisibleState();
        }
    }

    @Override
    public void showDialog() {

    }

    @Override
    public void closeDialog() {

    }



//    @Override
//    public void onDetach() {
//        super.onDetach();
//        mContext = null;
//    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mUnbinder != null && mUnbinder != Unbinder.EMPTY)
            mUnbinder.unbind();
        this.mUnbinder = null;
    }

}
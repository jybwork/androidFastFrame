package com.library.ihttp.proxy;

import com.library.base.BaseView;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @创建人: Ailen
 * @创建时间: 2019/10/24 0024
 * @描述： vpView 对象需要在 activity/fragment 组件销毁时清空，目的是异步回调时不再处理 BaseView 的方法
 */
public class MvpViewProxy <V extends BaseView> implements InvocationHandler {

    private V mView;

    //创建代理（接受委托）
    public Object newProxyInstance(V view) {
        this.mView = view;
        return Proxy.newProxyInstance(view.getClass().getClassLoader(), view.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // V 为空直接返回 null 不再继续调用函数
        if (mView == null) {
            return null;
        }
        //调用目标方法
        Object temp = method.invoke(mView, args);
        return temp;
    }

    /**
     * 解绑View
     */
    public void detachView() {
        mView = null;
    }

}

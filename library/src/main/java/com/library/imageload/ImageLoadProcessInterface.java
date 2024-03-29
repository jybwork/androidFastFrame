package com.library.imageload;

/**
 * @author ailen
 * @createTime 2019/3/4
 * @describe 图片加载过程的回调，回调监听这些方法不一定所有的库都有
 * @note 备注
 */
public interface ImageLoadProcessInterface {
    /**
     * 开始加载
     */
    void onLoadStarted();

    /**
     * 资源准备妥当
     */
    void onResourceReady();

    /**
     * 资源已经释放
     */
    void onLoadCleared();

    /**
     * 资源加载失败
     */
    void onLoadFailed();
}

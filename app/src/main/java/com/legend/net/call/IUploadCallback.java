package com.legend.net.call;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.legend.net.entity.BaseResponse;
import com.library.ihttp.callback.UploadCallback;

import java.io.File;

/**
 * 根据业务进一步封装
 *
 * @author Ailen
 */
public abstract class IUploadCallback<T> extends UploadCallback<T> {

    private BaseResponse response;

    @Override
    public T onConvert(String data) {
        /**
         * 接口响应数据格式如@BaseResponse
         * 根据业务封装:
         * 1. response.isSuccess() (code==0) 业务逻辑成功回调convert()=>onSuccess()，否则失败回调onError()
         * 2.统一处理接口逻辑 例如:code==101 token过期等等
         */
        T t = null;
        response = new Gson().fromJson(data, BaseResponse.class);
        int code = response.getCode();
        String msg = response.getMsg();
        switch (code) {
            case 101://token过期，跳转登录页面重新登录(示例)
                break;
            case 102://系统公告(示例)
                break;
            default:
                if (response.isSuccess()) {//与服务器约定成功逻辑
                    t = convert(data);
                } else {//统一为错误处理
                    onError(code, msg);
                }
                break;
        }
        return t;
    }

    /**
     * 数据转换/解析
     *
     * @param data
     * @return
     */
    public abstract T convert(String data);

    /**
     * 上传回调
     *
     * @param file
     * @param currentSize
     * @param totalSize
     * @param progress
     * @param currentIndex
     * @param totalFile
     */
    public abstract void onProgress(File file, long currentSize, long totalSize, float progress, int currentIndex, int totalFile);


    /**
     * 成功回调
     *
     * @param value
     */
    public abstract void onSuccess(T value);

    /**
     * 失败回调
     *
     * @param code
     * @param desc
     */
    public abstract void onError(int code, String desc);

    /**
     * 取消回调
     */
    public abstract void onCancel();

    /**
     * 业务逻辑是否成功
     *
     * @return
     */
    @Override
    public boolean isBusinessOk() {
        return response.isSuccess();
    }
}

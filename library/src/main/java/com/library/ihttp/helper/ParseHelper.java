package com.library.ihttp.helper;

/**
 * 数据解析helper
 *
 * @author Ailen
 */
public interface ParseHelper<T> {
    /*解析数据*/
    T parse(String data);
}

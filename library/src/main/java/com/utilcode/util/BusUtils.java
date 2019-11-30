package com.utilcode.util;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author ailen
 * @createTime 2018/11/30
 * @describe
 * @note 备注
 */
public final class BusUtils {

    public static <T> T post(String name, Object... objects) {
        if (name == null || name.length() == 0) return null;
        return null;
    }

    @Target({ElementType.METHOD})
    @Retention(RetentionPolicy.CLASS)
    public @interface BaseResponse {
        String name() default "";
    }
}

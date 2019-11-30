package com.library.ihttp.cookie;

import android.content.Context;
import android.text.TextUtils;

import com.library.base.BaseApplication;

import java.util.List;

import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;

/**
 * @创建人: Ailen
 * @创建时间: 2019/10/24 0024
 * @描述：cookie管理
 */
public class NovateCookieManger implements CookieJar {
    private static Context mContext;
    private static PersistentCookieStore cookieStore;

    private static class SingletonClassInstance {
        private static final NovateCookieManger INSTANCE = new NovateCookieManger();
    }

    public static NovateCookieManger getInstance() {
        return SingletonClassInstance.INSTANCE;
    }

    private NovateCookieManger() {
        mContext =  BaseApplication._getmContext();
        if (cookieStore == null) {
            cookieStore = new PersistentCookieStore(mContext);
        }
    }


    @Override
    public void saveFromResponse(HttpUrl url, List<Cookie> cookies) {
        if (cookies != null && cookies.size() > 0) {
            for (Cookie item : cookies) {

                cookieStore.add(url, item);
            }
        }
    }

    @Override
    public List<Cookie> loadForRequest(HttpUrl url) {
        List<Cookie> cookies = cookieStore.get(url);
        return cookies;
    }

    public boolean isLogin() {
        boolean islogin = false;
        if (cookieStore.getCookies() != null || cookieStore.getCookies().size() > 0) {
            for (Cookie cookie : cookieStore.getCookies()) {
                if (!TextUtils.isEmpty(cookie.name()) && cookie.name().equals("dcWisdom.session.id") && !TextUtils.isEmpty(cookie.value())) {
                    islogin = true;
                }
            }
        }
        return islogin;
    }

    public PersistentCookieStore getCookieStore() {
        return cookieStore;
    }
}

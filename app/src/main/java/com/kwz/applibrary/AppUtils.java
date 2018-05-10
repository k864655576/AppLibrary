package com.kwz.applibrary;

import com.kang.library.http.RetrofitUtils;

public class AppUtils {
    //用户API
    private static UserApi userApi;


    public static UserApi getUserApi() {
        if (userApi == null) {
            userApi = RetrofitUtils.getInstance().getRetrofit(BuildConfig.ROOT_URL).create(UserApi.class);
        }
        return userApi;
    }
}

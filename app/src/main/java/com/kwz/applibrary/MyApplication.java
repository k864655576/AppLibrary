package com.kwz.applibrary;

import android.util.Log;

import com.kang.library.base.BaseApplication;
import com.orhanobut.logger.Logger;


public class MyApplication extends BaseApplication {

    @Override
    protected void initialize() {
        Log.i("TAG", "initialize: -->>"+111);
        Logger.d(123);
    }
}

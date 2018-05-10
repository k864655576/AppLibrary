package com.kwz.applibrary;

import com.kang.library.base.BaseApplication;
import com.orhanobut.logger.Logger;


public class MyApplication extends BaseApplication {

    @Override
    protected void initialize() {
        Logger.d(123);
    }
}

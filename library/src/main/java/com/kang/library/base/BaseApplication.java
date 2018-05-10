package com.kang.library.base;

import android.app.Application;
import android.content.Context;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.FormatStrategy;
import com.orhanobut.logger.Logger;
import com.orhanobut.logger.PrettyFormatStrategy;


public abstract class BaseApplication extends Application {

    public static BaseApplication application;

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
        //初始化日志
        FormatStrategy formatStrategy = PrettyFormatStrategy.newBuilder()
                .tag("INFO")   //（可选）每个日志的全局标记。 默认PRETTY_LOGGER
                .build();
        Logger.addLogAdapter(new AndroidLogAdapter(formatStrategy));
        initialize();
    }

    protected abstract void initialize();

    /**
     * 获取app上下文对象
     *
     * @return
     */
    public static Context getContext() {
        return application.getApplicationContext();
    }
}

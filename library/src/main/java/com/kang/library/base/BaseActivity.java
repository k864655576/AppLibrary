package com.kang.library.base;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());

    }

    @Override
    protected void onPause() {
        super.onPause();
        pause();
    }

    @Override
    protected void onStop() {
        super.onStop();
        stop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        destroy();
    }

    /**
     * 引入布局文件
     *
     * @return
     */
    protected abstract @LayoutRes
    int getLayoutId();

    protected void pause() {

    }

    protected void stop() {

    }

    protected void destroy() {

    }
}

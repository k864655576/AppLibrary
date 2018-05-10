package com.kang.library.base;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.kang.library.utils.StatusBarUtil;
import com.kang.library.utils.eventbus.EventBusEntity;
import com.kang.library.widget.dialog.LoadingDialog;
import com.kwz.library.R;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseActivity extends AppCompatActivity implements ViewInterface {

    private Unbinder butterBind;
    protected Context context;
    private LoadingDialog loadingDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStatusBar();
        setContentView(getLayoutId());
        butterBind = ButterKnife.bind(this);
        EventBus.getDefault().register(this);
        context = this;
        initView();
        initData();
    }


    @Override
    public void showLoadingDialog() {
        if (loadingDialog == null) {
            loadingDialog = new LoadingDialog(this);
        }
        loadingDialog.show(null);
    }


    @Override
    public void hideLoadingDialog() {
        if (loadingDialog != null) {
            if (loadingDialog.isShowing()) {
                loadingDialog.cancel();
            }
            loadingDialog = null;
        }
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
        butterBind.unbind();
        EventBus.getDefault().unregister(this);
        destroy();
    }

    /**
     * 设置状态栏
     */
    protected void setStatusBar() {
        StatusBarUtil.setColor(this, getResources().getColor(R.color.colorPrimary));
    }

    /**
     * 初始化布局
     */
    protected abstract void initView();

    /**
     * 初始化数据
     */
    protected abstract void initData();

    /**
     * 引入布局文件
     *
     * @return
     */
    protected abstract @LayoutRes
    int getLayoutId();

    /**
     * 发送主线程的消息
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMainEvent(EventBusEntity eventBusEntity) {

    }

    protected void pause() {

    }

    protected void stop() {

    }

    protected void destroy() {

    }
}

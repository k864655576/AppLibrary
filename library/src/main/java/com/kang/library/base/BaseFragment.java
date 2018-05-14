package com.kang.library.base;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kang.library.base.view.ViewInterface;
import com.kang.library.widget.dialog.LoadingDialog;

import org.greenrobot.eventbus.EventBus;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseFragment extends Fragment implements ViewInterface {

    private Unbinder butterBind;
    private LoadingDialog loadingDialog;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutId(), container, false);
        butterBind = ButterKnife.bind(this, view);
        initView(view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        EventBus.getDefault().register(this);
        initData();
    }

    protected abstract void initData();

    /**
     * 初始化页面
     *
     * @param view
     */

    /**
     * 初始化数据
     *
     * @param view
     */
    protected abstract void initView(View view);


    protected abstract @LayoutRes
    int getLayoutId();


    @Override
    public void showLoadingDialog() {
        if (loadingDialog == null) {
            loadingDialog = new LoadingDialog(getContext());
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
    public void onResume() {
        super.onResume();
        resume();
    }

    @Override
    public void onPause() {
        super.onPause();
        pause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (butterBind != null) {
            butterBind.unbind();
        }
        destroy();

    }

    protected void destroy() {

    }

    protected void resume() {

    }

    protected void pause() {

    }
}

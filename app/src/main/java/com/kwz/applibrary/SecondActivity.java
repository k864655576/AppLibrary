package com.kwz.applibrary;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.kang.library.base.BaseActivity;
import com.kang.library.http.ApiException;
import com.kang.library.http.HttpRxObservable;
import com.kang.library.http.HttpRxObserver;
import com.kang.library.utils.eventbus.EventBusEntity;
import com.kang.library.widget.dialog.LoadingDialog;
import com.orhanobut.logger.Logger;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import io.reactivex.disposables.Disposable;


public class SecondActivity extends BaseActivity {
    @BindView(R.id.tvTitle)
    TextView tvTitle;

    @Override
    protected void initView() {
        tvTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(context, ThirdActivity.class));
            }
        });

        showLoadingDialog();
    }

    @Override
    protected void initData() {
        Map<String, Object> map = new HashMap<>();
        HttpRxObservable.getObservable(AppUtils.getUserApi().system(map)).subscribe(new HttpRxObserver() {
            @Override
            protected void onStart(Disposable var1) {
                Logger.d(var1);
            }

            @Override
            protected void onError(ApiException var1) {
                Logger.d(var1);
            }

            @Override
            protected void onSuccess(Object var1) {
                hideLoadingDialog();
                Logger.d(var1);
            }
        });

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_second;
    }

    @Override
    public void onMainEvent(EventBusEntity eventBusEntity) {
        super.onMainEvent(eventBusEntity);
        Log.i("TAG", "onMainEvent: -->>" + eventBusEntity + Thread.currentThread().getName());
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        Log.i("TAG", "onPointerCaptureChanged: -->>" + hasCapture);
    }
}

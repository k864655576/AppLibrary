package com.kwz.applibrary;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.kang.library.base.BaseActivity;
import com.kang.library.utils.EventBusEntity;

import butterknife.BindView;


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
    }

    @Override
    protected void initData() {

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

package com.kwz.applibrary;

import android.view.View;
import android.widget.TextView;

import com.kang.library.base.BaseActivity;
import com.kang.library.utils.eventbus.EventBusUtils;

import butterknife.BindView;

public class ThirdActivity extends BaseActivity {

    @BindView(R.id.tvTitle)
    TextView tvTitle;

    @Override
    protected void initView() {
        tvTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBusUtils.getInstance().sendMessage(1);
            }
        });
    }

    @Override
    protected void initData() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_third;
    }
}

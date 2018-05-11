package com.kwz.applibrary;

import android.os.Handler;

import com.kang.library.base.BaseActivity;
import com.kang.library.widget.EmptyLayoutView;


import butterknife.BindView;

public class ThirdActivity extends BaseActivity {
    @BindView(R.id.empty_layout_view)
    EmptyLayoutView emptyLayoutView;

    @Override
    protected void initView() {


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                emptyLayoutView.setEmptyLayout(R.mipmap.ic_launcher, "还没有任何信息", "重新加载");
            }
        }, 3000);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_third;
    }
}

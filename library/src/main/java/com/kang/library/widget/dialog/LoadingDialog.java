package com.kang.library.widget.dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.kwz.library.R;

public class LoadingDialog extends AlertDialog {
    private Context context;
    private ProgressBar mBar;
    private TextView mMessage;

    public LoadingDialog(Context context) {
        this(context, 0);
    }

    private LoadingDialog(Context context, int themeResId) {
        super(context, R.style.LoadDialog);
        this.context = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.common_loading_dialog);
        setCancelable(false);
        mBar = findViewById(R.id.bar);
        mMessage = findViewById(R.id.message);
    }


    public void show(String msg) {
        super.show();
        if (msg == null) {
            mMessage.setText("正在加载中...");
        } else {
            mMessage.setText(msg);
        }
    }

    //设置进度图片
    public void setIndeterminateDrawable(@DrawableRes int drawable) {
        mBar.setIndeterminateDrawable(context.getResources().getDrawable(drawable));
    }

    //设置字体颜色
    public void setTextColor(int color) {
        mMessage.setTextColor(color);
    }
}

package com.kang.library.widget;

import android.content.Context;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.kwz.library.R;

public class TitleBarView extends FrameLayout {
    private Context context;
    private RelativeLayout rlContainer;
    private ImageView btnLeft;
    private TextView tvTitle;
    private TextView tvRight;
    private ImageView ivRight;

    public TitleBarView(@NonNull Context context) {
        this(context, null);
    }

    public TitleBarView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TitleBarView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        initView();
    }

    private void initView() {
        View view = LayoutInflater.from(context).inflate(R.layout.common_title_bar, this, false);
        rlContainer = view.findViewById(R.id.rl_container);
        btnLeft = view.findViewById(R.id.btnLeft);
        tvTitle = view.findViewById(R.id.tvTitle);
        tvRight = view.findViewById(R.id.tvRight);
        ivRight = view.findViewById(R.id.ivRight);
        addView(view);
    }

    public void setBtnLeft(@DrawableRes int resId) {
        btnLeft.setImageResource(resId);
    }

    public void setBackground(@ColorRes int resId) {
        rlContainer.setBackgroundResource(resId);
    }

    public void setTitle(String title) {
        tvTitle.setText(title);
    }

    public ImageView getBtnLeft() {
        return btnLeft;
    }

    public ImageView getIvRight() {
        return ivRight;
    }

    public TextView getTvRight() {
        return tvRight;
    }
}

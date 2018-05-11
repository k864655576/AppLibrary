package com.kang.library.widget;

import android.content.Context;
import android.support.annotation.DrawableRes;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.kwz.library.R;

public class EmptyLayoutView extends FrameLayout implements View.OnClickListener {
    private Context context;
    private ImageView ivIcon;
    private TextView tvMsg;
    private TextView btnReloading;
    private LinearLayout emptyContainer;
    private ProgressBar progressBar;

    public EmptyLayoutView(Context context) {
        this(context, null);
    }

    public EmptyLayoutView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public EmptyLayoutView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        initView();
    }

    private void initView() {
        View view = LayoutInflater.from(context).inflate(R.layout.common_empty_layout, this, false);
        ivIcon = view.findViewById(R.id.ivIcon);
        tvMsg = view.findViewById(R.id.tvMsg);
        btnReloading = view.findViewById(R.id.btnReloading);
        emptyContainer = view.findViewById(R.id.empty_container);
        progressBar = view.findViewById(R.id.progress_bar);
        btnReloading.setOnClickListener(this);
        addView(view);
    }

    public void setEmptyLayout(@DrawableRes int resId, @Nullable String msg) {
        emptyContainer.setVisibility(VISIBLE);
        progressBar.setVisibility(GONE);
        ivIcon.setImageResource(resId);
        tvMsg.setText(msg);
        ivIcon.setVisibility(VISIBLE);
        tvMsg.setVisibility(VISIBLE);
        btnReloading.setText(GONE);
    }

    public void setEmptyLayout(@Nullable String msg) {
        emptyContainer.setVisibility(VISIBLE);
        progressBar.setVisibility(GONE);
        tvMsg.setText(msg);
        tvMsg.setVisibility(VISIBLE);
        btnReloading.setVisibility(GONE);
    }

    public void setEmptyLayout(@DrawableRes int resId, @Nullable String msg, @Nullable String btnMsg) {
        emptyContainer.setVisibility(VISIBLE);
        progressBar.setVisibility(GONE);
        ivIcon.setImageResource(resId);
        tvMsg.setText(msg);
        btnReloading.setText(btnMsg);
        ivIcon.setVisibility(VISIBLE);
        tvMsg.setVisibility(VISIBLE);
        btnReloading.setVisibility(VISIBLE);
    }

    @Override
    public void onClick(View v) {
        int resId = v.getId();
        if (resId == R.id.btnReloading) {
            emptyContainer.setVisibility(GONE);
            progressBar.setVisibility(VISIBLE);
        }
    }
}

package com.kang.library.adapter;

import android.view.View;

/**
 * Item点击事件
 */
public interface OnItemClickListener {
    void onItemClick(View view, int position);

    void onItemLongClick(View view, int position);
}
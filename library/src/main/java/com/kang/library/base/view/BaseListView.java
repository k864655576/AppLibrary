package com.kang.library.base.view;

import com.kang.library.adapter.BaseCommAdapter;
import com.kang.library.entity.BaseEntity;

public interface BaseListView<T extends BaseEntity> {

    /**
     * 获取适配器
     */
    BaseCommAdapter<T> getAdapter();

    /**
     * item点击
     */

    void itemClick(Object object, int position);

    /**
     * 结束刷新
     */
    void stopRefreshView();

    /**
     * 加载数据
     */
    void loadingData();
}

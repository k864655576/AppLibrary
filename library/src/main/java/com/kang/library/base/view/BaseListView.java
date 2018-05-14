package com.kang.library.base.view;

import com.kang.library.adapter.BaseCommAdapter;
import com.kang.library.entity.BaseEntity;

public interface BaseListView<T extends BaseEntity> {

    /**
     * 设置是否加载更多
     *
     * @param isLoadMore
     */
    void setLoadMore(boolean isLoadMore);

    /**
     * 设置是否下拉刷新
     *
     * @param isRefresh
     */
    void setRefresh(boolean isRefresh);


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

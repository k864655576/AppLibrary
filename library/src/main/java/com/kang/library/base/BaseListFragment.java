package com.kang.library.base;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.kang.library.adapter.BaseCommAdapter;
import com.kang.library.base.view.BaseListView;
import com.kang.library.entity.BaseEntity;
import com.kang.library.utils.NetUtil;
import com.kang.library.widget.EmptyLayoutView;
import com.kwz.library.R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

public abstract class BaseListFragment<T extends BaseEntity> extends BaseFragment implements BaseListView {
    protected SmartRefreshLayout refreshLayout;
    protected EmptyLayoutView emptyLayoutView;
    protected ListView listView;
    protected int page;
    /**
     * 是否加载更多
     */
    private boolean isLoadMore = true;
    /**
     * 是否下拉刷新
     */
    private boolean isRefresh = true;

    protected BaseCommAdapter baseCommAdapter;

    @Override
    protected void initView(View view) {
        page = getResources().getInteger(R.integer.default_page);
        refreshLayout = view.findViewById(R.id.refreshLayout);
        emptyLayoutView = view.findViewById(R.id.empty_layout_view);
        listView = view.findViewById(R.id.listView);
        baseCommAdapter = getAdapter();
        if (baseCommAdapter != null) {
            listView.setAdapter(baseCommAdapter);
        }

        refreshLayout.setEnableLoadMore(false);
        refreshLayout.setEnableRefresh(false);

        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                page = getResources().getInteger(R.integer.default_page);
                baseCommAdapter.clear();
                loadingData();
            }
        });
        refreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(RefreshLayout refreshlayout) {
                loadingData();
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                itemClick(baseCommAdapter.getListData().get(position), position);
            }
        });

        emptyLayoutView.setOnRetryClickListener(new EmptyLayoutView.OnRetryClickListener() {
            @Override
            public void onClick() {
                refreshLayout.setEnableLoadMore(false);
                refreshLayout.setEnableRefresh(false);
                initData();
            }
        });
    }

    @Override
    protected void initData() {
        if (NetUtil.isNetworkAvailable(getContext())) {
            loadingData();
        } else {
            emptyLayoutView.setEmptyLayout(R.mipmap.neterror, getString(R.string.network_error), getString(R.string.click_retry));
            listView.setVisibility(View.GONE);
        }
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_base_list;
    }

    @Override
    public void stopRefreshView() {
        refreshLayout.finishRefresh();
        refreshLayout.finishLoadMore();
        refreshLayout.setEnableRefresh(isRefresh);
        refreshLayout.setEnableLoadMore(isLoadMore);
        if (baseCommAdapter.getCount() > 0) {
            listView.setVisibility(View.VISIBLE);
            emptyLayoutView.setVisibility(View.GONE);
        } else {
            listView.setVisibility(View.GONE);
            emptyLayoutView.setVisibility(View.VISIBLE);
        }
        emptyLayoutView.setEmptyLayout(R.mipmap.neterror, "暂无信息");
    }


    @Override
    public void setLoadMore(boolean loadMore) {
        isLoadMore = loadMore;
    }

    @Override
    public void setRefresh(boolean refresh) {
        isRefresh = refresh;
    }
}

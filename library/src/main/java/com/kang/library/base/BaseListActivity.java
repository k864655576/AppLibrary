package com.kang.library.base;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.kang.library.adapter.BaseCommAdapter;
import com.kang.library.base.view.BaseListView;
import com.kang.library.entity.BaseEntity;
import com.kang.library.utils.NetUtil;
import com.kang.library.widget.EmptyLayoutView;
import com.kang.library.widget.TitleBarView;
import com.kwz.library.R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

public abstract class BaseListActivity<T extends BaseEntity> extends BaseActivity implements BaseListView {
    protected TitleBarView titleBarView;
    protected SmartRefreshLayout refreshLayout;
    protected EmptyLayoutView emptyLayoutView;
    protected ListView listView;
    protected int page;

    protected BaseCommAdapter baseCommAdapter;

    @Override
    protected void initView() {
        page = getResources().getInteger(R.integer.default_page);
        titleBarView = findViewById(R.id.title_bar);
        refreshLayout = findViewById(R.id.refreshLayout);
        emptyLayoutView = findViewById(R.id.empty_layout_view);
        listView = findViewById(R.id.listView);
        baseCommAdapter = getAdapter();
        if (baseCommAdapter != null) {
            listView.setAdapter(baseCommAdapter);
        }
        //设置是否需要刷新
        refreshLayout.setEnableLoadMore(true);
        refreshLayout.setEnableRefresh(true);

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
    }

    @Override
    protected void initData() {
        if (NetUtil.isNetworkAvailable(this)) {
            loadingData();
        } else {
            emptyLayoutView.setEmptyLayout(R.mipmap.neterror, getString(R.string.network_error));
            listView.setVisibility(View.GONE);
        }
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_base_list;
    }

    @Override
    public void stopRefreshView() {
        refreshLayout.finishRefresh();
        refreshLayout.finishLoadMore();
        if (baseCommAdapter.getCount() > 0) {
            listView.setVisibility(View.VISIBLE);
            emptyLayoutView.setVisibility(View.GONE);
        } else {
            listView.setVisibility(View.GONE);
            emptyLayoutView.setVisibility(View.VISIBLE);
        }
        emptyLayoutView.setEmptyLayout(R.mipmap.neterror, "暂无信息");
    }
}

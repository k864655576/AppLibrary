package com.kwz.applibrary;

import android.os.Handler;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.kang.library.adapter.OnItemClickListener;
import com.kang.library.base.BaseActivity;
import com.kwz.applibrary.adapter.UserRecyclerAdapter;
import com.kwz.entity.UserEntity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class FourActivity extends BaseActivity {
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    private UserRecyclerAdapter userRecyclerAdapter;

    @Override
    protected void initView() {
        userRecyclerAdapter = new UserRecyclerAdapter(context);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(userRecyclerAdapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        userRecyclerAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(context, "short" + position, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemLongClick(View view, int position) {
                Toast.makeText(context, "long" + position, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void initData() {
        showLoadingDialog();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                addData();
                hideLoadingDialog();
            }
        }, 3000);
    }

    public void addData() {
        List<UserEntity> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            UserEntity userEntity = new UserEntity();
            userEntity.setName("数据源" + i);
            list.add(userEntity);
        }

        userRecyclerAdapter.setList(list);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_four;
    }
}

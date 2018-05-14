package com.kwz.applibrary;

import android.os.Handler;

import com.kang.library.adapter.BaseCommAdapter;
import com.kang.library.base.BaseListFragment;
import com.kwz.applibrary.adapter.UserAdapter;
import com.kwz.entity.UserEntity;

import java.util.ArrayList;
import java.util.List;

public class UserFragment<UserEntity> extends BaseListFragment {
    @Override
    public BaseCommAdapter getAdapter() {
        return new UserAdapter(getContext());
    }

    @Override
    public void itemClick(Object object, int position) {

    }

    @Override
    public void loadingData() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                addData();
                stopRefreshView();
            }
        }, 3000);
    }


    public void addData() {
        List<com.kwz.entity.UserEntity> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            com.kwz.entity.UserEntity userEntity = new com.kwz.entity.UserEntity();
            userEntity.setName("数据源" + i);
            list.add(userEntity);
        }

        baseCommAdapter.setList(list);
    }
}

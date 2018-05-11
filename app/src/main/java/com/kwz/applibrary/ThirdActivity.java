package com.kwz.applibrary;

import android.os.Handler;
import android.widget.Toast;

import com.kang.library.adapter.BaseCommAdapter;
import com.kang.library.base.BaseListActivity;
import com.kwz.applibrary.adapter.UserAdapter;
import com.kwz.entity.UserEntity;

import java.util.ArrayList;
import java.util.List;


public class ThirdActivity extends BaseListActivity<UserEntity> {

    @Override
    public BaseCommAdapter getAdapter() {
        return new UserAdapter(context);
    }

    @Override
    public void itemClick(Object object, int position) {
        Toast.makeText(context, ((UserEntity) object).getName(), Toast.LENGTH_SHORT).show();
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


    public void addData(){
        List<UserEntity> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            UserEntity userEntity = new UserEntity();
            userEntity.setName("数据源"+i);
            list.add(userEntity);
        }

        baseCommAdapter.setList(list);
    }
}

package com.kwz.applibrary.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kang.library.adapter.BaseRecyclerAdapter;
import com.kang.library.adapter.BaseViewHolder;
import com.kang.library.adapter.OnItemClickListener;
import com.kwz.applibrary.R;
import com.kwz.entity.UserEntity;

import butterknife.BindView;

public class UserRecyclerAdapter extends BaseRecyclerAdapter<UserEntity> {

    public UserRecyclerAdapter(Context context) {
        super(context);
    }


    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.user_item, parent, false);
        return new UserViewHolder(view, onItemClickListener);
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        UserEntity userEntity = getListData().get(position);
        ((UserViewHolder) holder).tvName.setText(userEntity.getName());
    }

    static class UserViewHolder extends BaseViewHolder {
        @BindView(R.id.tvName)
        TextView tvName;

        UserViewHolder(View itemView, OnItemClickListener onItemClickListener) {
            super(itemView, onItemClickListener);
        }
    }
}

package com.kwz.applibrary.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kang.library.adapter.BaseCommAdapter;
import com.kang.library.entity.BaseEntity;
import com.kwz.applibrary.R;
import com.kwz.entity.UserEntity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UserAdapter extends BaseCommAdapter<UserEntity> {

    public UserAdapter(Context context) {
        super(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder mHolder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.user_item, parent, false);
            mHolder = new ViewHolder(convertView);
            convertView.setTag(mHolder);
        } else {
            mHolder = (ViewHolder) convertView.getTag();
        }
        UserEntity userEntity = getItem(position);
        mHolder.tvName.setText(userEntity.getName());
        return convertView;
    }

    static class ViewHolder {
        @BindView(R.id.tvName)
        TextView tvName;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}

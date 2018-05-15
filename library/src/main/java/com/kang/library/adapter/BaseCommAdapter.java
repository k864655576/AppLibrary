package com.kang.library.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.BaseAdapter;

import com.kang.library.adapter.views.AdapterView;
import com.kang.library.entity.BaseEntity;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseCommAdapter<T extends BaseEntity> extends BaseAdapter implements AdapterView<T> {
    private Context mContext;
    protected LayoutInflater inflater;
    private List<T> listData = new ArrayList<T>();

    public BaseCommAdapter(Context context) {
        this.mContext = context;
        this.inflater = LayoutInflater.from(context);
    }

    /**
     * 设置数据
     *
     * @param listData
     */
    public void setList(List<T> listData) {
        if (listData != null) {
            this.listData.addAll(listData);
        }
        notifyDataSetChanged();
    }

    /**
     * 添加数据
     *
     * @param t
     */
    @Override
    public void addItem(T t) {
        if (null != t) {
            this.listData.add(t);
            notifyDataSetChanged();
        }
    }


    /**
     * 添加数据
     *
     * @param position
     * @param t
     */
    @Override
    public void addItem(int position, T t) {
        if (null != t) {
            this.listData.add(position, t);
            notifyDataSetChanged();
        }
    }

    /**
     * 清理数据
     */
    @Override
    public void clear() {
        this.listData.clear();
        notifyDataSetChanged();
    }

    /**
     * 删除一个
     *
     * @param position
     */
    @Override
    public void removeItem(int position) {
        this.listData.remove(position);
        notifyDataSetChanged();
    }

    public List<T> getListData() {
        return listData;
    }

    protected Context getContext() {
        return mContext;
    }

    @Override
    public int getCount() {
        return listData == null ? 0 : listData.size();
    }

    @Override
    public T getItem(int position) {
        return listData == null ? null : listData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return listData == null ? 0 : position;
    }

}

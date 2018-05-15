package com.kang.library.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;

import com.kang.library.adapter.views.AdapterView;
import com.kang.library.entity.BaseEntity;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseRecyclerAdapter<T extends BaseEntity> extends RecyclerView.Adapter<BaseViewHolder> implements AdapterView<T> {
    private List<T> listData;
    protected LayoutInflater inflater;
    protected Context context;
    protected OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }


    public BaseRecyclerAdapter(Context context) {
        this.inflater = LayoutInflater.from(context);
        this.context = context;
        this.listData = new ArrayList<>();
    }


    public List<T> getListData() {
        return listData;
    }

    public Context getContext() {
        return context;
    }

    @Override
    public int getItemCount() {
        return listData != null ? listData.size() : 0;
    }

    @Override
    public void clear() {
        if (listData != null) {
            listData.clear();
        }
        notifyDataSetChanged();
    }

    @Override
    public void removeItem(int position) {
        if (listData != null && listData.size() > position) {
            listData.remove(position);
            notifyItemRemoved(position);
        }
    }

    @Override
    public void addItem(T t) {
        if (listData != null) {
            listData.add(t);
            notifyItemInserted(0);
        }
    }

    @Override
    public void addItem(int position, T t) {
        if (listData != null) {
            listData.add(position, t);
            notifyItemInserted(position);
        }
    }

    public void setList(List<T> listData) {
        if (listData != null) {
            this.listData.addAll(listData);
        }
        notifyDataSetChanged();
    }
}

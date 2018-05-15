package com.kang.library.adapter.views;


public interface AdapterView<T> {

    void clear();

    void removeItem(int position);

    void addItem(int position, T t);

    void addItem(T t);
}

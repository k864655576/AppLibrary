package com.kang.library.http;

import io.reactivex.disposables.Disposable;

public interface RxActionManager<T> {
    void add(T var1, Disposable var2);

    void remove(T var1);

    void cancel(T var1);
}

package com.kang.library.http;

import android.text.TextUtils;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

public abstract class HttpRxObserver<T> implements Observer<T>, HttpRequestListener {
    private String mTag;

    public HttpRxObserver() {
    }

    public HttpRxObserver(String tag) {
        this.mTag = tag;
    }

    public void onError(Throwable e) {
        RxActionManagerImpl.getInstance().remove(this.mTag);
        if (e instanceof ApiException) {
            this.onError((ApiException) e);
        } else {
            this.onError(new ApiException(e, 1000));
        }

    }

    public void onComplete() {
    }

    public void onNext(@NonNull T t) {
        if (!TextUtils.isEmpty(this.mTag)) {
            RxActionManagerImpl.getInstance().remove(this.mTag);
        }

        try {
            this.onSuccess(t);
        } catch (Exception var3) {
            this.onError(new ApiException(var3, 1001));
        }

    }

    public void onSubscribe(@NonNull Disposable d) {
        if (!TextUtils.isEmpty(this.mTag)) {
            RxActionManagerImpl.getInstance().add(this.mTag, d);
        }

        this.onStart(d);
    }

    public void cancel() {
        if (!TextUtils.isEmpty(this.mTag)) {
            RxActionManagerImpl.getInstance().cancel(this.mTag);
        }
    }

    public boolean isDisposed() {
        return TextUtils.isEmpty(this.mTag) ? true : RxActionManagerImpl.getInstance().isDisposed(this.mTag);
    }

    protected abstract void onStart(Disposable var1);

    protected abstract void onError(ApiException var1);

    protected abstract void onSuccess(T var1);
}

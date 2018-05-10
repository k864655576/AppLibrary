package com.kang.library.http;

import android.annotation.TargetApi;
import android.support.v4.util.ArrayMap;

import io.reactivex.disposables.Disposable;

public class RxActionManagerImpl implements RxActionManager<Object> {
    private static volatile RxActionManagerImpl mInstance;
    private ArrayMap<Object, Disposable> mMaps = new ArrayMap();

    public static RxActionManagerImpl getInstance() {
        if (mInstance == null) {
            Class var0 = RxActionManagerImpl.class;
            synchronized(RxActionManagerImpl.class) {
                if (mInstance == null) {
                    mInstance = new RxActionManagerImpl();
                }
            }
        }

        return mInstance;
    }

    @TargetApi(19)
    private RxActionManagerImpl() {
    }

    @TargetApi(19)
    public void add(Object tag, Disposable disposable) {
        this.mMaps.put(tag, disposable);
    }

    @TargetApi(19)
    public void remove(Object tag) {
        if (!this.mMaps.isEmpty()) {
            this.mMaps.remove(tag);
        }

    }

    @TargetApi(19)
    public void cancel(Object tag) {
        if (!this.mMaps.isEmpty()) {
            if (this.mMaps.get(tag) != null) {
                if (!((Disposable)this.mMaps.get(tag)).isDisposed()) {
                    ((Disposable)this.mMaps.get(tag)).dispose();
                }

                this.mMaps.remove(tag);
            }
        }
    }

    public boolean isDisposed(Object tag) {
        return !this.mMaps.isEmpty() && this.mMaps.get(tag) != null ? ((Disposable)this.mMaps.get(tag)).isDisposed() : true;
    }
}
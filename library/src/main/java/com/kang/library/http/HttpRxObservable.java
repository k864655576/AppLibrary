package com.kang.library.http;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class HttpRxObservable {
    public HttpRxObservable() {
    }

    public static Observable getObservable(Observable<HttpResponse> apiObservable) {
        Observable observable = apiObservable.map(new ServerResultFunction()).onErrorResumeNext(new HttpResultFunction()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        return observable;
    }

    public static Observable getObservableObject(Observable<Object> apiObservable) {
        Observable observable = apiObservable.map(new ServerResultObjectFunction()).onErrorResumeNext(new HttpResultFunction()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        return observable;
    }
}
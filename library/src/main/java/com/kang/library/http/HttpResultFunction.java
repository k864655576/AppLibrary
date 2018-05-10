package com.kang.library.http;

import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;

public class HttpResultFunction<T> implements Function<Throwable, Observable<T>> {
    public HttpResultFunction() {
    }

    public Observable<T> apply(@NonNull Throwable throwable) throws Exception {
        return Observable.error(ExceptionEngine.handleException(throwable));
    }
}
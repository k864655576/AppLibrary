package com.kang.library.http;

import com.google.gson.Gson;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;

public class ServerResultObjectFunction implements Function<Object, Object> {
    public ServerResultObjectFunction() {
    }

    public Object apply(@NonNull Object response) throws Exception {
        if (response == null) {
            throw new ServerException(HttpError.HTTP_EXCEPTION.getType(), HttpError.HTTP_EXCEPTION.getName());
        } else {
            return (new Gson()).toJson(response);
        }
    }
}
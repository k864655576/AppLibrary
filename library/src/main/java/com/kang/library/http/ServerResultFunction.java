package com.kang.library.http;

import com.google.gson.Gson;

import org.json.JSONObject;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;

public class ServerResultFunction implements Function<HttpResponse, Object> {
    public ServerResultFunction() {
    }

    public Object apply(@NonNull HttpResponse response) throws Exception {
        if (!response.isSuccess()) {
            throw new ServerException(HttpError.HTTP_EXCEPTION.getType(), response.getMsg());
        } else {
            JSONObject jsonObject = new JSONObject((new Gson()).toJson(response.getData()));
            jsonObject.put("isLastPage", response.isLastPage());
            return jsonObject.toString();
        }
    }
}
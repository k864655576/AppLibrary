package com.kang.library.http;

import com.google.gson.JsonParseException;
import com.google.gson.stream.MalformedJsonException;
import com.orhanobut.logger.Logger;

import org.json.JSONException;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.text.ParseException;

import retrofit2.HttpException;

public class ExceptionEngine {
    public static final int UN_KNOWN_ERROR = 1000;
    public static final int ANALYTIC_SERVER_DATA_ERROR = 1001;
    public static final int ANALYTIC_CLIENT_DATA_ERROR = 1002;
    public static final int CONNECT_ERROR = 1003;
    public static final int TIME_OUT_ERROR = 1004;

    public ExceptionEngine() {
    }

    public static ApiException handleException(Throwable e) {
        ApiException ex;
        if (e instanceof HttpException) {
            HttpException httpExc = (HttpException)e;
            ex = new ApiException(e, httpExc.code());
            ex.setMsg(HttpError.getName(HttpError.HTTP_EXCEPTION.getType()));
            return ex;
        } else if (e instanceof ServerException) {
            ServerException serverExc = (ServerException)e;
            ex = new ApiException(serverExc, serverExc.getCode());
            ex.setMsg(serverExc.getMsg());
            return ex;
        } else if (!(e instanceof JsonParseException) && !(e instanceof JSONException) && !(e instanceof ParseException) && !(e instanceof MalformedJsonException)) {
            if (e instanceof ConnectException) {
                ex = new ApiException(e, 1003);
                ex.setMsg(HttpError.getName(HttpError.CONNECT_ERROR.getType()));
                return ex;
            } else if (e instanceof SocketTimeoutException) {
                ex = new ApiException(e, 1004);
                ex.setMsg(HttpError.getName(HttpError.TIME_OUT_ERROR.getType()));
                return ex;
            } else {
                ex = new ApiException(e, 1000);
                ex.setMsg(HttpError.getName(HttpError.UN_KNOWN_ERROR.getType()));
                return ex;
            }
        } else {
            ex = new ApiException(e, 1001);
            ex.setMsg(HttpError.getName(HttpError.ANALYTIC_SERVER_DATA_ERROR.getType()));
            return ex;
        }
    }
}


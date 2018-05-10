package com.kang.library.http;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

public class HttpResponse<T> {
    @SerializedName("success")
    private boolean success;
    @SerializedName("data")
    private T data;
    @SerializedName("msg")
    private String msg;
    @SerializedName("isLastPage")
    private boolean isLastPage;

    public HttpResponse() {
    }

    public boolean isSuccess() {
        return this.success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String toString() {
        return "HttpResponse{success=" + this.success + ", data=" + (new Gson()).toJson(this.data) + ", msg='" + this.msg + '\'' + '}';
    }

    public boolean isLastPage() {
        return this.isLastPage;
    }

    public void setLastPage(boolean lastPage) {
        this.isLastPage = lastPage;
    }
}


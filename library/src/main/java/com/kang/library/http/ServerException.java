package com.kang.library.http;

public class ServerException extends RuntimeException {
    private int code;
    private String msg;

    public ServerException(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }

    @Override
    public String toString() {
        return "ServerException{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                '}';
    }
}
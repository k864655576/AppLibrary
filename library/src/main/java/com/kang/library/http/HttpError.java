package com.kang.library.http;

public enum HttpError {
    HTTP_EXCEPTION(2000, "网络错误"),
    ANALYTIC_SERVER_DATA_ERROR(1001, "解析错误"),
    CONNECT_ERROR(1003, "网络连接失败，请先设置网络！"),
    TIME_OUT_ERROR(1004, "网络超时"),
    UN_KNOWN_ERROR(1000, "未知错误");

    private int type;
    private String name;

    HttpError(int type, String name) {
        this.type = type;
        this.name = name;
    }

    public static String getName(int type) {
        HttpError[] httpErrors = values();
        int length = httpErrors.length;

        for (int i = 0; i < length; ++i) {
            HttpError c = httpErrors[i];
            if (c.getType() == type) {
                return c.getName();
            }
        }

        return HTTP_EXCEPTION.name;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}


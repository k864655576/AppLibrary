package com.kang.library.utils;

import com.kang.library.base.BaseEntity;

public class EventBusEntity extends BaseEntity {
    private int type;
    private Object data;

    public EventBusEntity() {
    }

    public EventBusEntity(int type, Object data) {
        this.type = type;
        this.data = data;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}

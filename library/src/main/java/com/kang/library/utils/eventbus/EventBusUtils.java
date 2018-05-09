package com.kang.library.utils.eventbus;

import org.greenrobot.eventbus.EventBus;

public class EventBusUtils {

    private static EventBusUtils instance;

    private EventBusUtils() {

    }

    public static EventBusUtils getInstance() {
        if (instance == null) {
            synchronized (EventBusUtils.class) {
                if (instance == null) {
                    instance = new EventBusUtils();
                }
            }
        }
        return instance;
    }

    /**
     * @param type 消息类型(区别消息)
     * @param data 消息
     */
    public void sendMessage(int type, Object data) {
        EventBus.getDefault().post(createMessage(type, data));
    }

    public void sendMessage(int type) {
        EventBus.getDefault().post(createMessage(type, ""));
    }

    private EventBusEntity createMessage(int type, Object data) {
        return new EventBusEntity(type, data);
    }
}

package com.quyunshuo.eventbus.eventbus2.utils;

import org.greenrobot.eventbus.EventBus;


public class EventBusManager {

    private static EventBusManager instance;

    public static EventBusManager getInstance() {
        if (instance == null) {
            synchronized (EventBusManager.class) {
                if (instance == null) {
                    instance = new EventBusManager();
                }
            }
        }
        return instance;
    }

    private EventBusManager() {

    }


    public void bind(Object subscriber) {
        try {
            EventBus.getDefault().register(subscriber);
        } catch (Throwable e) {
//            e.printStackTrace();
        }
    }


    public void postEvent(Object event) {
        EventBus.getDefault().post(event);
    }


    public void unBind(Object subscriber) {
        EventBus.getDefault().unregister(subscriber);
    }
}

package com.quyunshuo.eventbus.eventbus3;

import org.greenrobot.eventbus.EventBus;

/**
 * @Author: MiYan
 * @Time: 2020/4/1
 * @Class: EventBusUtil
 * @Remark: EventBus封装
 */
public class EventBusUtil {

    public static void register(Object object) {
        EventBus.getDefault().register(object);
    }

    public static void unRegister(Object object) {
        EventBus.getDefault().unregister(object);
    }

    public static void postEvent(Object event) {
        EventBus.getDefault().post(event);
    }

    public static void postStickyEvent(Object event) {
        EventBus.getDefault().postSticky(event);
    }
}

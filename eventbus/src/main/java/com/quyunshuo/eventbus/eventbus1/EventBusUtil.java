package com.quyunshuo.eventbus.eventbus1;



import org.greenrobot.eventbus.EventBus;

/**
 * @Author: MiYan
 * @Time: 2019/8/4 17:24
 * @Description: 描述：EventBus进行简单封装
 */
public class EventBusUtil {
    /**
     * 注册
     *
     * @param subscriber
     */
    public static void register(Object subscriber) {
        EventBus.getDefault().register(subscriber);
    }

    /**
     * 解绑
     *
     * @param subscriber
     */
    public static void unregister(Object subscriber) {
        EventBus.getDefault().unregister(subscriber);
    }

    /**
     * 发送事件
     *
     * @param event
     */
    public static void sendEvent(Event event) {
        EventBus.getDefault().post(event);
    }

    /**
     * 发送粘性事件
     *
     * @param event
     */
    public static void sendStickyEvent(Event event) {
        EventBus.getDefault().postSticky(event);
    }
}

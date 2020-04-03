package com.quyunshuo.eventbus.eventbus2;

/**
 * @Author: MiYan
 * @Time: 2019/9/25 17:01
 * @Description: 描述：作为消息载体
 */
public class EventTest {

    public EventTest(String message) {
        this.message = message;
    }

    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

package com.quyunshuo.eventbus;

/**
 * @Author: MiYan
 * @Time: 2019/8/4 16:45
 * @Description: 描述：
 */
public class MessageEvent {

    private String message;

    public MessageEvent(String message) {
        this.message = message;
    }

    public String getMessage() {

        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

package com.quyunshuo.eventbus.eventbus1;

/**
 * @Author: MiYan
 * @Time: 2019/8/4 17:52
 * @Description: 描述：封装写法
 */
public class Event<T> {
    private int code;
    private T data;

    public Event(int code, T data) {
        this.code = code;
        this.data = data;
    }

    public Event(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}

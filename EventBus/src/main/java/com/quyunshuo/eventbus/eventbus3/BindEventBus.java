package com.quyunshuo.eventbus.eventbus3;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author: MiYan
 * @Time: 2020/4/1
 * @Class: BindEventBus
 * @Remark: 使用注解进行注册
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface BindEventBus {
}

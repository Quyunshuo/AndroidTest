package com.quyunshuo.leakcanary;

import android.content.Context;

/**
 * @Author: MiYan
 * @Time: 2019-12-12
 * @Class: Singleton
 * @Remark: 单例 为了检测内存泄漏
 */
public class Singleton {
    //此变量是静态变量 其生命周期和app一样长 如果持有的Context对象生命周期与单例生命周期更短时，或导致Context无法被释放回收，则有可能造成内存泄漏
    //解决办法:把context改为和Application 生命周期一样长 getApplicationContext()
    private static Singleton singleton;

    private Context context;

    private Singleton(Context context) {
        this.context = context;
    }

    public static Singleton getInstance(Context context) {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {//双重检查锁定
                    singleton = new Singleton(context);
                }
            }
        }
        return singleton;
    }
}
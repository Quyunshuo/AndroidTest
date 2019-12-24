package com.quyunshuo.thread;

import android.util.Log;

import java.util.concurrent.Callable;

import static com.quyunshuo.thread.ConstantKt.TAG;

/**
 * @Author: MiYan
 * @Time: 2019-12-23
 * @Class: MainThread3
 * @Remark:
 */
public class MainThread3 implements Callable {
    @Override
    public Object call() throws Exception {
        Log.d(TAG, "call: 我是实现Callable接口实现的线程类");
        return null;
    }
}

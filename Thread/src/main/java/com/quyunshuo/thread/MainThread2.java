package com.quyunshuo.thread;

import android.util.Log;

import static com.quyunshuo.thread.ConstantKt.TAG;

/**
 * @Author: MiYan
 * @Time: 2019-12-23
 * @Class: MainThread2
 * @Remark:
 */
public class MainThread2 implements Runnable {

    @Override
    public void run() {
        Log.d(TAG, "run: 我是实现Runnable接口实现的线程类");
    }
}

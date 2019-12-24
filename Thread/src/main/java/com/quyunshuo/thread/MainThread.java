package com.quyunshuo.thread;

import android.util.Log;

import static com.quyunshuo.thread.ConstantKt.TAG;

/**
 * @Author: MiYan
 * @Time: 2019-12-23
 * @Class: MainThread
 * @Remark:
 */
public class MainThread extends Thread {
    @Override
    public void run() {
        super.run();
        Log.d(TAG, "run: 我是继承Thread实现的线程类 ");
    }
}

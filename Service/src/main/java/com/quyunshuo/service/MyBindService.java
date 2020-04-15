package com.quyunshuo.service;

import android.app.Service;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

/**
 * @Author: QuYunShuo
 * @Time: 2020/4/15
 * @Class: MyBindService
 * @Remark: 绑定组件的服务
 */
public class MyBindService extends Service {

    private static final String TAG = "miyan";

    private LocalBinder localBinder = new LocalBinder();

    /**
     * Binder内部类 实现前端与服务端的通信
     */
    public class LocalBinder extends Binder {

        public MyBindService getServices() {
            return MyBindService.this;
        }

        public void start() {
            Log.d(TAG, "start:");
        }

        public void end() {
            Log.d(TAG, "end:");
        }
    }

    public String myWay() {
        Log.d(TAG, "myWay:hello world");
        return "hello world";
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.d(TAG, "onBind: ");
        return localBinder;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate: ");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "onStartCommand: ");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void unbindService(ServiceConnection conn) {
        super.unbindService(conn);
        Log.d(TAG, "unbindService: ");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }
}

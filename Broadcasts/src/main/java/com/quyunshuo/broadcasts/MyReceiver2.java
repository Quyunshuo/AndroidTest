package com.quyunshuo.broadcasts;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;

/**
 * @Author: QuYunShuo
 * @Time: 2020/4/16
 * @Class: MyReceiver2
 * @Remark: 动态注册
 */
public class MyReceiver2 extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent != null) {
            String action = intent.getAction();
            if (!TextUtils.isEmpty(action)) {
                if (Intent.ACTION_SCREEN_ON.equalsIgnoreCase(action)) {
                    Log.d("miyan", "屏幕打开");
                } else if (Intent.ACTION_SCREEN_OFF.equalsIgnoreCase(action)) {
                    Log.d("miyan", "屏幕关闭");
                } else if (MainActivity.BROADCAST_ACTION.equals(action)) {
                    Log.d("miyan", "自定义广播");
                }
            }
        }
    }
}

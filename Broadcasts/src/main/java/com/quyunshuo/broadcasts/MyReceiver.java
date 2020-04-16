package com.quyunshuo.broadcasts;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

/**
 * @Author: QuYunShuo
 * @Time: 2020/4/16
 * @Class: MyReceiver
 * @Remark: 静态注册
 */
public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("miyan", "手机已开机");
    }
}

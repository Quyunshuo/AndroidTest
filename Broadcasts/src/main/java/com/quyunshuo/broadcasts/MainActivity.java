package com.quyunshuo.broadcasts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;

/**
 * @Author: QuYunShuo
 * @Time: 2020/4/16
 * @Class: MainActivity
 * @Remark:
 */
public class MainActivity extends AppCompatActivity {

    private MyReceiver2 mReceiver;

    public static final String BROADCAST_ACTION = "BROADCAST_ACTION";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mReceiver = new MyReceiver2();
        IntentFilter intentFilter = new IntentFilter();
        // 屏幕打开
        intentFilter.addAction(Intent.ACTION_SCREEN_ON);
        // 屏幕关闭
        intentFilter.addAction(Intent.ACTION_SCREEN_OFF);
        intentFilter.addAction(BROADCAST_ACTION);
        registerReceiver(mReceiver, intentFilter);

        Intent intent = new Intent();
        intent.setAction(BROADCAST_ACTION);
        sendBroadcast(intent);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(mReceiver);
    }
}

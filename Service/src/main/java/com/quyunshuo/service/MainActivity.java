package com.quyunshuo.service;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.quyunshuo.service.databinding.ActivityMainBinding;

/**
 * @Author: QuYunShuo
 * @Time: 2020/4/15
 * @Class: MainActivity
 * @Remark:
 */
public class MainActivity extends AppCompatActivity {

    private MyBindService services;

    private ServiceConnection serviceConnection;

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initView();
        initData();
    }

    private void initView() {
        binding.mStartService.setOnClickListener(v -> startService(new Intent(this, MyService.class)));

        binding.mStopService.setOnClickListener(v -> stopService(new Intent(this, MyService.class)));

        binding.mStartBindService.setOnClickListener(v -> bindService(new Intent(this, MyBindService.class), serviceConnection, Service.BIND_AUTO_CREATE));

        binding.mStopBindService.setOnClickListener(v -> unbindService(serviceConnection));

        binding.mTransfer.setOnClickListener(v -> {
            if (services != null) {
                services.myWay();
            }
        });
    }

    private void initData() {
        serviceConnection = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder iBinder) {
                MyBindService.LocalBinder binder = (MyBindService.LocalBinder) iBinder;
                binder.start();
                binder.end();
                services = binder.getServices();
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {
                services = null;
                Log.d("miyan", "onServiceDisconnected: ");
            }
        };
    }
}

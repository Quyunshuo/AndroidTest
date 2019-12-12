package com.quyunshuo.leakcanary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //获得Singleton传入this 会造成内存泄漏
        Singleton singleton = Singleton.getInstance(this);
        //正确的写法
//        Singleton singleton = Singleton.getInstance(getApplicationContext());
    }
}

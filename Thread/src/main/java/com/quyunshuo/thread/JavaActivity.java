package com.quyunshuo.thread;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class JavaActivity extends AppCompatActivity {
    int  count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java);
        new Task().start();
        new Task().start();
    }

    class Task extends Thread {
        @Override
        public void run() {
            int temp = count;//获取共享变量的值
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            count = temp + 1;//修改共享变量的值
            Log.d("MiYan", "count value  is:" + count);
        }
    }
}


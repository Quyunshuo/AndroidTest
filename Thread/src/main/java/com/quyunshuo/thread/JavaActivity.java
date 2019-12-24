package com.quyunshuo.thread;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class JavaActivity extends AppCompatActivity {
    int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java);
//        new Task().start();
//        new Task().start();

//        SellTask sellTask = new SellTask();
//        TicketRunnable runnable = new TicketRunnable(sellTask);
//        Thread r1 = new Thread(runnable, "1号业务员");
//        Thread r2 = new Thread(runnable, "2号业务员");
//        Thread r3 = new Thread(runnable, "3号业务员");
//
//        r1.start();
//        r2.start();
//        r3.start();

        ReportTask reportTask = new ReportTask();
        ReportRunnable1 runnable1 = new ReportRunnable1(reportTask);
        ReportRunnable2 runnable2 = new ReportRunnable2(reportTask);
        ReportRunnable3 runnable3 = new ReportRunnable3(reportTask);
        ReportRunnable4 runnable4 = new ReportRunnable4(reportTask);

        Thread s1 = new Thread(runnable1);
        Thread s2 = new Thread(runnable2);
        Thread s3 = new Thread(runnable3);
        Thread s4 = new Thread(runnable4);
        s1.start();
        s2.start();
        s3.start();
        s4.start();
    }

//    class Task extends Thread {
//        @Override
//        public void run() {
//            int temp = count;//获取共享变量的值
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            count = temp + 1;//修改共享变量的值
//            Log.d("MiYan", "count value  is:" + count);
//        }
//    }
}


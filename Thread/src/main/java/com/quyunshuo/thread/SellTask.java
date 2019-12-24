package com.quyunshuo.thread;

import android.util.Log;

class SellTask {
    private int ticket = 20;

    synchronized void sellTicket() {
        if (ticket > 0) {
            try {
//                Thread.sleep(500);
                Log.e("R公司", Thread.currentThread().getName() + "卖了一张票，编号为r" + (ticket--));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
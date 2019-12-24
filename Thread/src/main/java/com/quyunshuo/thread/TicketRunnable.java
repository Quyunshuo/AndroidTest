package com.quyunshuo.thread;

import android.util.Log;

public class TicketRunnable implements Runnable {
    SellTask sellTask;

    public TicketRunnable(SellTask sellTask) {
        this.sellTask = sellTask;
    }

    public void run() {
        for (int i = 0; i < 20; i++) {
            sellTask.sellTicket();
        }
    }
}

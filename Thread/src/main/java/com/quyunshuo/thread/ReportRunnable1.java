package com.quyunshuo.thread;

public class ReportRunnable1 implements Runnable {
    ReportTask task;

    public ReportRunnable1(ReportTask task) {
        this.task = task;
    }

    @Override
    public void run() {
        task.report1();
    }
}

package com.quyunshuo.thread;

public class ReportRunnable2 implements Runnable {
    ReportTask task;

    public ReportRunnable2(ReportTask task) {
        this.task = task;
    }

    @Override
    public void run() {
        task.report2();
    }
}
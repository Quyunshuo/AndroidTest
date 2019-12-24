package com.quyunshuo.thread;

public class ReportRunnable4 implements Runnable {
    ReportTask task;

    public ReportRunnable4(ReportTask task) {
        this.task = task;
    }

    @Override
    public void run() {
        task.report4();
    }
}

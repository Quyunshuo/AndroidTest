package com.quyunshuo.thread;

public class ReportRunnable3 implements Runnable {
    ReportTask task;

    public ReportRunnable3(ReportTask task) {
        this.task = task;
    }

    @Override
    public void run() {
        task.report3();
    }
}

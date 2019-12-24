package com.quyunshuo.thread;

import android.util.Log;

class ReportTask {
    public void report1() {
        synchronized (this) {
            Log.e("R公司", "1号业务员" + "进办公室");
            try {
                Log.e("R公司", "1号业务员" + "开始汇报");
                Thread.sleep(1000);

            } catch (Exception e) {
                e.printStackTrace();
            }
            Log.e("R公司", "1号业务员" + "汇报完毕");
            Log.e("R公司", "1号业务员" + "出办公室");
        }
    }

    public void report2() {
        synchronized (this) {
            Log.e("R公司", "2号业务员" + "进办公室");
            try {
                Log.e("R公司", "2号业务员" + "开始汇报");
                Thread.sleep(1000);

            } catch (Exception e) {
                e.printStackTrace();
            }
            Log.e("R公司", "2号业务员" + "汇报完毕");
            Log.e("R公司", "2号业务员" + "出办公室");
        }
    }

    public void report3() {
        synchronized (this) {
            Log.e("R公司", "3号业务员" + "进办公室");
            try {
                Log.e("R公司", "3号业务员" + "开始汇报");
                Thread.sleep(1000);

            } catch (Exception e) {
                e.printStackTrace();
            }
            Log.e("R公司", "3号业务员" + "汇报完毕");
            Log.e("R公司", "3号业务员" + "出办公室");
        }
    }

    private String tag = "lock";

    public void report4() {
        synchronized (tag) {
            Log.e("R公司", "小T" + "进办公室");
        }
    }
}

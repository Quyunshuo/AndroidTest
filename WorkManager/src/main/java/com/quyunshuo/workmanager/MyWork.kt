package com.quyunshuo.workmanager

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters

/**
 * @Author: MiYan
 * @Time:   2019-12-11
 * @Class:  MyWork
 * @Remark:
 */
class MyWork(context: Context, workerParams: WorkerParameters) : Worker(context, workerParams) {
    override fun doWork(): Result {
        //执行的任务
        Log.d("MyWork", "任务执行")
        return Result.success()
    }
}
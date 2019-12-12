package com.quyunshuo.workmanager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.work.*
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        workManagerTest()
    }

    /**
     * workManagerTest
     */
    private fun workManagerTest() {
        // WorkManager 触发条件
        val constraints = Constraints.Builder()
                //必须在充电条件下
                .setRequiresCharging(true)
                //必须在手机连接网络的情况下
                .setRequiredNetworkType(NetworkType.CONNECTED)
                //电池电量充足
                .setRequiresBatteryNotLow(true)
                .build()
        var request = OneTimeWorkRequest.Builder(MyWork::class.java)
                //设置触发条件
                .setConstraints(constraints)
                //设置延迟
                .setInitialDelay(10, TimeUnit.SECONDS)
                //设置任务的Tag
                .addTag("MyWork Tag")
                .build()
        //将任务提交给系统
        WorkManager.getInstance(this).enqueue(request)
        //实时观察任务的变化
        WorkManager.getInstance(this).getWorkInfoByIdLiveData(request.id).observe(this, Observer<WorkInfo> {
            Log.d("onChanged()->", "workInfo:$it")
        })
    }
}

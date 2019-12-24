package com.quyunshuo.thread

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initThread()
    }

    private fun initThread() {
        MainThread().run()
        MainThread2().run()
        MainThread3().call()
    }
}


package com.quyunshuo.service

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()

    }

    private fun initView() {
        btn_start.setOnClickListener { view ->
            var intent = Intent()
            intent.setClass(this, MyService::class.java)
            startService(intent)
        }
        btn_stop.setOnClickListener { view ->
            intent = Intent(this, MyService::class.java)
            stopService(intent)
        }
    }
}

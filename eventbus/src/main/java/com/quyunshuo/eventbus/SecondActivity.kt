package com.quyunshuo.eventbus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_second.*
import org.greenrobot.eventbus.EventBus

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        button2.setOnClickListener { view ->
            EventBus.getDefault().post(MessageEvent("欢迎来到EventBus"))
            finish()
        }
    }
}

package com.quyunshuo.logutil

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.quyunshuo.logutil.KLog.KLog

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        KLog.d("KLog", "DDDDDDDDDDDDDDD")
    }
}

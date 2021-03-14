package com.quyunshuo.activityanimation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.start_activity_bt).setOnClickListener {
            startActivity(Intent(this, MainActivity2::class.java))
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
        }
    }
}
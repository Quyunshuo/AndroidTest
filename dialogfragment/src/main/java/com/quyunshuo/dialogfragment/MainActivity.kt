package com.quyunshuo.dialogfragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }

    private fun initView() {
        btn_login.setOnClickListener { view ->
            var dialog = MyDialogFragment()
            dialog.show(supportFragmentManager,"")
        }
    }
}

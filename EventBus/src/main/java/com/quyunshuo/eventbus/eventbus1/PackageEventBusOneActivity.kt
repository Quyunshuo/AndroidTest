package com.quyunshuo.eventbus.eventbus1

import android.content.Intent
import android.os.Bundle
import com.quyunshuo.eventbus.R
import kotlinx.android.synthetic.main.activity_package_event_bus_one.*

/**
 * 封装EventBus写法
 */
class PackageEventBusOneActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_package_event_bus_one)
        button.setOnClickListener { view ->
            var intent = Intent(this, PackageEventBusTwoActivity::class.java)
            startActivity(intent)
        }
    }

    /**
     * 重写Base类 订阅
     */
    override fun isRegisterEventBus(): Boolean {
        return true
    }

    override fun receiveEvent(event: Event<*>?) {
        super.receiveEvent(event)
        var string: String = event?.data as String
        textView.text = string
    }
}

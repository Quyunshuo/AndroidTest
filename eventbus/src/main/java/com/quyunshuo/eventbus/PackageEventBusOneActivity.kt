package com.quyunshuo.eventbus

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_package_event_bus_one.*
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

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

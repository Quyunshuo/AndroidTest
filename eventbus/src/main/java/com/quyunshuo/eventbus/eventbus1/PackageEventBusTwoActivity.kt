package com.quyunshuo.eventbus.eventbus1

import android.os.Bundle
import com.quyunshuo.eventbus.R
import kotlinx.android.synthetic.main.activity_package_event_bus_two.*

class PackageEventBusTwoActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_package_event_bus_two)
        button_two.setOnClickListener { view ->
            EventBusUtil.sendEvent(Event(1, "sss"))
            finish()
        }
    }
}

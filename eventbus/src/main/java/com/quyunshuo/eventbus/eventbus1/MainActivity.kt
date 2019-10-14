package com.quyunshuo.eventbus.eventbus1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.quyunshuo.eventbus.R
import kotlinx.android.synthetic.main.activity_main.*
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //注册事件
        EventBus.getDefault().unregister(this)
        initView()
        initEvent()
        jumpActivity()
    }

    /**
     * 注册EventBus
     */
    private fun initEvent() {
        EventBus.getDefault().register(this)
    }

    /**
     * 初始化View
     */
    private fun initView() {
        textView.setText("今天是星期天")
    }

    private fun jumpActivity() {
        button.setOnClickListener { view ->
            var intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }
    }

    /**
     * 在onDestroy()方法里进行解绑
     */
    override fun onDestroy() {
        super.onDestroy()
        if (EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun event(messageEvent: MessageEvent) {
        textView.setText(messageEvent.message)
    }

}

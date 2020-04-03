package com.quyunshuo.eventbus.eventbus2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import com.quyunshuo.eventbus.R;
import com.quyunshuo.eventbus.eventbus2.utils.EventBusManager;

public class EventBus3Activity extends AppCompatActivity {
    Button mBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_bus3);
        initView();
    }

    private void initView() {
        mBtn = findViewById(R.id.main2_btn);
        mBtn.setOnClickListener(view -> {
            //发送EventBus
            EventBusManager.getInstance().postEvent(new EventTest("Send a Message!"));
            finish();
        });
    }
}

package com.quyunshuo.eventbus.eventbus2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.quyunshuo.eventbus.R;
import com.quyunshuo.eventbus.eventbus2.utils.EventBusManager;

import org.greenrobot.eventbus.Subscribe;

public class EventBus2Activity extends AppCompatActivity {
    TextView mTv;
    Button mBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_bus2);
        //绑定
        EventBusManager.getInstance().bind(this);
        initView();
    }

    private void initView() {
        mTv = findViewById(R.id.main_tv);
        mBtn = findViewById(R.id.main_btn);
        mBtn.setOnClickListener(v -> {
            Intent intent = new Intent(EventBus2Activity.this, EventBus3Activity.class);
            startActivity(intent);
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //解绑
        EventBusManager.getInstance().unBind(this);
    }

    @Subscribe
    public void getEvent(EventTest event) {
        mTv.setText(event.getMessage());
    }

}

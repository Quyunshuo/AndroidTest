package com.quyunshuo.eventbus.eventbus3;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.quyunshuo.eventbus.R;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

@BindEventBus
public class EventActivity extends BaseActivity {

    public static final String TAG = "miyan";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
        findViewById(R.id.sendEvent).setOnClickListener(v -> {
            EventBusUtil.postStickyEvent(new MainEvent());
            EventBusUtil.postStickyEvent(new Event2());
            startActivity(new Intent(this, Event2Activity.class));
        });
    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void getEvent(MainEvent event) {
        Log.d(TAG, "EventActivity -> getEvent:");
    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void getEvent2(Event2 event) {
        Log.d(TAG, "EventActivity -> getEvent2:");
    }
}

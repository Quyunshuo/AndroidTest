package com.quyunshuo.eventbus.eventbus3;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.quyunshuo.eventbus.R;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

@BindEventBus
public class Event2Activity extends BaseActivity {

    public static final String TAG = "miyan";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
        findViewById(R.id.sendEvent).setOnClickListener(v -> startActivity(new Intent(this, Event3Activity.class)));
        removeEvent();
    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void getEvent(MainEvent event) {
        Log.d(TAG, "Event2Activity -> getEvent:");
    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void getEvent2(Event2 event) {
        Log.d(TAG, "Event2Activity -> getEvent2:");
    }

    private void removeEvent() {
        Event2 stickyEvent = EventBus.getDefault().getStickyEvent(Event2.class);
        if (stickyEvent != null) {
            Log.d(TAG, "removeEvent: 获取到StickyEvent");
        }
        Event2 event2 = EventBus.getDefault().removeStickyEvent(Event2.class);
        if (event2 != null) {
            Log.d(TAG, "removeEvent: 事件已发布");
        }
        Event2 stickyEvent1 = EventBus.getDefault().getStickyEvent(Event2.class);
        if (stickyEvent1 == null) {
            Log.d(TAG, "removeEvent: 事件已被删除");
        }
    }
}

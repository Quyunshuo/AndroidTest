package com.quyunshuo.eventbus.eventbus3;

import android.os.Bundle;
import android.util.Log;

import com.quyunshuo.eventbus.R;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

@BindEventBus
public class Event3Activity extends BaseActivity {

    public static final String TAG = "miyan";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event3);
    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void getEvent(MainEvent event) {
        Log.d(TAG, "Event3Activity -> getEvent:");
    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void getEvent2(Event2 event) {
        Log.d(TAG, "Event3Activity -> getEvent2:");
    }
}

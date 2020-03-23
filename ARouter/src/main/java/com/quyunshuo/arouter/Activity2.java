package com.quyunshuo.arouter;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

@Route(path = RouterUrl.urlActivity2)
public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        findViewById(R.id.tv_1).setOnClickListener(v -> ARouter.getInstance().build(RouterUrl.urlActivity1).navigation());
    }
}

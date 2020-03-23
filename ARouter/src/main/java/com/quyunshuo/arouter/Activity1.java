package com.quyunshuo.arouter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

@Route(path = RouterUrl.urlActivity1)
public class Activity1 extends AppCompatActivity {

    @Autowired(name = RouterUrl.STRING_TOAST)
    String mToastStr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);
        ARouter.getInstance().inject(this);
        Toast.makeText(this, mToastStr, Toast.LENGTH_SHORT).show();
        findViewById(R.id.tv_1).setOnClickListener(v -> ARouter.getInstance().build(RouterUrl.urlActivity2).navigation());
    }
}

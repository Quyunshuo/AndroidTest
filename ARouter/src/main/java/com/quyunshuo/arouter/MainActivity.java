package com.quyunshuo.arouter;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.launcher.ARouter;

public class MainActivity extends AppCompatActivity {

    @Autowired
    Activity3Service activity3Service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ARouter.getInstance().inject(this);
        findViewById(R.id.tv_1).setOnClickListener(v ->
                ARouter.getInstance().build("/1/3")
                        .withString(RouterUrl.STRING_TOAST, "MainActivity")
                        .navigation());
//                        .navigation(this, new NavigationCallback() {
//                            @Override
//                            public void onFound(Postcard postcard) {
//                                Log.d("miyan", "找到了");
//                            }
//
//                            @Override
//                            public void onLost(Postcard postcard) {
//                                Log.d("miyan", "找不到了");
//                                runOnUiThread(() -> Toast.makeText(MainActivity.this, "未找到界面", Toast.LENGTH_SHORT).show());
//
//                            }
//
//                            @Override
//                            public void onArrival(Postcard postcard) {
//                                Log.d("miyan", "跳转完了");
//
//                            }
//
//                            @Override
//                            public void onInterrupt(Postcard postcard) {
//                                Log.d("miyan", "被拦截了");
//                                runOnUiThread(() -> Toast.makeText(MainActivity.this, "未登陆", Toast.LENGTH_SHORT).show());
//                            }
//                        }));
        findViewById(R.id.tv_2).setOnClickListener(v -> ARouter.getInstance().build(RouterUrl.urlActivity2).navigation());

        findViewById(R.id.tv_3).setOnClickListener(v -> activity3Service.startActivity3(this));
    }
}

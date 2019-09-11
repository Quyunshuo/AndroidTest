package com.quyunshuo.lottie;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import com.airbnb.lottie.LottieAnimationView;

public class MainActivity extends AppCompatActivity {
    private LottieAnimationView lottieAnimationView;
    private Button button1, button2, button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        button1 = findViewById(R.id.button_1);
        button2 = findViewById(R.id.button_2);
        button3 = findViewById(R.id.button_3);
        button1.setOnClickListener(v -> lottieAnimationView.playAnimation()); //开始
        button2.setOnClickListener(v -> lottieAnimationView.pauseAnimation()); //暂停
        button3.setOnClickListener(v -> lottieAnimationView.cancelAnimation()); //取消 貌似和暂停没啥区别
        lottieAnimationView = findViewById(R.id.lottie_view);
        lottieAnimationView.setImageAssetsFolder("images/"); //依赖的图片资源的位置
        lottieAnimationView.setAnimation("data.json"); //json数据
        lottieAnimationView.loop(true); //循环
    }
}

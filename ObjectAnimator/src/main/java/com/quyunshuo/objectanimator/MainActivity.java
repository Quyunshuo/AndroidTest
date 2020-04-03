package com.quyunshuo.objectanimator;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

    }

    /**
     * 初始化View
     */
    private void initView() {
        textView = findViewById(R.id.text_view1);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showAnimator();
            }
        });
    }

    /***
     * 显示动画
     */
    private void showAnimator() {
////        5s内TextView变为全透明再变为原状
//        ObjectAnimator animator = ObjectAnimator.ofFloat(textView, "alpha", 1f, 0f, 1f);
//        animator.setDuration(5000);
//        animator.start();
//        让TextView旋转360度
        ObjectAnimator animator2 = ObjectAnimator.ofFloat(textView, "rotation", 0f, 360f);
        animator2.setDuration(1000);
        animator2.start();

    }
}

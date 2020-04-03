package com.quyunshuo.animation;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

//属性动画
public class Main2Activity extends AppCompatActivity {
    private Button button;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
//        final ValueAnimator animator = ValueAnimator.ofInt(0, 400);
//        animator.setDuration(1000);
//        //添加监听
//        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//            @Override
//            public void onAnimationUpdate(ValueAnimator valueAnimator) {
//                int curValue = (int) animator.getAnimatedValue();
//                Log.d("MiYan", "curValue:" + curValue);
//            }
//        });
//        animator.start();
        initView();


    }

    private void initView() {
        button = findViewById(R.id.button);
        textView = findViewById(R.id.textView);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doAnimation();
            }
        });
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Main2Activity.this, "Animation", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void doAnimation() {
        ValueAnimator valueAnimator = ValueAnimator.ofInt(0, 400);
        valueAnimator.setDuration(3000);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int curValue = (int) valueAnimator.getAnimatedValue();
                textView.layout(curValue, curValue, curValue + textView.getWidth(),
                        curValue + textView.getHeight());
            }
        });
        valueAnimator.start();
    }
}

package com.quyunshuo.animation;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.widget.Button;

public class Main3Activity extends AppCompatActivity {
    private Button start, anim, cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        initView();
    }

    private void initView() {
        start = findViewById(R.id.button1);
        anim = findViewById(R.id.button2);
        cancel = findViewById(R.id.button3);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                initAnimation();
                initArgbAnimation();
            }
        });
    }

    private void initAnimation() {
        final ValueAnimator animator = ValueAnimator.ofInt(100, 600);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                //获取动画变化过程中的值
                int curValue = (int) animator.getAnimatedValue();
                anim.layout(anim.getLeft(), curValue, anim.getRight(), curValue + anim.getHeight());
            }
        });
        //动画持续时长
        animator.setDuration(3000);
        //设置Evaluator
        animator.setEvaluator(new MyEvalutor());
        //增加插值器
//        animator.setInterpolator(new MyInterploator());
        //启动动画
        animator.start();
    }

    private void initArgbAnimation() {
        final ValueAnimator argbAnim = ValueAnimator.ofInt(0xffffff00, 0xff0000ff);
        argbAnim.setEvaluator(new ArgbEvaluator());
        argbAnim.setDuration(5000);
        argbAnim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int curValue = (int) argbAnim.getAnimatedValue();
                anim.setBackgroundColor(curValue);
            }
        });
        argbAnim.start();
    }
}

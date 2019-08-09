package com.quyunshuo.animation;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationSet;
import android.widget.Button;

public class AnimationSetActivity extends AppCompatActivity {
    private Button btn1, btn2, btn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation_set);
        initView();

    }

    private void initView() {
        btn1 = findViewById(R.id.button1);
        btn2 = findViewById(R.id.button2);
        btn3 = findViewById(R.id.button3);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doPlaySequentiallyAnimation();
            }
        });
    }

    private void doPlaySequentiallyAnimation() {
        ObjectAnimator btn2BgAnimation = ObjectAnimator.ofInt(btn2,
                "BackgroundColor", 0xffff00ff, 0xffffff00, 0xffff00ff);
        ObjectAnimator btn2TranslateY = ObjectAnimator.ofFloat(btn2,
                "translationY", 0, 300, 0);
        ObjectAnimator btn3TranslateY = ObjectAnimator.ofFloat(btn3,
                "translationY", 0, 400, 0);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(btn2BgAnimation, btn2TranslateY, btn3TranslateY);
        animatorSet.setDuration(2000);
        animatorSet.start();
    }
}

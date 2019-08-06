package com.quyunshuo.animation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.TextView;

//补间动画
public class MainActivity extends AppCompatActivity {


    private Button btn;
    private TextView textView;
    Animation scaleAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
//        initAnimation();
    }

    /**
     * 通过xml文件的方式添加动画
     */
    private void initAnimation() {
        scaleAnimation = AnimationUtils.loadAnimation(this, R.anim.scaleanim);
    }

    private void initView() {
        textView = findViewById(R.id.tv);
        btn = findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                textView.startAnimation(scaleAnimation);

//                //ScaleAnimation
//                ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.4f,
//                        0.0f, 1.4f, Animation.RELATIVE_TO_SELF, 1.5f,
//                        Animation.RELATIVE_TO_SELF, 0.5f);
//                scaleAnimation.setDuration(700);
//                textView.startAnimation(scaleAnimation);

                //AlphaAnimation
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(1500);
                textView.startAnimation(alphaAnimation);

                //AnimationSet
                AlphaAnimation alphaAnim = new AlphaAnimation(1.0f, 0.1f);
                ScaleAnimation scaleAnim = new ScaleAnimation(0.0f, 1.4f,
                        0.0f, 1.4f, Animation.RELATIVE_TO_SELF, 0.5f,
                        Animation.RELATIVE_TO_SELF, 0.5f);
                RotateAnimation rotateAnim = new RotateAnimation(0,
                        720, Animation.RELATIVE_TO_SELF, 0.5f,
                        Animation.RELATIVE_TO_SELF, 0.5f);
                AnimationSet setAnim = new AnimationSet(true);
                setAnim.addAnimation(alphaAnim);
                setAnim.addAnimation(scaleAnim);
                setAnim.addAnimation(rotateAnim);
                setAnim.setDuration(3000);
                setAnim.setFillAfter(true);
                textView.startAnimation(setAnim);
            }
        });
    }
}

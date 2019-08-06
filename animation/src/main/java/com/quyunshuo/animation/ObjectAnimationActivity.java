package com.quyunshuo.animation;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ObjectAnimationActivity extends AppCompatActivity {
    private Button start, anim, cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        initView();
    }

    private void objectAnimation() {
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(anim, "alpha", 1, 0, 1);
        objectAnimator.setDuration(1500);
        objectAnimator.start();
    }

    private void initView() {
        start = findViewById(R.id.button1);
        anim = findViewById(R.id.button2);
        cancel = findViewById(R.id.button3);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                objectAnimation();
            }
        });
    }


}

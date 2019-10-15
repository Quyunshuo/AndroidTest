package com.quyunshuo.customview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.FrameLayout;

import com.quyunshuo.customview.view.MyView;
import com.quyunshuo.customview.view.MyViewFour;
import com.quyunshuo.customview.view.MyViewThree;
import com.quyunshuo.customview.view.MyViewTwo;

public class MainActivity extends AppCompatActivity {
    private FrameLayout root;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initDraw();
    }

    private void initView() {
        root = findViewById(R.id.frame_layout);
    }

    private void initDraw() {
//        root.addView(new MyView(this));
//        root.addView(new MyViewTwo(this));
//        root.addView(new MyViewThree(this));
        root.addView(new MyViewFour(this));
    }
}

package com.quyunshuo.customview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;

import com.quyunshuo.customview.view.MyRegionView;
import com.quyunshuo.customview.view.MyView;
import com.quyunshuo.customview.view.MyViewFour;
import com.quyunshuo.customview.view.MyViewSix;
import com.quyunshuo.customview.view.MyViewThree;
import com.quyunshuo.customview.view.MyViewTwo;
import com.quyunshuo.customview.view.RippleView;

public class MainActivity extends AppCompatActivity {
    private FrameLayout root;
    private MyViewSix myView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initDraw();
    }

    private void initView() {
//        root = findViewById(R.id.frame_layout);
//        myView = findViewById(R.id.my_view);
//        findViewById(R.id.reset).setOnClickListener(new OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                myView.reset();
//            }
//        });
        final RippleView myView = findViewById(R.id.right_view);
        myView.startAnim();
    }

    private void initDraw() {
//        root.addView(new MyView(this));
//        root.addView(new MyViewTwo(this));
//        root.addView(new MyViewThree(this));
//        root.addView(new MyViewFour(this));
//        root.addView(new MyRegionView(this));
    }
}

package com.quyunshuo.toast;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.quyunshuo.toast.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initView();
    }

    private void initView() {
        // 自定义位置
        binding.btn1.setOnClickListener(v -> {
            Toast toast = Toast.makeText(this, "Toast", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
        });

        // 自定义图片
        binding.btn2.setOnClickListener(v -> {
            Toast toast = Toast.makeText(this, "Toast", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0, 0);

            ImageView imageView = new ImageView(this);
            imageView.setImageResource(R.drawable.ic_launcher_foreground);

            LinearLayout view = (LinearLayout) toast.getView();
            view.setOrientation(LinearLayout.HORIZONTAL);
            view.addView(imageView, 1);
            view.setGravity(Gravity.CENTER);
            toast.show();
        });

        // 自定义布局
        binding.btn3.setOnClickListener(v -> {
            Toast toast = Toast.makeText(this, "Toast", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.setView(getLayoutInflater().inflate(R.layout.toast_layout, null, false));
            toast.show();
        });
    }
}

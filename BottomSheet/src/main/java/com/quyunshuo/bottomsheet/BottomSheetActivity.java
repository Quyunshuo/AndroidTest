package com.quyunshuo.bottomsheet;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.quyunshuo.bottomsheet.databinding.ActivityMainBinding;

/**
 * @Author: QuYunShuo
 * @Time: 2020/4/14
 * @Class: BottomSheetActivity
 * @Remark: BottomSheet实现之BottomSheetBehavior
 * <p>
 * 特点：显示状态也可以点击原布局内容进行交互 无蒙版 点击布局外区域 该布局不会自动关闭
 * <p>
 * BottomSheetBehavior的5种状态:
 * <p>
 * STATE_EXPANDED 展开状态, 显示完整布局
 * STATE_COLLAPSED 折叠状态,折叠到peekHeight所指定的高度
 * STATE_DRAGGING 拖拽时的状态
 * STATE_HIDDEN 隐藏状态
 * STATE_SETTLING 释放状态
 */
public class BottomSheetActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initView();
    }

    private void initView() {
        BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.from(binding.bottomSheetLayout.bottomSheetLayout);
        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);
        bottomSheetBehavior.setHideable(true);
        bottomSheetBehavior.addBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                Log.d("miyan", "onStateChanged: ");
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {
                Log.d("miyan", "onSlide: ");
            }
        });
        binding.bottomSheetLayout.manTtv.setOnClickListener(v -> {
            Toast.makeText(this, "男", Toast.LENGTH_SHORT).show();
            bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
        });
        binding.bottomSheetLayout.womanTtv.setOnClickListener(v -> {
            Toast.makeText(this, "女", Toast.LENGTH_SHORT).show();
            bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
        });
        binding.switchTv.setOnClickListener(v -> {
            if (bottomSheetBehavior.getState() == BottomSheetBehavior.STATE_EXPANDED) {
                bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
            } else {
                bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
            }
        });
        binding.startBottomSheetDialogActivity.setOnClickListener(v -> startActivity(new Intent(this, BottomSheetDialogActivity.class)));
    }
}

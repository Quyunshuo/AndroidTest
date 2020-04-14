package com.quyunshuo.bottomsheet;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.quyunshuo.bottomsheet.databinding.ActivityBottomSheetDialogBinding;
import com.quyunshuo.bottomsheet.databinding.BottomSheetLayoutBinding;

/**
 * @Author: QuYunShuo
 * @Time: 2020/4/14
 * @Class: BottomSheetDialogActivity
 * @Remark: BottomSheet实现之BottomSheetDialog
 * 特点: 与Dialog状态一样 打开后有蒙版 不可操作区域外 默认点击区域外关闭该Dialog
 */
public class BottomSheetDialogActivity extends AppCompatActivity {

    private ActivityBottomSheetDialogBinding binding;

    private BottomSheetDialog bottomSheetDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBottomSheetDialogBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initView();
    }

    private void initView() {
        binding.showDialog.setOnClickListener(v -> showBottomSheetDialog());
    }

    private void showBottomSheetDialog() {
        if (bottomSheetDialog == null) {
            // 要设置圆角就必须要设置dialog的主题背景为透明 R.style.BottomSheetDialog
            bottomSheetDialog = new BottomSheetDialog(this, R.style.BottomSheetDialog);
            //默认Cancelable和CanceledOnTouchOutside均为true
            //bottomSheetDialog.setCancelable(true);
            //bottomSheetDialog.setCanceledOnTouchOutside(true);
            //为Dialog设置布局
            bottomSheetDialog.setContentView(R.layout.bottom_sheet_layout);
            View manTv = bottomSheetDialog.findViewById(R.id.man_ttv);
            if (manTv != null) {
                manTv.setOnClickListener(v -> {
                    Toast.makeText(this, "男", Toast.LENGTH_SHORT).show();
                    bottomSheetDialog.dismiss();
                });
            }
            View womanTv = bottomSheetDialog.findViewById(R.id.woman_ttv);
            if (womanTv != null) {
                womanTv.setOnClickListener(v -> {
                    Toast.makeText(this, "女", Toast.LENGTH_SHORT).show();
                    bottomSheetDialog.dismiss();
                });
            }
        }
        bottomSheetDialog.show();
    }
}

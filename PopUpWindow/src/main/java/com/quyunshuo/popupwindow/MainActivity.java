package com.quyunshuo.popupwindow;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import com.quyunshuo.popupwindow.databinding.ActivityMainBinding;

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
        // 中间 (中下)
        binding.settingImg.setOnClickListener(v -> {
            View popView = View.inflate(this, R.layout.pop_layout, null);
            PopupWindow popupWindow = new PopupWindow(popView, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            popView.measure(makeDropDownMeasureSpec(popupWindow.getWidth()), makeDropDownMeasureSpec(popupWindow.getHeight()));
            popupWindow.setBackgroundDrawable(getResources().getDrawable(R.drawable.pop_layout_bg));
            popupWindow.setOutsideTouchable(true);
            int offsetX = (binding.settingImg.getWidth() - popupWindow.getContentView().getMeasuredWidth()) / 2;
            int offsetY = 0;
            popupWindow.showAsDropDown(binding.settingImg, offsetX, offsetY, Gravity.START);
        });

        // 左上 (右下)
        binding.settingImgTopStart.setOnClickListener(v -> {
            View popView = View.inflate(this, R.layout.pop_layout, null);
            PopupWindow popupWindow = new PopupWindow(popView, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            popView.measure(makeDropDownMeasureSpec(popupWindow.getWidth()), makeDropDownMeasureSpec(popupWindow.getHeight()));
            popupWindow.setBackgroundDrawable(getResources().getDrawable(R.drawable.pop_layout_bg));
            popupWindow.setOutsideTouchable(true);
            int offsetX = 0;
            int offsetY = 0;
            popupWindow.showAsDropDown(binding.settingImgTopStart, offsetX, offsetY, Gravity.END);
        });

        // 右上 (左下 )
        binding.settingImgTopEnd.setOnClickListener(v -> {
            View popView = View.inflate(this, R.layout.pop_layout, null);
            PopupWindow popupWindow = new PopupWindow(popView, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            popView.measure(makeDropDownMeasureSpec(popupWindow.getWidth()), makeDropDownMeasureSpec(popupWindow.getHeight()));
            popupWindow.setBackgroundDrawable(getResources().getDrawable(R.drawable.pop_layout_bg));
            popupWindow.setOutsideTouchable(true);
            int offsetX = -popupWindow.getContentView().getMeasuredWidth();
            int offsetY = 0;
            popupWindow.showAsDropDown(binding.settingImgTopEnd, offsetX, offsetY, Gravity.START);
        });

        // 左下 (右上)
        binding.settingImgBottomStart.setOnClickListener(v -> {
            View popView = View.inflate(this, R.layout.pop_layout, null);
            PopupWindow popupWindow = new PopupWindow(popView, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            popView.measure(makeDropDownMeasureSpec(popupWindow.getWidth()), makeDropDownMeasureSpec(popupWindow.getHeight()));
            popupWindow.setBackgroundDrawable(getResources().getDrawable(R.drawable.pop_layout_bg));
            popupWindow.setOutsideTouchable(true);
            int offsetX = 0;
            int offsetY = -(binding.settingImgTopEnd.getHeight() + popupWindow.getContentView().getMeasuredHeight());
            popupWindow.showAsDropDown(binding.settingImgBottomStart, offsetX, offsetY, Gravity.END);
        });

        // 右下 (左上)
        binding.settingImgBottomEnd.setOnClickListener(v -> {
            View popView = View.inflate(this, R.layout.pop_layout, null);
            PopupWindow popupWindow = new PopupWindow(popView, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            popView.measure(makeDropDownMeasureSpec(popupWindow.getWidth()), makeDropDownMeasureSpec(popupWindow.getHeight()));
            popupWindow.setBackgroundDrawable(getResources().getDrawable(R.drawable.pop_layout_bg));
            popupWindow.setOutsideTouchable(true);
            int offsetX = -popupWindow.getContentView().getMeasuredWidth();
            int offsetY = -(binding.settingImgTopEnd.getHeight() + popupWindow.getContentView().getMeasuredHeight());
            popupWindow.showAsDropDown(binding.settingImgBottomEnd, offsetX, offsetY, Gravity.START);
        });
    }

    /**
     * 测量view宽高
     */
    private static int makeDropDownMeasureSpec(int measureSpec) {
        int mode;
        if (measureSpec == ViewGroup.LayoutParams.WRAP_CONTENT) {
            mode = View.MeasureSpec.UNSPECIFIED;
        } else {
            mode = View.MeasureSpec.EXACTLY;
        }
        return View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(measureSpec), mode);
    }
}

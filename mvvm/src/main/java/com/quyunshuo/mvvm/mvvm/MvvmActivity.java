package com.quyunshuo.mvvm.mvvm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.app.Activity;
import android.os.Bundle;

import com.quyunshuo.mvvm.BR;
import com.quyunshuo.mvvm.R;
import com.quyunshuo.mvvm.databinding.ActivityMvvmBinding;

public class MvvmActivity extends AppCompatActivity {
    private ActivityMvvmBinding binding;
    private MvvmViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_mvvm);
        viewModel = new MvvmViewModel(getApplication());
        binding.setViewModel(viewModel);
    }
}

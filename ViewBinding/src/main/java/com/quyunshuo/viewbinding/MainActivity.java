package com.quyunshuo.viewbinding;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.quyunshuo.viewbinding.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 视图绑定
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        intiView();
    }

    private void intiView() {
        binding.backImg.setOnClickListener(v -> Toast.makeText(this, "Back", Toast.LENGTH_SHORT).show());
        binding.titleTv.setOnClickListener(v -> Toast.makeText(this, "Title", Toast.LENGTH_SHORT).show());
        binding.contentTv.setOnClickListener(v -> Toast.makeText(this, "ViewBinding", Toast.LENGTH_SHORT).show());
    }
}

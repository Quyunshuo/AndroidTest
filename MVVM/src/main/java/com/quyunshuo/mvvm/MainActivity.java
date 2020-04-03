package com.quyunshuo.mvvm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.ToolbarBindingAdapter;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.quyunshuo.mvvm.bean.Account;
import com.quyunshuo.mvvm.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private Account account;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //使用DataBinding布局会自动生成此类
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        account = new Account("李品", 19);
        //对DataBinding布局中的属性进行初始化
        binding.setAccount(account);
        binding.setActivity(this);
    }

    public void onClick(View view) {
//        Toast.makeText(this, "点击", Toast.LENGTH_SHORT).show();
        int grade = account.getGrade();
        account.setGrade(grade + 1);
//        binding.setAccount(account);
    }
}

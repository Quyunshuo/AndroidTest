package com.quyunshuo.javareflection;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.quyunshuo.javareflection.databinding.ActivityMainBinding;

/**
 * @Author: MiYan
 * @Time: 2020/4/2
 * @Class: MainActivity
 * @Remark: Java 反射机制
 */
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
        binding.goToTv.setOnClickListener(V -> {
            initReflection();
        });
    }

    private void initReflection() {
        // 创建对象
        ReflectClass.reflectNewInstance();

        // 反射私有的构造方法
        ReflectClass.reflectPrivateConstructor();

        // 反射私有属性
        ReflectClass.reflectPrivateField();

        // 反射私有方法
        ReflectClass.reflectPrivateMethod();

        ReflectClass.shutdownOrReboot(false, true);

        Log.d("miyan", "zenmode = " + ReflectClass.getZenMode());
    }
}

package com.quyunshuo.bottomnavigationbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationBar bottomNavigationBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        bottomNavigationBar = findViewById(R.id.bottom);
        bottomNavigationBar.setMode(BottomNavigationBar.MODE_FIXED)               //设置点击动画效果
                .setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_RIPPLE)    //背景样式
                .setBarBackgroundColor("#2FA8E1")                                   // 背景颜色
                .setInActiveColor("#929292")                                        // 未选中状态颜色
                .setActiveColor("#ffffff")                                          // 选中状态颜色
                .addItem(new BottomNavigationItem(R.drawable.ic_launcher_foreground, "One") //添加Item
                        .setInactiveIconResource(R.drawable.ic_launcher_background))
                .addItem(new BottomNavigationItem(R.drawable.ic_launcher_foreground, "Two") //添加Item
                        .setInactiveIconResource(R.drawable.ic_launcher_background))
                .addItem(new BottomNavigationItem(R.drawable.ic_launcher_foreground, "Three") //添加Item
                        .setInactiveIconResource(R.drawable.ic_launcher_background))
                .addItem(new BottomNavigationItem(R.drawable.ic_launcher_foreground, "Fore") //添加Item
                        .setInactiveIconResource(R.drawable.ic_launcher_background)
                        .setActiveColor("#929292")                                  // 可单独定制选中颜色
                        .setInActiveColor("#ffffff"))
                .setFirstSelectedPosition(0)                                        //设置默认选中位置
                .setTabSelectedListener(new BottomNavigationBar.OnTabSelectedListener() {
                    @Override
                    public void onTabSelected(int position) {
                        //当前选中的Item
                        switch (position) {
                            case 0:
                                Toast.makeText(MainActivity.this, "One", Toast.LENGTH_SHORT).show();
                                break;
                            case 1:
                                Toast.makeText(MainActivity.this, "Two", Toast.LENGTH_SHORT).show();

                                break;
                            case 2:
                                Toast.makeText(MainActivity.this, "Three", Toast.LENGTH_SHORT).show();

                                break;
                            case 3:
                                Toast.makeText(MainActivity.this, "Four", Toast.LENGTH_SHORT).show();
                                break;
                            default:
                                break;
                        }
                    }

                    @Override
                    public void onTabUnselected(int position) {

                    }

                    @Override
                    public void onTabReselected(int position) {
                        //重复选择的Item
                    }
                })
                .initialise();                                                      //提交初始化(完成配置)

    }
}

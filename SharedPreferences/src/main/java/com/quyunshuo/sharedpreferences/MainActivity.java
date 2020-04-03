package com.quyunshuo.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button btn;
    private TextView textView;
    private SharedPreferences sp;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initView() {
        btn = findViewById(R.id.btn);
        textView = findViewById(R.id.textView);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                String one = sp.getString("1", "136854");
//                Boolean one = sp.getBoolean("1", false);

                textView.setText("");
            }
        });

    }

    private void initData() {
        sp = getSharedPreferences("test", MODE_PRIVATE);
        editor = sp.edit();
        editor.putString("1", "one");
        editor.putString("2", "two");
        editor.putBoolean("1", true);
        editor.putInt("1", 1);
//        editor.putString("1", "第二次赋值");
        editor.apply();
    }
}

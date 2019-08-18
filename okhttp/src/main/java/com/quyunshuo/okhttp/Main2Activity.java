package com.quyunshuo.okhttp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Main2Activity extends AppCompatActivity {
    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();
        senHttp();
    }

    private void initView() {
        mTextView = findViewById(R.id.text);
    }

    private void senHttp() {
        OkHttpClient okHttpClient = new OkHttpClient();
        //现在的sdk强制使用https 如果想使用明文需要进行配置
        Request request = new Request.Builder().url("https://www.baidu.com").build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.d("MiYan", "onFailure: 失败");
            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                Log.d("MiYan", "onResponse: 成功");
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mTextView.setText(response.toString());

                    }
                });
            }
        });
    }
}



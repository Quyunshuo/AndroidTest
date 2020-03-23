package com.quyunshuo.arouter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class Activity3 extends AppCompatActivity {

    public static void start(Context context) {
        Intent intent = new Intent(context, Activity3.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);
    }
}

package com.quyunshuo.mvp.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.quyunshuo.mvp.MainContract;
import com.quyunshuo.mvp.R;
import com.quyunshuo.mvp.presenter.WeatherPresenter;

/**
 * Activity作为View层 实现View层接口
 */
public class MainActivity extends AppCompatActivity implements MainContract.IWeatherView {

    WeatherPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onInfoUpdate(String info) {

    }

    @Override
    public void showWaitingDialog() {

    }

    @Override
    public void closedWaitingDialog() {

    }
}

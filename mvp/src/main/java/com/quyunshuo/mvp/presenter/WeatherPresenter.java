package com.quyunshuo.mvp.presenter;

import com.quyunshuo.mvp.MainContract;

/**
 * @Author: MiYan
 * @Time: 2019/8/30 17:16
 * @Description: 描述：Presenter层
 */
public class WeatherPresenter {
    //Presenter层需持有Model层和View层的接口引用
    MainContract.IWeatherModel mModel;
    MainContract.IWeatherView mView;


    public WeatherPresenter(MainContract.IWeatherView mView) {
        this.mView = mView;
    }

    //供View层调用，用来请求天气数据
    public void requestWeatherInfo() {

    }

    private void showWaitingDialog() {
        mView.showWaitingDialog();
    }

    private void closedWaitingDialog() {
        mView.closedWaitingDialog();
    }

    private void updateWeatherInfo(String info) {
        mView.onInfoUpdate(info);
    }

    private void saveInfo(String info) {
        mModel.setInfo(info);
    }

    private String localInfo() {
        return mModel.getInfo();
    }

}

package com.quyunshuo.mvp;

/**
 * @Author: MiYan
 * @Time: 2019/8/30 17:02
 * @Description: 描述：MVP契约类
 */
public interface MainContract {

    //View层
    interface IWeatherView {

        void onInfoUpdate(String info);

        void showWaitingDialog();

        void closedWaitingDialog();
    }

    //Model层
    interface IWeatherModel {

        //获取数据
        String getInfo();

        //存储数据
        void setInfo(String info);
    }

    //这里不再对Presenter抽象接口
}

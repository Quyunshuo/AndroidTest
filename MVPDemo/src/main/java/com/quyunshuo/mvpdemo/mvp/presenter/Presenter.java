package com.quyunshuo.mvpdemo.mvp.presenter;

import android.content.Context;

import com.quyunshuo.mvpdemo.bean.ComicListInfo;
import com.quyunshuo.mvpdemo.mvp.ContractComic;
import com.quyunshuo.mvpdemo.mvp.model.ModelImpl;

import java.util.List;

/**
 * @Author: MiYan
 * @Time: 2019/8/26 19:32
 * @Description: 描述：Presenter层
 */
public class Presenter {
    //M
    private ModelImpl mModel;
    //V
    private ContractComic.View mView;

    public Presenter() {
        //获得M层的实例
        mModel = new ModelImpl();
    }

    //销毁实例
    public void onDestroy() {
        mModel = null;
    }

    //获取View层的实例
    public void attachView(ContractComic.View view) {
        mView = view;
    }

    /**
     * 模拟请求数据
     */
    public void requestList() {
        //显示加载
        mView.showLoading();
        mModel.requestList(new ContractComic.ICallBack() {
            @Override
            public void ok(List<ComicListInfo.EntriesBean> comicListInfos) {
                mView.showList(comicListInfos);
            }
        });
    }
}

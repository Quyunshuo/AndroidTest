package com.quyunshuo.mvp2.mvp;

import com.quyunshuo.mvp2.bean.Account;
import com.quyunshuo.mvp2.callback.MCallback;

/**
 * @Author: MiYan
 * @Time: 2019/11/14 17:22
 * @Description: 描述：Presenter层
 */
public class MvpPresenter {
    private IView mView;
    private MvpModel mModel;

    /**
     * P层作为View层和Model层的桥梁 需要持有View层和Model层的实例
     *
     * @param mView
     */
    public MvpPresenter(IView mView) {
        this.mView = mView;
        mModel = new MvpModel();
    }

    /**
     * 获取数据的具体逻辑
     *
     * @param accountName
     */
    public void getData(String accountName) {
        //调用Model层获取数据的方法
        mModel.getAccountData(accountName, new MCallback() {
            @Override
            public void onSuccess(Account account) {
                //成功就通知View成进行视图的更新 并把数据传过去
                mView.showSuccessPage(account);
            }

            @Override
            public void onFailed() {
                mView.showFailedPage();
            }
        });
    }
}

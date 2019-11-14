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

    public MvpPresenter(IView mView) {
        this.mView = mView;
        mModel = new MvpModel();
    }

    public void getData(String accountName) {
        mModel.getAccountData(accountName, new MCallback() {
            @Override
            public void onSuccess(Account account) {
                mView.showSuccessPage(account);
            }

            @Override
            public void onFailed() {
                mView.showFailedPage();
            }
        });
    }
}

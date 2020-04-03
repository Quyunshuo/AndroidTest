package com.quyunshuo.mvp2.mvp;

import com.quyunshuo.mvp2.bean.Account;

/**
 * @Author: MiYan
 * @Time: 2019/11/14 16:36
 * @Description: 描述：
 */
public interface IView {
    String getUserInput();

    void showSuccessPage(Account account);

    void showFailedPage();
}

package com.quyunshuo.mvvm.callback;

import com.quyunshuo.mvvm.bean.Account;

/**
 * @Author: MiYan
 * @Time: 2019/11/14 17:15
 * @Description: 描述：
 */
public interface MCallback {
    void onSuccess(Account account);

    void onFailed();
}

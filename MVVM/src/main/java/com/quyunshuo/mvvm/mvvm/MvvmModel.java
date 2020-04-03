package com.quyunshuo.mvvm.mvvm;

import com.quyunshuo.mvvm.bean.Account;
import com.quyunshuo.mvvm.callback.MCallback;

import java.util.Random;

/**
 * @Author: MiYan
 * @Time: 2019/11/14 17:11
 * @Description: 描述：Model层
 */
public class MvvmModel {
    //模拟账号数据
    public void getAccountData(String accountName, MCallback callback) {
        Random random = new Random();
        boolean isSuccess = random.nextBoolean();
        if (isSuccess) {
            Account account = new Account(accountName, 100);
            callback.onSuccess(account);
        } else {
            callback.onFailed();
        }
    }
}

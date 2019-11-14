package com.quyunshuo.mvp2.mvp;

import com.quyunshuo.mvp2.bean.Account;
import com.quyunshuo.mvp2.callback.MCallback;

import java.util.Random;

/**
 * @Author: MiYan
 * @Time: 2019/11/14 17:11
 * @Description: 描述：Model层
 */
public class MvpModel {
    //模拟账号数据
    public void getAccountData(String accountName, MCallback calback) {
        Random random = new Random();
        boolean isSuccess = random.nextBoolean();
        if (isSuccess) {
            Account account = new Account(accountName, 100);
            calback.onSuccess(account);
        } else {
            calback.onFailed();
        }
    }
}

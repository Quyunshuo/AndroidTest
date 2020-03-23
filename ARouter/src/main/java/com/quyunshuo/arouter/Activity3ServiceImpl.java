package com.quyunshuo.arouter;

import android.content.Context;

import com.alibaba.android.arouter.facade.annotation.Route;

@Route(path = RouterUrl.urlActivity3ServiceImpl)
public class Activity3ServiceImpl implements Activity3Service {

    @Override
    public void startActivity3(Context context) {
        Activity3.start(context);
    }

    @Override
    public void init(Context context) {
    }
}

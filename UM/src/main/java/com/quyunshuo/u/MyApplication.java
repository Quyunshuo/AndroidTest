package com.quyunshuo.u;

import android.app.Application;

import com.umeng.analytics.MobclickAgent;
import com.umeng.commonsdk.UMConfigure;

/**
 * @Author: MiYan
 * @Time: 2019/8/9 20:19
 * @Description: 描述：
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        //初始化
        UMConfigure.init(this, UMConfigure.DEVICE_TYPE_PHONE, "5d4d3d164ca357113d0004ec");
        MobclickAgent.setPageCollectionMode(MobclickAgent.PageMode.AUTO);
    }
}

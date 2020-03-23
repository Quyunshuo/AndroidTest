package com.quyunshuo.arouter;

import android.content.Context;
import android.util.Log;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Interceptor;
import com.alibaba.android.arouter.facade.callback.InterceptorCallback;
import com.alibaba.android.arouter.facade.template.IInterceptor;

@Interceptor(priority = 1)
public class Test1Interceptor implements IInterceptor {
    @Override
    public void process(Postcard postcard, InterceptorCallback callback) {
        Log.d("miyan", Test1Interceptor.class.getName() + " has process.");
        //拦截跳转，进行一些处理
        if (postcard.getPath().equals(RouterUrl.urlActivity1)) {
            Log.d("miyan", Test1Interceptor.class.getName() + " 进行了拦截处理！");
            callback.onInterrupt(new Throwable("我觉得有点异常"));
        }
        callback.onContinue(postcard);
    }

    @Override
    public void init(Context context) {
        Log.d("miyan", Test1Interceptor.class.getName() + " has init.");
    }
}

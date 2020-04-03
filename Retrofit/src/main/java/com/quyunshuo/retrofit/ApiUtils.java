package com.quyunshuo.retrofit;

import com.quyunshuo.retrofit.data.remote.RetrofitClient;
import com.quyunshuo.retrofit.data.remote.SOService;

/**
 * @Author: MiYan
 * @Time: 2019/8/20 15:31
 * @Description: 描述：该类设置了一个baseUrl常量，通过静态方法getSOService为应用提供SOService接口
 */
public class ApiUtils {
    public static final String BASE_URL = "https://api.stackexchange.com/2.2/";

    public static SOService getSOService() {
        return RetrofitClient.getClient(BASE_URL).create(SOService.class);
    }
}

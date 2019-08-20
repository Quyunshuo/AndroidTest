package com.quyunshuo.retrofit.data.remote;

import com.quyunshuo.retrofit.data.SOAnswersResponse;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * @Author: MiYan
 * @Time: 2019/8/20 15:22
 * @Description: 描述：
 */
public interface SOService {
    //@GET 注解明确的定义了当该方法调用的时候会执行一个GET请求
    //接口里每一个方法都必须有一个 HTTP 注解，用于提供请求方法和相对的URL
    //Retrofit 内置了 5 种注解：@GET, @POST, @PUT, @DELETE, 和 @HEAD

    @GET("/answers?order=desc&sort=activity&site=stackoverflow")
//    Call<List<SOAnswersResponse>> getAnswers();
    Call<ResponseBody> getAnswers();


    //在这第二个方法中我们添加一个 query 参数用于从服务端过滤数据
    //Retrofit 提供了 @Query("key") 注解，这样就不用在地址里面直接写了
    //key 的值代表了 URL 里参数的名字
    //Retrofit 会把他们添加到 URL 里面
    //比如说，如果我们把 android 作为参数传递给 getAnswers(String tags) 方法，完整的 URL 将会是：
    //https://api.stackexchange.com/2.2/answers?order=desc&sort=activity&site=stackoverflow&tagged=android
    @GET("/answers?order=desc&sort=activity&site=stackoverflow")
    Call<List<SOAnswersResponse>> getAnswers(@Query("tagged") String tags);
}

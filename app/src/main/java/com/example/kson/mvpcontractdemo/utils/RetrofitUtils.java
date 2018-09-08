package com.example.kson.mvpcontractdemo.utils;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Author:kson
 * E-mail:19655910@qq.com
 * Time:2018/09/08
 * Description:
 */
public class RetrofitUtils {
    private volatile static RetrofitUtils retrofitUtils;

    private OkHttpClient okHttpClient = null;

    private RetrofitUtils(){
        okHttpClient = new OkHttpClient.Builder()
                .readTimeout(5, TimeUnit.SECONDS)
//                .addInterceptor()
                .build();


    }

    public static RetrofitUtils getInstance(){
        if (retrofitUtils==null){
            synchronized (RetrofitUtils.class){
                if (retrofitUtils==null){
                    retrofitUtils = new RetrofitUtils();
                }
            }
        }

        return retrofitUtils;
    }


    public <T> T creatApi(Class<T> clz){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://www.zhaoapi.cn/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient).build();
        return retrofit.create(clz);
    }
}

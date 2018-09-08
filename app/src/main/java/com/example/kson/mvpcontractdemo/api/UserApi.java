package com.example.kson.mvpcontractdemo.api;

import com.example.kson.mvpcontractdemo.entity.UserEntity;

import java.util.HashMap;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Author:kson
 * E-mail:19655910@qq.com
 * Time:2018/09/08
 * Description:
 */
public interface UserApi {

    @POST("user/login")
    @FormUrlEncoded
    Observable<UserEntity> login(@FieldMap HashMap<String,String> params);
}

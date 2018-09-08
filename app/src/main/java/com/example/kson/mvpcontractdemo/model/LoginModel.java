package com.example.kson.mvpcontractdemo.model;

import com.example.kson.mvpcontractdemo.api.UserApi;
import com.example.kson.mvpcontractdemo.contract.LoginContract;
import com.example.kson.mvpcontractdemo.entity.UserEntity;
import com.example.kson.mvpcontractdemo.utils.RetrofitUtils;

import java.util.HashMap;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Author:kson
 * E-mail:19655910@qq.com
 * Time:2018/09/08
 * Description:
 */
public class LoginModel implements LoginContract.ILoginModel {

    @Override
    public void login(HashMap<String, String> params) {

       RetrofitUtils.getInstance().creatApi(UserApi.class).login(params).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
       .subscribe(new Consumer<UserEntity>() {
           @Override
           public void accept(UserEntity userEntity) throws Exception {
               //接口回调

           }
       }, new Consumer<Throwable>() {
           @Override
           public void accept(Throwable throwable) throws Exception {

           }
       });
    }
}

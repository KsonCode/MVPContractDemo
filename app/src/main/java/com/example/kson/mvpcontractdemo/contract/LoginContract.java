package com.example.kson.mvpcontractdemo.contract;

import com.example.kson.mvpcontractdemo.entity.UserEntity;

import java.util.HashMap;

import io.reactivex.Observable;

/**
 * Author:kson
 * E-mail:19655910@qq.com
 * Time:2018/09/08
 * Description:登录的契约类
 */
public interface LoginContract {

    abstract class LoginPresenter{

        public abstract void login(HashMap<String, String> params);


    }

    interface ILoginModel{

        void login(HashMap<String, String> params);

    }

    interface ILoginView{
        void loginSuccess();
        void loginFail();
        void fail();
    }
}

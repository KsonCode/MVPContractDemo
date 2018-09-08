package com.example.kson.mvpcontractdemo.presenter;

import com.example.kson.mvpcontractdemo.contract.LoginContract;
import com.example.kson.mvpcontractdemo.model.LoginModel;

import java.lang.ref.WeakReference;
import java.util.HashMap;

/**
 * Author:kson
 * E-mail:19655910@qq.com
 * Time:2018/09/08
 * Description:
 */
public class LoginPresenter extends LoginContract.LoginPresenter {

    private LoginModel loginModel;
    private LoginContract.ILoginView iLoginView;
    private WeakReference<LoginContract.ILoginView> loginViewWeakReference;//弱引用

    /**
     * 绑定
     * @param loginModel
     * @param loginView
     */
    public void attach(LoginModel loginModel, LoginContract.ILoginView loginView){
        this.loginModel = new LoginModel();
        loginViewWeakReference = new WeakReference<LoginContract.ILoginView>(loginView);
        iLoginView = loginViewWeakReference.get();
    }

    @Override
    public void login(HashMap<String, String> params) {
        loginModel.login(params);
    }

    public void detach(){
        if (loginViewWeakReference!=null){
            loginViewWeakReference.clear();//回收资源
            loginViewWeakReference = null;
            this.iLoginView = null;
        }


    }
}

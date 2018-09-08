package com.example.kson.mvpcontractdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.kson.mvpcontractdemo.contract.LoginContract;
import com.example.kson.mvpcontractdemo.presenter.LoginPresenter;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements LoginContract.ILoginView{

    private LoginPresenter loginPresenter;
    @BindView(R.id.login)
    Button loginBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loginPresenter = new LoginPresenter();

    }

    @OnClick({R.id.login})//butterknife绑定事件
    public void click(View view){
        HashMap<String,String> params = new HashMap<>();
        loginPresenter.login(params);

    }

    @Override
    public void loginSuccess() {

    }

    @Override
    public void loginFail() {

    }

    @Override
    public void fail() {

    }
}

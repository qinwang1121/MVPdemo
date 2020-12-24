package com.ningya.mvpdemo.login;

public interface LoginModel {

    interface OnLoginFinishedListener{

        void onUsernameError();//用户为空

        void onPasswordError();//密码为空

        void onSuccess();//登录成功

        void onFail();//登录失败
    }

    void login(String userName, String password, OnLoginFinishedListener listener);
}

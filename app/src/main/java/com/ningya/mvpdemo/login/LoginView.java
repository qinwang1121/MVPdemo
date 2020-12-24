package com.ningya.mvpdemo.login;

public interface LoginView {

    void showProgress();//显示加载动画

    void hideProgress();//隐藏加载动画

    void setUsernameError();//用户名为空

    void setPasswordError();//密码为空

    void setUserError();//密码或用户名错误

    void navigateToHome();//登录成功，跳转界面
}

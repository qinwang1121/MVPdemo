package com.ningya.mvpdemo.login;

public interface LoginPresenter {

    void validateCredentials(String userName, String password);

    void onDestroy();//终止
}

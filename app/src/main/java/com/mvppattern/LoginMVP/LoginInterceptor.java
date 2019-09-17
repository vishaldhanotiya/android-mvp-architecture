package com.mvppattern.LoginMVP;

/**
 * Created by Vishal on 3/28/2017.
 */

public interface LoginInterceptor {

    interface onLoginFinishdListner{
        void onUserNameError(String msg);
        void onUserPasswordError();
        void onSuccess();
        void onFailure(String msg);

    }

    void login(String name,String password,onLoginFinishdListner onLoginFinishdListner);

}

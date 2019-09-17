package com.mvppattern.LoginMVP;

/**
 * Created by Vishal on 3/28/2017.
 */

public class LoginPresentorImpl implements LoginPresenter,LoginInterceptor.onLoginFinishdListner {


    LoginView mLoginView;
    LoginInterceptor mLoginInteractor;

    public LoginPresentorImpl(LoginView mLoginView) {
        this.mLoginView = mLoginView;
        mLoginInteractor=new LoginInterceptorImpl();
    }

    @Override
    public void validateCredential(String username, String password) {
        if (mLoginView != null) {
            mLoginView.showDialog();
            mLoginInteractor.login(username,password,this);
        }

    }

    @Override
    public void onDestroy() {
        if (mLoginView != null) {
            mLoginView=null;
        }
    }

    @Override
    public void onUserNameError(String msg) {
        if (mLoginView != null) {

            mLoginView.hideDialog();
            mLoginView.setUserNameError(msg);
        }
    }

    @Override
    public void onUserPasswordError() {
        if (mLoginView != null) {
            mLoginView.hideDialog();
            mLoginView.setUserPasswordError();
        }
    }

    @Override
    public void onSuccess() {
        if (mLoginView != null) {
            mLoginView.hideDialog();
            mLoginView.nagivatetoMain();
        }
    }

    @Override
    public void onFailure(String message) {
        if (mLoginView != null) {
            mLoginView.hideDialog();
            mLoginView.showAlert(message);
        }
    }
}
package com.mvppattern.LoginMVP;

/**
 * Created by Vishal on 3/28/2017.
 */

public interface LoginView {


    void showDialog();
    void hideDialog();
    void setUserNameError(String msg);
    void setUserPasswordError();
    void nagivatetoMain();
    void navigatetoForgetPassword();
    void navigatetoSignUp();
    void showAlert(String message);

}

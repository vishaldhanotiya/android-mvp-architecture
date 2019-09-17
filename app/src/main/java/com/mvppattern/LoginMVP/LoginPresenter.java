package com.mvppattern.LoginMVP;

/**
 * Created by Vishal on 3/28/2017.
 */

public interface LoginPresenter {
    void validateCredential(String name,String password);
    void onDestroy();

}

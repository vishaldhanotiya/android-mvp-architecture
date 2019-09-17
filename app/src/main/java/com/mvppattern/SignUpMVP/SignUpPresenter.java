package com.mvppattern.SignUpMVP;

/**
 * Created by Vishal on 3/28/2017.
 */

public interface SignUpPresenter {
    void validationSignUp(String firstname,String lastname,String dob,String password,String confirmpassword);
    void onDestroyed();

}

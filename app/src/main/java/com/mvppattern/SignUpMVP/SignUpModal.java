package com.mvppattern.SignUpMVP;

/**
 * Created by Vishal on 3/28/2017.
 */

public interface SignUpModal {
     interface onSignUpFinishListner{

         void validationError(String msg);
         void signupSuccess(String msg);
         void sigupfailure(String msg);

    }

    void signUp(String firstname,String lastname,String email,String password,String confirmpassword,onSignUpFinishListner onSignUpFinishListner);

}

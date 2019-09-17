package com.mvppattern.ForgetMVP;

public interface ForgetInterceptor {

    interface onForgetListner{

        void validationError(String msg);
        void signupSuccess(String msg);
        void signupFailure(String msg);

    }

    void forget(String email,onForgetListner listner );
}

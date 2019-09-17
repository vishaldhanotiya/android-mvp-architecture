package com.mvppattern.ForgetMVP;

public class ForgetIntercetorImpl implements ForgetInterceptor {
    @Override
    public void forget(String email, onForgetListner listner) {
        if(email.isEmpty()){
            listner.validationError("Please enter email address");
        }else{

            if (!email.isEmpty()){
                listner.validationError("Add API");

            }else{
                listner.validationError("error");
            }
        }

    }
}

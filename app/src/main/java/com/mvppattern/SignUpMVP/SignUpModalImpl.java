package com.mvppattern.SignUpMVP;

/**
 * Created by Vishal on 3/28/2017.
 */

public class SignUpModalImpl implements SignUpModal {
    @Override
    public void signUp(String firstname, String lastname, String email, String password, String confirmpassword, onSignUpFinishListner listner) {
        if (firstname.isEmpty()) {
            listner.validationError("Please Enter First Name");
        } else if (lastname.isEmpty()) {
            listner.validationError("Please Enter Last Name");
        } else if (email.isEmpty()) {
            listner.validationError("Please Enter Email Address");
        } else if (password.isEmpty()) {
            listner.validationError("Please Enter Password");
        } else if (password.length() <= 4) {
            listner.validationError("Password must be greater than 4 digit");
        } else if (confirmpassword.isEmpty()) {
            listner.validationError("Please Enter Confirm Password");
        } else if (confirmpassword.length() <= 4) {
            listner.validationError("Confirm Password must be greater than 4 digit");
        } else if (!password.equals(confirmpassword)) {
            listner.validationError(" Password and Confirm Password is not matched");
        } else {
            listner.validationError("Sign Up Successfully");
        }
    }

}

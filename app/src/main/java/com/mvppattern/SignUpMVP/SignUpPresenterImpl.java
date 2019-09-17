package com.mvppattern.SignUpMVP;

/**
 * Created by Vishal on 3/28/2017.
 */

public class SignUpPresenterImpl implements SignUpPresenter,SignUpModal.onSignUpFinishListner {


    SignUpView signUpView;
    SignUpModal presenter;

    public SignUpPresenterImpl(SignUpView signUpView) {
        this.signUpView = signUpView;
        presenter = new SignUpModalImpl();
    }

    @Override
    public void validationSignUp(String firstname, String lastname, String email, String password, String confirmpassword) {
        if (signUpView!=null){

            presenter.signUp(firstname,lastname,email,password,confirmpassword,this);
        }

    }

    @Override
    public void onDestroyed() {
        if (signUpView!=null){
            signUpView=null;

        }
    }

    @Override
    public void validationError(String msg) {
        if (signUpView!=null){
            signUpView.showErrorMsg(msg);

        }
    }

    @Override
    public void signupSuccess(String msg) {
        if (signUpView!=null){

        }
    }

    @Override
    public void sigupfailure(String msg) {
        if (signUpView!=null){

        }
    }
}

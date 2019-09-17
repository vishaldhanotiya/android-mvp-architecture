package com.mvppattern.ForgetMVP;

public class ForgetPresenterImpl implements ForgetPresenter,ForgetInterceptor.onForgetListner {

    ForgetView mForgetView;
    ForgetInterceptor mForgetInterceptor;

    public ForgetPresenterImpl(ForgetView mForgetView) {
        this.mForgetView = mForgetView;
        mForgetInterceptor = new ForgetIntercetorImpl();
    }

    @Override
    public void vaildEmail(String email) {
        if (mForgetView!=null){
            mForgetView.showLoading();
            mForgetInterceptor.forget(email,this);
        }

    }

    @Override
    public void Destroyed() {

    }

    @Override
    public void validationError(String msg) {
        if (mForgetView!=null){
            mForgetView.hideLoading();
            mForgetView.showErrorMsg(msg);
        }
    }

    @Override
    public void signupSuccess(String msg) {
        if (mForgetView!=null){
            mForgetView.hideLoading();
        }

    }

    @Override
    public void signupFailure(String msg) {
        if (mForgetView!=null){
            mForgetView.hideLoading();
        }

    }
}

package com.mvppattern.LoginMVP;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.mvppattern.MainActivity;

/**
 * Created by Vishal on 3/28/2017.
 */

public class BaseActivity extends Activity implements LoginView {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void showDialog() {

    }

    @Override
    public void hideDialog() {

    }

    @Override
    public void setUserNameError(String msg) {


    }


    @Override
    public void setUserPasswordError() {
        Toast.makeText(BaseActivity.this, "Please Enter Password", Toast.LENGTH_SHORT).show();
       // password.setError("Please Enter Password");
    }

    @Override
    public void nagivatetoMain() {
        Intent intent=new Intent(BaseActivity.this,MainActivity.class);
        startActivity(intent);

    }

    @Override
    public void navigatetoForgetPassword() {

    }

    @Override
    public void navigatetoSignUp() {

    }

    @Override
    public void showAlert(String message) {
        Toast.makeText(BaseActivity.this, ""+message, Toast.LENGTH_SHORT).show();

    }
}

package com.mvppattern.LoginMVP;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.mvppattern.ForgetMVP.ForgetActivity;
import com.mvppattern.ListMVP.ListViewActivity;
import com.mvppattern.MainActivity;
import com.mvppattern.R;
import com.mvppattern.SignUpMVP.SignUpActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;

public class LoginActivity extends Activity implements LoginView {

    private EditText user_name, password;
    private Button login, sign_up;
    private TextView forget_password;
    ProgressDialog progressDialog;



    public LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginPresenter = new LoginPresentorImpl(LoginActivity.this);

        user_name = (EditText) findViewById(R.id.edit_name);
        password = (EditText) findViewById(R.id.edit_password);

        forget_password = (TextView) findViewById(R.id.forget_password);
        login = (Button) findViewById(R.id.login);
        sign_up = (Button) findViewById(R.id.sign_up);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                loginPresenter.validateCredential(user_name.getText().toString().trim(), password.getText().toString().trim());
            }
        });
        forget_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigatetoForgetPassword();
            }
        });

        sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigatetoSignUp();
            }
        });

    }


    @Override
    public void showDialog() {

        progressDialog=new ProgressDialog(this);
        progressDialog.setMessage("Please wait....");
        progressDialog.setCancelable(false);
        progressDialog.show();
    }

    @Override
    public void hideDialog() {
        progressDialog.hide();
    }

    @Override
    public void setUserNameError(String msg) {
        user_name.setError(msg);

    }

    @Override
    public void setUserPasswordError() {
        password.setError("Please Enter Password");
    }

    @Override
    public void nagivatetoMain() {
        Intent intent = new Intent(LoginActivity.this, ListViewActivity.class);
        startActivity(intent);

    }


    @Override
    public void navigatetoForgetPassword() {
        Intent intent = new Intent(LoginActivity.this, ForgetActivity.class);
        startActivity(intent);
    }

    @Override
    public void navigatetoSignUp() {
        Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
        startActivity(intent);
    }

    @Override
    public void showAlert(String message) {
        Toast.makeText(LoginActivity.this, "" + message, Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        loginPresenter.onDestroy();
    }
}

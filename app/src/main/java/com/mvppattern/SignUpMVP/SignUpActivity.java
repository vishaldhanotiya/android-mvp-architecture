package com.mvppattern.SignUpMVP;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.mvppattern.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SignUpActivity extends AppCompatActivity implements SignUpView {

    @BindView(R.id.edit_firstname)
    EditText edit_firstname;

    @BindView(R.id.edit_lastname)
    EditText edit_lastname;

    @BindView(R.id.edit_email)
    EditText edit_email;

    @BindView(R.id.edit_password)
    EditText edit_password;

    @BindView(R.id.edit_confirm_password)
    EditText edit_confirm_password;



    SignUpPresenter  signUpPresenter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

       // bind the view using butterknife
        ButterKnife.bind(this);


        signUpPresenter=new SignUpPresenterImpl(SignUpActivity.this);


       }

       @OnClick(R.id.sign_up)
       public void signUpClick(View view){


        signUpPresenter.validationSignUp(edit_firstname.getText().toString(),edit_lastname.getText().toString(), edit_email.getText().toString(),
                edit_password.getText().toString(),edit_confirm_password.getText().toString());
         /*  Toast.makeText(SignUpActivity.this, ""+edit_firstname.getText().toString()+"\n"
                                                              +edit_lastname.getText().toString()+"\n"
                                                              +edit_email.getText().toString()+"\n"
                                                              +edit_password.getText().toString()+"\n"
                                                              +edit_confirm_password.getText().toString()+"\n"
                                                               , Toast.LENGTH_SHORT).show();*/

       }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showErrorMsg(String msg) {
        Toast.makeText(SignUpActivity.this, ""+msg, Toast.LENGTH_SHORT).show();

    }
}

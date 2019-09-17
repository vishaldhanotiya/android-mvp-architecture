package com.mvppattern.ForgetMVP;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.mvppattern.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ForgetActivity extends AppCompatActivity implements ForgetView{
    ForgetPresenter presenter;

    @BindView(R.id.forget_password)
    EditText forget_password;


    @BindView(R.id.forget_click)
    Button forget_click;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget);
        ButterKnife.bind(this);

        presenter=new ForgetPresenterImpl(ForgetActivity.this);



        forget_click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.vaildEmail(forget_password.getText().toString());
            }
        });


    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showErrorMsg(String msg) {
        Toast.makeText(ForgetActivity.this, ""+msg, Toast.LENGTH_SHORT).show();


    }
}

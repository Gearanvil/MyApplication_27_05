package com.sdaacademy.grzebieluch.pawel.myapplication_27_05;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import com.sdaacademy.grzebieluch.pawel.myapplication_27_05.presenters.LoginPresenter;
import com.sdaacademy.grzebieluch.pawel.myapplication_27_05.presenters.RegisterPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by RENT on 2017-05-27.
 */

public class LoginActivity extends AppCompatActivity {


    @BindView(R.id.editTextLoginEmail)
    EditText etEmail;

    @BindView(R.id.editTextLoginPassword)
    EditText etPassword;

    private LoginPresenter presenter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        if(presenter == null){
            presenter = new LoginPresenter();
        }
    }
    @OnClick(R.id.buttonLogin)
    public void loginUser(){
        finish();
        Utils.showToast(this,"Zalogowano");

        //startActivity(new Intent(getApplicationContext(),LoginActivity.class));
    }

}

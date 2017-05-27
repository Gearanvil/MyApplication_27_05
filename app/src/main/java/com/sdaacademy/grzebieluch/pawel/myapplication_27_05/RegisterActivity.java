package com.sdaacademy.grzebieluch.pawel.myapplication_27_05;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.sdaacademy.grzebieluch.pawel.myapplication_27_05.presenters.RegisterPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegisterActivity extends AppCompatActivity {
    @BindView(R.id.editTextEmail)
    EditText etEmail;

    @BindView(R.id.editTextPassword)
    EditText etPassword;



    @BindView(R.id.textViewSignin)
    TextView tvSignin;


    private RegisterPresenter presenter;


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);

        if(presenter == null){
            presenter = new RegisterPresenter();
        }
    }

    @OnClick(R.id.buttonRegister)
    public void createUser(){
        String email = etEmail.getText().toString().toLowerCase().trim();
        String password = etPassword.getText().toString().trim();
        presenter.registerUser(this,email,password);
    }


}

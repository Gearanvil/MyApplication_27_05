package com.sdaacademy.grzebieluch.pawel.myapplication_27_05.presenters;

import android.app.Activity;
import android.app.ProgressDialog;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.sdaacademy.grzebieluch.pawel.myapplication_27_05.Utils;

/**
 * Created by RENT on 2017-05-27.
 */

public class LoginPresenter {


    private FirebaseAuth firebaseAuth;
    private ProgressDialog progressDialog;


    public LoginPresenter() {

    }


    public void loginUser(final Activity activity, String email, String password) {
        progressDialog = new ProgressDialog(activity);

        if (TextUtils.isEmpty(email)) {
            Utils.showToast(activity, "Enter email...");
            return;
        } else if (!Utils.isPasswordValid(email)) {
            Utils.showToast(activity, "Email invalid...");
            return;
        }

        if (TextUtils.isEmpty(password)) {
            Utils.showToast(activity, "Enter password...");
            return;
        } else if (Utils.isPasswordValid(password)) {
            Utils.showToast(activity, "Invalid email...");
            return;
        }

        if (!Utils.checkInternetConnection(activity)) {
            Utils.showToast(activity, "No internet connection...");
            return;
        }

        progressDialog.setMessage("Loging in...");
        progressDialog.show();

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(activity,
                new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            progressDialog.dismiss();
                            Toast.makeText(activity,"Loged in",Toast.LENGTH_SHORT).show();
                        } else {
                            progressDialog.dismiss();
                            Toast.makeText(activity,"Error! Something went wrong! Sorry...",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}

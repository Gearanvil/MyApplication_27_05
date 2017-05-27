package com.sdaacademy.grzebieluch.pawel.myapplication_27_05.presenters;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by RENT on 2017-05-27.
 */

public class RegisterPresenter {

    private FirebaseAuth firebaseAuth;


    public RegisterPresenter() {

    }


    public void registerUser(final Activity activity, String email, String password) {

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(activity,
                new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(activity, "Account Created", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(activity, "!!!Error!!! something went wrong! !!!Error!!!", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}

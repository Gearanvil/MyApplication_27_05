package com.sdaacademy.grzebieluch.pawel.myapplication_27_05;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by RENT on 2017-05-27.
 */

public class Utils {

    Context mContext;
    public static boolean isEmeailValid(String email) {
        return email.contains("@");


    }

    public static boolean isEmailLengthValid(String email) {
        int beginIndex = 0;
        for (int i = 0; i < email.length(); i++) {
            if (email.charAt(i) == '@') {
                beginIndex = i;
            }
        }
        return beginIndex>6;
    }
    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
}

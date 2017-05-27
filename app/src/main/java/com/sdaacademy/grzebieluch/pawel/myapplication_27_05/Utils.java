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
    //sprawdzamy czy uzytkownik przy hasle podał ponad 6 znaków
    public static boolean isPasswordValid(String password) {
        return password.length() > 6;
    }
    //sprawdzanie czy posiadamy dostep do internetu
    static boolean checkInternetConnection(Context context) {
        ConnectivityManager cm =
                (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        return netInfo != null && netInfo.isConnectedOrConnecting();
    }



}

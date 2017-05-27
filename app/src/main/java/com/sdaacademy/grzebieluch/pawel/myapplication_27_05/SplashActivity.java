package com.sdaacademy.grzebieluch.pawel.myapplication_27_05;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.stephentuso.welcome.BasicPage;
import com.stephentuso.welcome.TitlePage;
import com.stephentuso.welcome.WelcomeConfiguration;

/**
 * Created by RENT on 2017-05-27.
 */

public class SplashActivity extends AppCompatActivity {
private int time = 3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        splash(time);
    }


    protected WelcomeConfiguration configuration() {
        return new WelcomeConfiguration.Builder(this)
                .defaultBackgroundColor(R.color.colorAccent)
                .page(new TitlePage(R.drawable.logo,
                        "Title")
                )
                .page(new BasicPage(R.drawable.image,
                        "Header",
                        "More text.")
                        .background(R.color.red_background)
                )
                .page(new BasicPage(R.drawable.image,
                        "Lorem ipsum",
                        "dolor sit amet.")
                )
                .swipeToDismiss(true)
                .build();
    }
    private void splash(int time) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //intent odpalenia docelowej aktywnosci
                Intent mainIntent = new Intent(SplashActivity.this, RegisterActivity.class);
                startActivity(mainIntent);
                //finish zamyka nasza aplikace, jesli tego nie zrobimy dowktywnosci bedziemy mogli
                //wrocic
                finish();
            }
            //splash screen w milisekundach 3000 = 3 sekundy
        }, time);
    }
}

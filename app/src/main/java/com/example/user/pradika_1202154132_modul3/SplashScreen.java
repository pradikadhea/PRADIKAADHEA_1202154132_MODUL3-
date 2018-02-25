package com.example.user.pradika_1202154132_modul3;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class SplashScreen extends AppCompatActivity {

    //method untuk memunculkan waktu interval ketika splash muncul
    private static int splashInterval = 4000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //setelah splash muncul maka akan berpindah ke login
                startActivity(new Intent(SplashScreen.this, Login.class));
            }
        }, 3600);
    }
}
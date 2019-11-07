package com.example.ru_itech.CommonUI.Aunthetication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.ru_itech.R;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //splash screen
        Splash splash = new Splash();
        splash.start();

    }

    //splash screen thread
    public class Splash extends Thread{
        @Override
        public void run() {
            super.run();

            try {
                sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //intent to signUp screen
            startActivity(new Intent(SplashScreen.this,SignUp.class));
            finish();

        }
    }
}

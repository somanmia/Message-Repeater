package com.example.lovely;

import static java.lang.Thread.currentThread;
import static java.lang.Thread.sleep;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;

public class splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);


        Thread thead=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    sleep(2000);
                    Intent i=new Intent(splash.this,MainActivity.class);
                    startActivity(i);
                    finish();
                }catch (Exception e){

                }
            }
        });
        thead.start();
    }
}
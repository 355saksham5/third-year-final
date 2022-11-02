package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class launch_scr extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.launch_scr);
        /*Intent i = new Intent(launch_scr.this, launch_scr2.class);
        startActivity(i);
        overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);*/
        SharedPreferences sharedPreferences= getSharedPreferences(login.PREFS_NAME,0);
        boolean hasLoggedIn= sharedPreferences.getBoolean("hasLoggedIn",false);
        if(hasLoggedIn) {
            Timer t = new Timer();
            t.schedule(new TimerTask() {
                @Override
                public void run() {
                    Intent i = new Intent(launch_scr.this, launch_scr2.class);
                    startActivity(i);
                    overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                    finish();
                }
            }, 600);
        }
        else
        {
            Timer t1 = new Timer();
            t1.schedule(new TimerTask() {
                @Override
                public void run() {
                    Intent i = new Intent(launch_scr.this,login.class);
            startActivity(i);
            overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
            finish();
        }
    },500);
        }}}

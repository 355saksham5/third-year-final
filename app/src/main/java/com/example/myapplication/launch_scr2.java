package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.SystemClock;

import java.util.Timer;
import java.util.TimerTask;

public class launch_scr2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.launch_scr2);
        Timer t = new Timer();
        t.schedule(new TimerTask() {
            @Override
            public void run() {
                Intent i = new Intent(launch_scr2.this,op_p.class);
                startActivity(i);
                overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
                finish();
            }
        },500);
        MediaPlayer ring= MediaPlayer.create(launch_scr2.this,R.raw.ua);
        ring.start();
    }
}
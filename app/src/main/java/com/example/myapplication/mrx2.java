package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class mrx2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mrx2);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                Intent i = new Intent(mrx2.this,mrx3.class);
                startActivity(i);
                finish();
            }
        }, 2500);

    }
}
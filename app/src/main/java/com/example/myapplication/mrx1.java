package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageButton;

public class mrx1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.mrx1);
        ImageButton del = (ImageButton) findViewById(R.id.del);
        ImageButton op = (ImageButton) findViewById(R.id.op);
        ImageButton hm = (ImageButton) findViewById(R.id.hmo);
        ImageButton a = (ImageButton) findViewById(R.id.aska);
        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(mrx1.this,mrx.class);
                startActivity(i);
                overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
                finish();
            }
        });
        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(mrx1.this,menu.class);
                startActivity(i);
                overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
                finish();

            }
        });
        hm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(mrx1.this,menu.class);
                startActivity(i);
                overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
                finish();
            }
        });
        op.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(mrx1.this,mrx2.class);
                startActivity(i);
                overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
                finish();
            }
        });
    }
}
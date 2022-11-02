package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Date;

public class mrx extends AppCompatActivity {
    static int i=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mrx);
        TextView d=(TextView)  findViewById(R.id.tv);
        ImageView ui=(ImageView)  findViewById(R.id.ui);
        EditText ed=(EditText)  findViewById(R.id.ed);
        ImageButton myButton5 = (ImageButton) findViewById(R.id.cr);
        ImageButton s = (ImageButton) findViewById(R.id.s);
        myButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(mrx.this,menu.class);
                startActivity(i);
                overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
                finish();
            }
        });
        s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int x = d.getLeft();
                int y = d.getTop();
                d.animate()
                        .scaleX(0) // This will be your initial x position of your imageView
                        .scaleY(0) // This will be your initial y position of your imageView
                        .x(x)      // This will be the x position of your target imageView
                        .y(y)      // This will be the y position of your target imageView
                        .setDuration(100)
                        .start();
                x = ed.getLeft();
                y = ed.getTop();
                ed.animate()
                        .scaleX(0) // This will be your initial x position of your imageView
                        .scaleY(0) // This will be your initial y position of your imageView
                        .x(x)      // This will be the x position of your target imageView
                        .y(y)      // This will be the y position of your target imageView
                        .setDuration(100)
                        .start();
                x = s.getLeft();
                y = s.getTop();
                s.animate()
                        .scaleX(0) // This will be your initial x position of your imageView
                        .scaleY(0) // This will be your initial y position of your imageView
                        .x(x)      // This will be the x position of your target imageView
                        .y(y)      // This will be the y position of your target imageView
                        .setDuration(100)
                        .start();
                MediaPlayer ring= MediaPlayer.create(mrx.this,R.raw.au);
                ring.start();
                String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference(uid);
                EditText myEditText = (EditText)findViewById(R.id.ed);
                myRef.child(String.valueOf(((new Date().getTime() / 1000L) % Integer.MAX_VALUE)+System.currentTimeMillis())).setValue(myEditText.getText().toString());
                myRef.child("uid").setValue(uid);
            }
        });
    }
}
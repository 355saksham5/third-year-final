package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.prefs.AbstractPreferences;

public class login extends AppCompatActivity {
    public static String PREFS_NAME="MyPrefsFile";
    Button signIn;
    FirebaseAuth mAuth = FirebaseAuth.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        signIn=findViewById(R.id.login);
        Button s2=findViewById(R.id.sign);
        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createUser();
            }
        });
        s2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginUser();
            }
        });
    }
         @Override
        public void onStart() {
            super.onStart();
            // Check if user is signed in (non-null) and update UI accordingly.
            FirebaseUser currentUser = mAuth.getCurrentUser();
            if (currentUser != null) {
                currentUser.reload();
            }
        }
    private void loginUser(){
        EditText email = findViewById(R.id.username);
        EditText password = findViewById(R.id.password);
        String e = email.getText().toString();
        String p = password.getText().toString();

        if (TextUtils.isEmpty(e)){
            email.setError("Email cannot be empty");
            email.requestFocus();
        }else if (TextUtils.isEmpty(p)){
            password.setError("Password cannot be empty");
            password.requestFocus();
        }else{
            mAuth.signInWithEmailAndPassword(e,p).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        Toast.makeText(login.this, "Success", Toast.LENGTH_SHORT).show();
                        SharedPreferences sharedPreferences= getSharedPreferences(login.PREFS_NAME,0);
                        SharedPreferences.Editor editor=sharedPreferences.edit();
                        editor.putBoolean("hasLoggedIn",true);
                        editor.commit();
                        startActivity(new Intent(login.this,launch_scr2.class));
                        finish();
                    }else{
                        Toast.makeText(login.this, "Error: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
        private void createUser(){
            EditText email = findViewById(R.id.username);
            EditText password = findViewById(R.id.password);
            String e = email.getText().toString();
            String p = password.getText().toString();

            if (TextUtils.isEmpty(e)){
                email.setError("Email cannot be empty");
                email.requestFocus();
            }else if (TextUtils.isEmpty(p)){
                password.setError("Password cannot be empty");
                password.requestFocus();
            }else{
                mAuth.createUserWithEmailAndPassword(e,p).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(login.this, "Success", Toast.LENGTH_SHORT).show();
                            SharedPreferences sharedPreferences= getSharedPreferences(login.PREFS_NAME,0);
                            SharedPreferences.Editor editor=sharedPreferences.edit();
                            editor.putBoolean("hasLoggedIn",true);
                            editor.commit();
                            startActivity(new Intent(login.this,launch_scr2.class));
                            finish();
                        }else{
                            Toast.makeText(login.this, "Registration Error: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        }

    }

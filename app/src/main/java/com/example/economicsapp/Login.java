package com.example.economicsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
//This allows the users to go from login page to the homepage
    public void homepage (View view){
        Intent intent = new Intent(this, Homepage.class);
        startActivity(intent);

    }
}
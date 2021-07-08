package com.example.economicsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
//This allows the users to go from the main page to the login page
    public void login (View view){
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);

    }
}
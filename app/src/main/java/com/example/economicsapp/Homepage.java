package com.example.economicsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Homepage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);



    }
    //This allows the users to go from homepage to the quiz pages
    public void quiz (View view){
        Intent intent = new Intent(this, Quiz.class);
        startActivity(intent);

    }
    public void nzqa (View view){
        Intent intent = new Intent(this, NzqaPage.class);
        startActivity(intent);
    }
    public void kamar (View view) {
        Intent intent = new Intent(this, KamarPage.class);
        startActivity(intent);
    }
}
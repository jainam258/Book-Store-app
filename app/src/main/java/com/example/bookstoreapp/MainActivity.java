package com.example.bookstoreapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Navigate to LoginActivity
        findViewById(R.id.btnLogin).setOnClickListener(v -> startActivity(new Intent(MainActivity.this, LoginActivity.class)));
    }
}

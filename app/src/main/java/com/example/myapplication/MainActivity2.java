package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Button button = findViewById(R.id.button2);
        button.setOnClickListener(view -> {

            Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
            startActivity(intent);

        });
        Button button1 = findViewById(R.id.button3);
        button1.setOnClickListener(view -> {

            Intent intent = new Intent(MainActivity2.this, MainActivity4.class);
            startActivity(intent);

        });
    }
}
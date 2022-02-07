package com.example.day3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity2 extends AppCompatActivity {

    public static final String EXTRA_HELLO_KEY = "hello";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button sendButton = findViewById(R.id.main_sendMore);

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("BLALBLA");
            }
        });

        sendButton.setOnClickListener(v -> {
            System.out.println("BLALBLA");

        });

    }
}
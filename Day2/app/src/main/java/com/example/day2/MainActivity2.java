package com.example.day2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener {

    public static final String EXTRA_NAME_KEY = "name";

    //class variables, attributes, class field
    private EditText nameEditText;  //null

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //Inflating the Layout View (Creating the layout)

//        val nameEditText = findViewById<EditText>(R.id.main_name)
//        val acceptButton = findViewById<Button>(R.id.main_accept)

        nameEditText = findViewById(R.id.main_name);

        Button acceptButton = findViewById(R.id.main_accept);

        acceptButton.setOnClickListener(x -> System.out.println("HELLO"));
        acceptButton.setOnClickListener(this::acceptButtonGotClicked);
    }

    private void acceptButtonGotClicked(View view) {

        //Change Activity
        Intent intent = new Intent(this, DetailsActivity.class);
        startActivity(intent);


    }

    @Override
    public void onClick(View x) {
        System.out.println("HELLO");
    }
}
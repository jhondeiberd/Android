package com.example.day2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText

class MainActivityEmail : AppCompatActivity() {

    private lateinit var to_Send : EditText
    private lateinit var to_subject : EditText
    private lateinit var to_body : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_email)

        to_Send  = findViewById<EditText>(R.id.main_to_rec)
        to_subject  = findViewById<EditText>(R.id.main_subject_rec)
        to_body  = findViewById<EditText>(R.id.main_body_rec)

        val myIntent = intent

        if (myIntent.hasExtra("array")) {
            val datEmail = myIntent.getStringArrayListExtra("array")
            if (datEmail != null) {
                to_Send.setText(datEmail[0])
                to_subject.setText(datEmail[1])
                to_body.setText(datEmail[2])
            }
        }
    }
}
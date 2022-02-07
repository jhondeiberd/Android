package com.example.day4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val firstNameTextView = findViewById<TextView>(R.id.main_firstName)
        val lastNameTextView = findViewById<TextView>(R.id.main_lastName)

        val myIntent = intent
        if (myIntent.hasExtra(MainActivity.EXTRA_SERIALIZABLE_KEY)){
            val myTeacher : Teacher = myIntent.getSerializableExtra(MainActivity.EXTRA_SERIALIZABLE_KEY) as Teacher
            firstNameTextView.text = myTeacher.getFirstName()
            lastNameTextView.text = myTeacher.lastName
        }

    }
}
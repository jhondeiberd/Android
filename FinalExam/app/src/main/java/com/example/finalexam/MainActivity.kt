package com.example.finalexam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val image:ImageView = findViewById(R.id.main_logo)

        image.setOnClickListener {
            val intent = Intent(this, MainProducts::class.java)
            startActivity(intent)
            finish()
        }
    }
}
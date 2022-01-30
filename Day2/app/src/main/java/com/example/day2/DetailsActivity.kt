package com.example.day2


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class  DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        
        val name = findViewById<TextView>(R.id.details_name)
        
        
        val myIntent = intent
        
        if (myIntent.hasExtra(MainActivity.EXTRA_NAME_KEY)) {
            name.text = myIntent.getStringExtra(MainActivity.EXTRA_NAME_KEY)
        }
        
        
    }
}
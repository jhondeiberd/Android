package com.example.labs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.material.bottomappbar.BottomAppBar

class CreateToast : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_toast)

        var toast = findViewById<EditText>(R.id.main_toast)
        var createToast = findViewById<Button>(R.id.create_toast)

        createToast.setOnClickListener {
            Toast.makeText(this, toast.text, Toast.LENGTH_SHORT).show()
        }



    }
}
package com.example.labs

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class Create_toasts : AppCompatActivity() {

    lateinit var createToast: Button
    lateinit var messageToast: TextView
    lateinit var switchToast: Switch

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_toasts)

        messageToast = findViewById(R.id.message_toast)
        createToast = findViewById(R.id.create_toast)
        switchToast = findViewById(R.id.switch_toast)

        createToast.setOnClickListener {
            Toast.makeText(this, messageToast.text, Toast.LENGTH_SHORT).show()
        }
    }
}
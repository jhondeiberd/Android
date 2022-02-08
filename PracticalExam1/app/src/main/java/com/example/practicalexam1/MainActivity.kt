package com.example.practicalexam1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var toast: Button
    lateinit var snackbar: Button
    lateinit var totalToast: TextView
    lateinit var totalSnackbar: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toast = findViewById(R.id.toast)
        snackbar = findViewById(R.id.snackbar)
        totalToast = findViewById(R.id.total_toast)
        totalSnackbar = findViewById(R.id.total_snackbars)

        toast.setOnClickListener {
            val intent = Intent(this, Create_toasts::class.java).apply {
            }
            startActivity(intent)
        }

        snackbar.setOnClickListener {
            val intent = Intent(this, Create_snackbars::class.java).apply {
            }
            startActivity(intent)
        }


    }
}
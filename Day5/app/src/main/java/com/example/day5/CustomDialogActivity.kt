package com.example.day5

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class CustomDialogActivity : AppCompatActivity() {
    lateinit var username:EditText
    lateinit var password:EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val alertDialogButton = findViewById<Button>(R.id.main_alertDialog)

        alertDialogButton.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            val dialogView : View = layoutInflater.inflate(R.layout.dialog_sign_in, null)
            builder.setView(dialogView)
            builder.setPositiveButton("Login", this::dialogClick)
            builder.setNeutralButton("Cancel", this::dialogClick)
            username = dialogView.findViewById(R.id.username)
            password = dialogView.findViewById(R.id.password)
            builder.show()
        }

    }
    fun dialogClick(dialog: DialogInterface, which: Int) {
        Log.e("CustomDialogActivity_dialogClick", "Username ${username.text}")
        Log.e("CustomDialogActivity_dialogClick", "Password ${password.text}")
    }
}
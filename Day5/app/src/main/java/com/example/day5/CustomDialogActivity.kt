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

    lateinit var username: EditText
    lateinit var password: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val alertDialogButton = findViewById<Button>(R.id.main_alertDialog)
        username = findViewById(R.id.username)
        password = findViewById(R.id.password)

        alertDialogButton.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            val dialogView : View = layoutInflater.inflate(R.layout.dialog_log_in, null)
            builder.setView(layoutInflater.inflate(R.layout.dialog_log_in, null))
            builder.setPositiveButton("Login", this::dialogClick)
            builder.setNeutralButton("Cancel", this::dialogClick)
            username = this.findViewById(R.id.username)
            username = findViewById(R.id.username)
            builder.show()

        }

    }

    fun dialogClick(dialog: DialogInterface, which: Int){
        Log.e("CustomDialogActivity_dialogClick", "Username ${username.text}")
        Log.e("CustomDialogActivity_dialogClick", "Password ${password.text}")
    }
}
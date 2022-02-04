package com.example.day2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText

class MainActivityEmailSend : AppCompatActivity() {

    lateinit var to : EditText
    lateinit var subject : EditText
    lateinit var body : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_email_send)

        to = findViewById<EditText>(R.id.main_to)
        subject = findViewById<EditText>(R.id.main_subject)
        body = findViewById<EditText>(R.id.main_body)
        val send = findViewById<Button>(R.id.main_send)

        send.setOnClickListener(this::acceptClicked)

    }

    private fun acceptClicked(view: View) {
        val dataEmail = ArrayList<String>()
        dataEmail.add(to.text.toString())
        dataEmail.add(subject.text.toString())
        dataEmail.add(body.text.toString())
        println(dataEmail)
        val intent = Intent(this, MainActivityEmail::class.java)
        intent.putExtra("array", dataEmail)
        startActivity(intent)
    }

    public fun onClick(v: View?) {
        Log.e("MainActivityEmailSend_onClick", "Button Clicked.")
    }

}
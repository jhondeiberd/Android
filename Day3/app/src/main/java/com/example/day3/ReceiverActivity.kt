package com.example.day3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import androidx.core.widget.addTextChangedListener

class ReceiverActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_NAME_KEY = "receiverInfo"
    }
    val intentToPassBackwards : Intent = Intent()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_receiver) //Inflate Layout/View

        val textModifier = findViewById<EditText>(R.id.receiver_textGoesHere)

        val myIntent = intent //In Java this is getIntent()

        if (myIntent.hasExtra(MainActivity.EXTRA_HELLO_KEY)){
            textModifier.setText(intent.getStringExtra(MainActivity.EXTRA_HELLO_KEY))
        }

        textModifier.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                intentToPassBackwards.putExtra(EXTRA_NAME_KEY, s.toString())
                setResult(RESULT_OK, intentToPassBackwards) //Give to Android OS
                //finish()// Closes Activity
            }
        })

    }
}
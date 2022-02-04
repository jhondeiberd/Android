package com.example.day3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.EditText

class ReceiverActivity : AppCompatActivity(), TextWatcher {
    companion object {
        public const val ENTER_NAME_KEY = "ReceiverInfo"
    }
    val intentToPassBackwards = Intent()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_receiver)  //Inflate LayoutView

        val textModifier = findViewById<EditText>(R.id.receiver_textGoesHere)

        val myIntent = intent   //In java this is getIntent()

        if (myIntent.hasExtra(MainActivity.EXTRA_HELLO_KEY)){
            textModifier.setText(intent.getStringExtra(MainActivity.EXTRA_HELLO_KEY))
        }

        textModifier.addTextChangedListener(this)
    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, before: Int, End: Int) {
    }

    override fun onTextChanged(s: CharSequence?, start: Int, p2: Int, p3: Int) {
    }

    override fun afterTextChanged(s: Editable?) {
        intentToPassBackwards.putExtra(ENTER_NAME_KEY, s.toString())
        setResult(RESULT_OK, intentToPassBackwards)  // Give to Android OS

    }
}
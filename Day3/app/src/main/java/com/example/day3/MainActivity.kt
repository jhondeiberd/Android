package com.example.day3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView


class MainActivity : AppCompatActivity() {
    companion object {
        public const val EXTRA_HELLO_KEY = "HelloExtra"
    }

    lateinit var stringValue: String
    lateinit var helloTextView: TextView

//    private val resultLauncher = register
//            run {
//                    if (result.resultCode == )
//
//            }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)  //Inflate view

        val hello = findViewById<TextView>(R.id.main_hello)
        val sendMore = findViewById<TextView>(R.id.main_sendMore)
        sendMore.setOnClickListener(this::sendMore)   //Method referencing

        //hello.text = "Hello everyone"
        //hello.text = R.string.app_name
        //hello.setText(R.string.app_name)

        stringValue = resources.getString(R.string.hello, "Reza", "great")
        hello.text = stringValue
        //String stringValue = getString().getString(R.string.app.name);
        Log.e("MainActivity_onCreate", stringValue)
    }

    private fun sendMore(view: View) {
        val intent = Intent(this, ReceiverActivity::class.java).apply {
            putExtra(EXTRA_HELLO_KEY, stringValue)
        }
        startActivity(intent)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
    }

}

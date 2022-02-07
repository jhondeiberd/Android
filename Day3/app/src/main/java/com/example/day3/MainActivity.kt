package com.example.day3

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts


class MainActivity : AppCompatActivity() {
    companion object {
        public const val EXTRA_HELLO_KEY = "Hello"
    }

    lateinit var stringValue: String
    lateinit var helloTextView: TextView

    //Has to be before onCreate or onAttach
    private val resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            result:ActivityResult ->
        run {
            if (result.resultCode == Activity.RESULT_OK) {
                val intent = result.data
                if (intent != null) {
                    if (intent.hasExtra(ReceiverActivity.EXTRA_NAME_KEY)) {
                        stringValue = intent.getStringExtra(ReceiverActivity.EXTRA_NAME_KEY).toString()
                        helloTextView.text = stringValue
                    }
                }
            }
        }
    }

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
        helloTextView.text = stringValue
        //String stringValue = getResources().getString(R.string.app_name);
        Log.e("MainActivity_onCreate", stringValue)
    }

    private fun sendMore(view: View) {
        val intent = Intent(this, ReceiverActivity::class.java).apply {
            putExtra(EXTRA_HELLO_KEY, stringValue)
        }
        //startActivity(intent)
        resultLauncher.launch(intent)
    }

    //Deprecated
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
    }

}

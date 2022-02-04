package com.example.day1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reproduce)
        Log.w("MainActivity_onCreate", "executing onCreate")
        //throw Exception("Test")
    }

    override fun onStart() {
        super.onStart()
        println("@@@@@@@@@@@ONSTART@@@@@@@@@@@@@@")
        //d for debug for information, for warning, for error
        //i for information
        //w for warning
        //e for Error
        //wtf for
        Log.d("MainActivity_onStart", "executing onStart")
    }

    override fun onPause() {
        super.onPause()
        println("test")
        //d for debug for information, for warning, for error
        Log.d("MainActivity_onPause", "executing onPause")
    }

    override fun onStop() {
        super.onStop()
        println("test")
        //d for debug for information, for warning, for error
        Log.d("MainActivity_onStop", "executing onStop")
    }

    override fun onRestart() {
        super.onRestart()
        println("test")
        //d for debug for information, for warning, for error
        Log.d("MainActivity_onStart", "executing onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        println("test")
        //d for debug for information, for warning, for error
        Log.d("MainActivity_onStart", "executing onDestroy")
    }

}
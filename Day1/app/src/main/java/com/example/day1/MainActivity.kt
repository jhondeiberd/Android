package com.example.day1

import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.image_gallery)
    }

    override fun onStart() {
        super.onStart()
        println("test")
        //d for debug for information, for warning, for error
        Log.d("MainActivity_onStart", "executing onStart")
    }

    override fun onPause() {
        super.onPause()
        println("test")
        //d for debug for information, for warning, for error
        Log.d("MainActivity_onStart", "executing onPause")
    }

    override fun onStop() {
        super.onStop()
        println("test")
        //d for debug for information, for warning, for error
        Log.d("MainActivity_onStart", "executing onStop")
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
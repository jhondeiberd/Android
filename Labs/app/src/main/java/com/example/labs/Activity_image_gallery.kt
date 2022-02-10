package com.example.labs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView

class Activity_image_gallery : AppCompatActivity() {

    lateinit var imageMain: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_gallery)

        imageMain = findViewById(R.id.image_main)
        var image1 = findViewById<ImageView>(R.id.image1)
        var image2 = findViewById<ImageView>(R.id.image2)
        var image3 = findViewById<ImageView>(R.id.image3)
        
        image1.setOnClickListener(this::setupImage)
        image2.setOnClickListener(this::setupImage)
        image3.setOnClickListener(this::setupImage)

    }

    private fun setupImage(view: View) {
        if (view is ImageView) {
            imageMain.setImageDrawable(view.drawable)
        }
    }

}
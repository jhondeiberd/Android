package com.example.day3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView

class PictureActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_picture)
        val image = findViewById<ImageView>(R.id.picture_image)
        val changeImage = findViewById<Button>(R.id.picture_changeButton)

        changeImage.setOnClickListener {
            run {

                image.setImageResource(R.drawable.ic_launcher_foreground)
            }
        }
    }
}
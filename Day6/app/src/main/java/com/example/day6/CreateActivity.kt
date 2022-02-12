package com.example.day6

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class CreateActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_TITLE_KEY = "title"
        const val EXTRA_IMAGE_KEY = "image"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create)

        val title = findViewById<EditText>(R.id.create_title)
        val create = findViewById<Button>(R.id.create_createNature)

        val images = listOf<Int>(
            R.drawable.nature1,
            R.drawable.nature2,
            R.drawable.nature3
        )

        create.setOnClickListener {
            val intent = Intent().apply {
                putExtra(EXTRA_TITLE_KEY, title.text.toString())
                putExtra(EXTRA_IMAGE_KEY, images.random())
            }
            setResult(RESULT_OK, intent)
            finish()
        }
    }
}
package com.example.day4

import android.content.ActivityNotFoundException
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_SERIALIZABLE_KEY = "jddp"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        val toastButton = findViewById<Button>(R.id.main_toastButton)

        toastButton.setOnClickListener {
            val myToast = Toast.makeText(this,"Not important Info", Toast.LENGTH_LONG)
                myToast.setGravity(Gravity.TOP,0,0)
                myToast.show()
        }

        val explicitIntent = findViewById<Button>(R.id.main_explicitIntent)
        explicitIntent.setOnClickListener {
            val sendIntent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, "Hello you!")
                type = "text/plain"
            }
            try{
                startActivity(sendIntent)
            } catch (e : ActivityNotFoundException){

            }
        }


        val rezaTeacher = Teacher("Reza", "M")
        val safaldeepStudent = Student("Safaldeep", "S")

        val sendData = findViewById<Button>(R.id.main_sendData)
        explicitIntent.setOnClickListener {
            val intent = Intent(this, ProfileActivity::class.java).apply {
                putExtra(EXTRA_SERIALIZABLE_KEY, rezaTeacher)
            }
            startActivity(intent)
        }

        
    }
}
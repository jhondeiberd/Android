package com.example.day2

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity()  {
    companion object {
        public const val EXTRA_NAME_KEY = "name"
    }
    
    private lateinit var nameEditText : EditText
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        //inferred
        //val means a constant variable.
        nameEditText = findViewById<EditText>(R.id.main_name)
        val acceptButton = findViewById<Button>(R.id.main_accept)
        val otherButton = findViewById<Button>(R.id.main_otherButton)
        //EditText nameEditText = findViewById(R.id.main_name);
        
        nameEditText.setText("I am the king of the kings")
        nameEditText.setTextColor(Color.RED)
        
        acceptButton.setTextColor(Color.CYAN)
        //acceptButton.setOnClickListener(this)
//        acceptButton.setOnClickListener {
//            Log.e("MainActivity_anonymousClass", "Button Clicked")
//        }
        acceptButton.setOnClickListener(this::acceptClicked)
        nameEditText.setOnClickListener(this::acceptClicked)
        otherButton.setOnClickListener(this::acceptClicked)
    }
    
    //View represents the View that got clicked.
    private fun acceptClicked(view: View?) {
        if (view is EditText){
            val e : EditText = view //Cast to EditText
            Log.e("MainActivity_acceptClicked", e.text.toString())
        }
        if (view is Button) {   //Check Type
            val e : Button = view
            if (e.text.toString().equals("accept", true)){
                //val anyVariable = findViewById<EditText>(R.id.main_name) //BAD // EXTENSIVE TASK
                Log.e("ACCEPT",nameEditText.text.toString() )
                //Change Activity
                val intent = Intent(this, DetailsActivity::class.java).apply {
                    putExtra(Companion.EXTRA_NAME_KEY, nameEditText.text.toString())
                    putExtra("ExtraKey", "ExtraValue")
                }
                startActivity(intent)
                
            }
            
            Log.e("MainActivity_acceptClicked", e.text.toString())
        }
    }
    
    public  fun onClick(v: View?) {
        Log.e("MainActivity_onClick", "Button Clicked.")
    }
    
    
    
}
package com.example.gamedice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    companion object{
        const val EXTRA_CHANGE_DICES = "name"
    }

    private lateinit var dice: ImageView
    private var numbers = IntArray(6){0}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dice = findViewById(R.id.dice)

        val play = findViewById<Button>(R.id.play).setOnClickListener(this::changeDice)
        val results = findViewById<Button>(R.id.results).setOnClickListener(this::results)
    }

    private fun results(view: View){
        val intent = Intent(this, GameDicesResult::class.java)
        intent.putExtra(EXTRA_CHANGE_DICES, numbers)
        startActivity(intent)
    }

    private fun changeDice(view: View) {
        val randomNumber = (1..6).random()
        numbers[randomNumber-1]++
        when (randomNumber) {
            1 -> dice.setImageResource(R.drawable.dicenum1)
            2 -> dice.setImageResource(R.drawable.dicenum2)
            3 -> dice.setImageResource(R.drawable.dicenum3)
            4 -> dice.setImageResource(R.drawable.dicenum4)
            5 -> dice.setImageResource(R.drawable.dicenum5)
            6 -> dice.setImageResource(R.drawable.dicenum6)
        }
    }
}
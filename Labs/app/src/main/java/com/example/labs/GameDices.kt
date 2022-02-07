package com.example.labs

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView

class GameDices : AppCompatActivity() {

    companion object{
       const val EXTRA_CHANGE_DICES = "dicenum1"
    }

    private lateinit var dice: ImageView
//    private val numbers = ArrayList<Int>()
    private val numbers = IntArray(6){0}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_dices)

        dice = findViewById(R.id.dice)
        val results = findViewById<Button>(R.id.results)

        results.setOnClickListener {
            val intent = Intent(this, GameDicesResult::class.java).apply {
                intent.putExtra(EXTRA_CHANGE_DICES, numbers)
            }
            startActivity(intent)
        }

        val change = findViewById<Button>(R.id.change).setOnClickListener(this::changeDic)
    }

    private fun changeDic(view: View) {
        val randomNumber = (1..6).random()
//        numbers.add(randomNumber)
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
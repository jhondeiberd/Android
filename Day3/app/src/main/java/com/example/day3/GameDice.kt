package com.example.day3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewDebug
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import kotlin.random.Random

class GameDice : AppCompatActivity() {

    var mCouter = 0
    val numbers = {R.drawable.num1; R.drawable.num2; R.drawable.num3; R.drawable.num4; R.drawable.num5; R.drawable.num6}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_dice)

        val dice = findViewById<ImageView>(R.id.dice)
        val change = findViewById<Button>(R.id.chance)
        val count = findViewById<TextView>(R.id.counter)

        change.setOnClickListener {
            run {
                val randomNumber = (1..6).random()
                mCouter ++
//                count.setText(ViewDebug.IntToString(mCouter))

                when (randomNumber) {
                    1 -> {
                        dice.setImageResource(R.drawable.num1)
                    }
                    2 -> {
                        dice.setImageResource(R.drawable.num2);
                    }
                    3 -> {
                        dice.setImageResource(R.drawable.num3);
                    }
                    4 -> {
                        dice.setImageResource(R.drawable.num4);
                    }
                    5 -> {
                        dice.setImageResource(R.drawable.num5);
                    }
                    else -> {
                        dice.setImageResource(R.drawable.num6);
                    }
                }
            }

        }
    }
}
package com.example.labs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView

class GameDicesResult : AppCompatActivity() {

//    private lateinit var totalRolls: TextView
    private lateinit var result1: TextView
    private lateinit var result2: EditText
    private lateinit var result3: EditText
    private lateinit var result4: EditText
    private lateinit var result5: EditText
    private lateinit var result6: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_dices_result)

        val totalRolls = findViewById<TextView>(R.id.totalRolls)
        result1 = findViewById(R.id.result_1)
        result2 = findViewById(R.id.result_2)
        result3 = findViewById(R.id.result_3)
        result4 = findViewById(R.id.result_4)
        result5 = findViewById(R.id.result_5)
        result6 = findViewById(R.id.result_6)
        val restart = findViewById<Button>(R.id.restart)

        val myIntent = intent
        if (myIntent.hasExtra(GameDices.EXTRA_CHANGE_DICES)) {
            val rolls = myIntent.getIntArrayExtra(GameDices.EXTRA_CHANGE_DICES)
            val numRolls = rolls!!.sum().toFloat()

            totalRolls.text = numRolls.toString()
            result1.text = resources.getString(R.string.rolls, rolls[0], rolls[0] /numRolls*100)

        }
    }




}
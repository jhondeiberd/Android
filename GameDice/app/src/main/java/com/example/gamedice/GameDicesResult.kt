package com.example.gamedice

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class GameDicesResult : AppCompatActivity() {
    private lateinit var totalRolls: TextView
    private lateinit var result1: TextView
    private lateinit var result2: TextView
    private lateinit var result3: TextView
    private lateinit var result4: TextView
    private lateinit var result5: TextView
    private lateinit var result6: TextView

    @SuppressLint("StringFormatMatches")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_dices_result)

        totalRolls = findViewById(R.id.totalRolls)
        result1 = findViewById(R.id.result_1)
        result2 = findViewById(R.id.result_2)
        result3 = findViewById(R.id.result_3)
        result4 = findViewById(R.id.result_4)
        result5 = findViewById(R.id.result_5)
        result6 = findViewById(R.id.result_6)
        val restart = findViewById<Button>(R.id.restart).setOnClickListener(this::restartGame)

        val myIntent = intent
        if (myIntent.hasExtra(MainActivity.EXTRA_CHANGE_DICES)) {
            val rolls = myIntent.getIntArrayExtra(MainActivity.EXTRA_CHANGE_DICES)
            val numRolls = rolls!!.sum().toFloat()

            totalRolls.text = numRolls.toInt().toString()
            result1.text = resources.getString(R.string.resultNumber, rolls[0], rolls[0]/numRolls *100)
            result2.text = resources.getString(R.string.resultNumber, rolls[1], rolls[1]/numRolls *100)
            result3.text = resources.getString(R.string.resultNumber, rolls[2], rolls[2]/numRolls *100)
            result4.text = resources.getString(R.string.resultNumber, rolls[3], rolls[3]/numRolls *100)
            result5.text = resources.getString(R.string.resultNumber, rolls[4], rolls[4]/numRolls *100)
            result6.text = resources.getString(R.string.resultNumber, rolls[5], rolls[5]/numRolls *100)
        }
    }

    private fun restartGame(view: View) {
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra(MainActivity.EXTRA_CHANGE_DICES, Int.MIN_VALUE )
        startActivity(intent)
    }
}
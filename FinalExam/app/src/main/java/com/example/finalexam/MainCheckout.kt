package com.example.finalexam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainCheckout : AppCompatActivity() {
    companion object {
        const val EXTRA_ID_KEY = "id"
        const val EXTRA_NAME_KEY = "name"
        const val EXTRA_DESCRIP_KEY = "description"
        const val EXTRA_PRICE_KEY = "price"
    }

    private val purchaseId = ""
    private val purchaseName = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_checkout)

        val purchase : Button = findViewById(R.id.main_purchase)

        purchase.setOnClickListener {
            val intent = Intent().apply {
                putExtra(EXTRA_ID_KEY, purchaseId)
                putExtra(EXTRA_NAME_KEY, purchaseName)
            }
            setResult(RESULT_OK, intent)
            finish()
        }

    }
}
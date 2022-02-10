package com.example.day5

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class AlertDialogActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val alertDialogButton = findViewById<Button>(R.id.main_alertDialog)

        alertDialogButton.setOnClickListener {
            val builder: AlertDialog.Builder = AlertDialog.Builder(this).apply {
                setTitle(R.string.dialogTitle)
                setMessage(R.string.dialogMessage)

            }
            builder.setPositiveButton(R.string.positiveButton, this::dialogClick)
            builder.setNegativeButton(R.string.negativeButton, this::dialogClick)
            builder.setNeutralButton(R.string.neutralButton, this::dialogClick)
//            builder.setNegativeButton(R.string.negativeButton) { _, _ ->
//                Toast.makeText(this, "Negative", Toast.LENGTH_SHORT).show()
//            }
//
//            builder.setNeutralButton(R.string.neutralButton, DialogInterface.OnClickListener { dialog, which ->
//                Toast.makeText(this, "Neutral", Toast.LENGTH_SHORT).show()
//            })

            builder.show()
        }
    }

    fun dialogClick(dialog:DialogInterface, which: Int) {
        when (which) {
            DialogInterface.BUTTON_POSITIVE -> Toast.makeText(this, "Positive", Toast.LENGTH_SHORT).show()
            DialogInterface.BUTTON_NEGATIVE -> Toast.makeText(this, "Negative", Toast.LENGTH_SHORT).show()
            DialogInterface.BUTTON_NEUTRAL -> Toast.makeText(this, "Neutral", Toast.LENGTH_SHORT).show()
        }
    }
}

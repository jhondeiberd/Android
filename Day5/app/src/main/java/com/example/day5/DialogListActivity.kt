package com.example.day5

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class DialogListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val alertDialogButton = findViewById<Button>(R.id.main_alertDialog)

        alertDialogButton.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle(R.string.dialogTittle)
//            val myValues: CharSequence? = listOf<CharSequence>("Apple", "Orange", "Pear", "Banana")
            builder.setItems(R.array.dialogList, this::dialogListClicked)
            builder.show()
        }
    }

    private fun dialogListClicked(dialog: DialogInterface, which: Int){
        when(which){
            0 -> Toast.makeText(this, "Apple clicked", Toast.LENGTH_SHORT).show()
            1 -> Log.e("DialogListActivity_dialogListClicked", "Orange clicked")
            2, 3 -> Log.e("DialogListActivity_dialogListClicked", "Remain fruits")
        }
    }

}
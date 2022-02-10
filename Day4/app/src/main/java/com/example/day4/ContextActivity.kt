package com.example.day4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.View
import android.widget.Button
import android.widget.Toast

class ContextActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_context)

        val popButton = findViewById<Button>(R.id.context_pop)

        popButton.setOnClickListener { Toast.makeText(this, "POP", Toast.LENGTH_SHORT).show() }

        popButton.setOnLongClickListener {
            Toast.makeText(this, "Context POP", Toast.LENGTH_SHORT).show()
            true  //Consumes Click Events. So OnClick doesn't happen
        }

        //registerForContextMenu(popButton) //This superseeds LongClickEvent.
    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menuInflater.inflate(R.menu.c_menu, menu)
    }

}

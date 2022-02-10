package com.example.day4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true //True shows Menu
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return when (item.itemId) {
            R.id.menu_a -> {
                Toast.makeText(this, "A Clicked", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.menu_aMenuItem1, R.id.menu_aMenuItem2 -> {
                Toast.makeText(this, "SubMenu", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.menu_b -> {
                val mySnackbar = Snackbar.make(findViewById(R.id.menu_parent),"SnackBar", Snackbar.LENGTH_INDEFINITE)
                mySnackbar.setAction("Dismiss") { Log.e("Asd", "Asd") }
                mySnackbar.show()
                true
            }
            R.id.menu_c -> {
                Toast.makeText(this, "C Clicked", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.menu_d -> {
                Toast.makeText(this, "D Clicked", Toast.LENGTH_SHORT).show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
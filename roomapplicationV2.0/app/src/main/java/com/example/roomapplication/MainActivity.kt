package com.example.roomapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer
import com.example.roomapplication.db.AppDatabase
import com.example.roomapplication.db.entities.User
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val hello = findViewById<TextView>(R.id.main_hello)
        val changeButton = findViewById<Button>(R.id.main_changeValue)

        val database = AppDatabase.getDatabaseInstance(this)
        val userDao = database.userDao()


        var user : User? = null

        AppDatabase.databaseWriteExecutor.execute {
            user = User("daa", "a", "rohit", "AAAAA")
            val id = userDao.insert(user as User)
            user?.id = id
            Log.e("Asda", user?.id.toString())
        }

        userDao.getUser("daa").observe(this, Observer { user ->
            hello.text = user?.lastName
        })

        changeButton.setOnClickListener {
            user?.lastName = "Diaz"
            AppDatabase.databaseWriteExecutor.execute {

                userDao.update(user as User)
            }
        }


    }
}
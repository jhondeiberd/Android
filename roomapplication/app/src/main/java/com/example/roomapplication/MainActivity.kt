package com.example.roomapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.roomapplication.db.AppDatabase
import com.example.roomapplication.db.entities.User
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val hello = findViewById<TextView>(R.id.main_hello)

        val database = AppDatabase.getDatabaseInstance(this)
        val userDao = database.userDao()

        AppDatabase.databaseWriteExecutor.execute {
            val user = User("rohit", "a", "rohit", "Amazing")
            userDao.insert(user)
        }

        AppDatabase.databaseWriteExecutor.execute {
            //On a different Thread. So we might not have access to everythign.
            val user = userDao.getUser("rohit")
            hello.text = user.lastName

        }
    }
}
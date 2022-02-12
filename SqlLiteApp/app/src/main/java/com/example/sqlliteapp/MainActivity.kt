package com.example.sqlliteapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.sqlliteapp.db.DatingDBContract
import com.example.sqlliteapp.db.UserTable

class MainActivity : AppCompatActivity() {
    lateinit var userTable: UserTable
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        userTable = UserTable(this)

        //userTable.insertData("reza", "pw", "rez", "M")
        val myUsers = userTable.getAll()
        val rezaUser = userTable.get("rezaUser")
        rezaUser?.firstName = "adsa"

        if (rezaUser != null) {
            userTable.update(rezaUser)
        }

    }





}
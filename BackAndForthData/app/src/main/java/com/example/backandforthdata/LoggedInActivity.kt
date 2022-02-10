package com.example.backandforthdata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class LoggedInActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_logged_in)

        var fullName = findViewById<TextView>(R.id.loggedIn_hello)

        val intent = intent
        if (intent.hasExtra(LoginActivity.EXTRA_VALUE_DATA)) {
            val user: RegisterActivity.UserInfo? =
                intent.getSerializableExtra(LoginActivity.EXTRA_VALUE_DATA) as? RegisterActivity.UserInfo
            val message = String.format("Hello " + user?.firstname + " " + user?.lastname)
            println(message)
            fullName.setText(message)
        }

    }
}
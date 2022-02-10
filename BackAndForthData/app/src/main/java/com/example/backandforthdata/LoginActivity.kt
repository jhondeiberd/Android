package com.example.backandforthdata

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts

class LoginActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_VALUE_DATA = "user"
    }

    lateinit var loginUsername: EditText
    lateinit var loginPassword: EditText
    private var userInfo: RegisterActivity.UserInfo? = null

    private val dataUser =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { users: ActivityResult ->
        run {
            if (users.resultCode == Activity.RESULT_OK) {
                val intent = users.data
                if (intent != null) {
                    if (intent.hasExtra(RegisterActivity.EXTRA_VALUE)) {
                        val login =
                            intent.getSerializableExtra(RegisterActivity.EXTRA_VALUE) as RegisterActivity.UserInfo
                        userInfo = login
                    }
                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        loginUsername = findViewById(R.id.login_username)
        loginPassword = findViewById(R.id.login_password)
        var login = findViewById<Button>(R.id.login_login).setOnClickListener(this::login)

        val register = findViewById<Button>(R.id.login_register).setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }

    private fun login(view: View) {
        Log.e("value", userInfo!!.firstname)
        if (loginUsername.text.toString() == "" || loginPassword.text.toString() == "") {
            Toast.makeText(this, "Username and Password cannot be left empty", Toast.LENGTH_SHORT)
                .show()
        } else if (userInfo == null) {
            Toast.makeText(this, "You need to register a new user", Toast.LENGTH_LONG).show()
        } else if (loginUsername.text.toString() != userInfo!!.username || loginPassword.text.toString() != userInfo!!.password) {
            Toast.makeText(this, "Username or Password wrong", Toast.LENGTH_SHORT).show()//
        } else {
            val intent = Intent(this, LoggedInActivity::class.java)
            intent.putExtra(EXTRA_VALUE_DATA, userInfo)
            startActivity(intent)
        }
    }
}
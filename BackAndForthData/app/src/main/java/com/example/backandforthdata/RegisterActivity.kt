package com.example.backandforthdata

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import java.io.Serializable

class RegisterActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_VALUE = "name"
    }

    data class UserInfo(
        val username: String,
        val password: String,
        val firstname: String,
        val lastname: String
    ) : Serializable

    lateinit var regUsername: EditText
    lateinit var regPassword: EditText
    lateinit var regRepeatPassword: EditText
    lateinit var firstName: EditText
    lateinit var lastName: EditText

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        regUsername = findViewById(R.id.register_username)
        regPassword = findViewById(R.id.register_password)
        regRepeatPassword = findViewById(R.id.register_repeatPassword)
        firstName = findViewById(R.id.register_firstName)
        lastName = findViewById(R.id.register_lastName)
        var submit = findViewById<Button>(R.id.register_submit).setOnClickListener(this::registerNewUser)

    }

    private fun registerNewUser (view: View) {
        if (regUsername.text.toString() == ""
            || regPassword.text.toString() == ""
            || regRepeatPassword.text.toString() == ""
            || firstName.text.toString() == ""
            || lastName.text.toString() == "" ) {
            Toast.makeText(this, "No field can be left empty", Toast.LENGTH_SHORT).show()
        } else if (regPassword.text.toString() != regRepeatPassword.text.toString()) {
                Toast.makeText(this, "Passwords are not the same", Toast.LENGTH_SHORT).show()//
        } else {
            val newLogin = UserInfo (
                regUsername.text.toString(),
                regPassword.text.toString(),
                firstName.text.toString(),
                lastName.text.toString()
            )
            val intent = Intent(this, LoginActivity::class.java)
            intent.putExtra(EXTRA_VALUE, newLogin)
            setResult(RESULT_OK, intent)
            startActivity(intent)
        }
    }
}

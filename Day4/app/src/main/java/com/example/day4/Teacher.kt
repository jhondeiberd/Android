package com.example.day4

import java.io.Serializable

data class Teacher (private var firstName: String, var lastName: String) : Serializable {
    private val age: Int = 12

    public fun getFirstName() : String {
        return firstName
    }

}
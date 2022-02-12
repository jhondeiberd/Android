package com.example.sqlliteapp.entities

class User(
    val id: Int,
    val username: String,
    private var password: String,
    var firstName: String,
    var lastName: String
) {
    fun getPassword(): String {
        return password
    }

    fun changePassword(oldPassword: String, newPassword: String, repeatNewPassword: String): Boolean {
        if (oldPassword != password) return false

        if (newPassword == repeatNewPassword){
            password = newPassword
            return true
        }
        return false
    }
}
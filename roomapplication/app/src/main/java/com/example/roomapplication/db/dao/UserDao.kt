package com.example.roomapplication.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.roomapplication.db.entities.User

@Dao
interface UserDao {

    @Query("SELECT * FROM User where username like :username")
    fun getUser(username: String) : User

    @Query("SELECT COUNT(*) FROM User where username like :username and password like :password")
    fun authenticate(username: String, password: String) : Int

    @Insert
    fun insert(vararg user: User)

    @Delete
    fun delete(vararg user: User)


}
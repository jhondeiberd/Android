package com.example.finalproject.db.dao

import androidx.room.*
import com.example.finalproject.entities.Transaction

@Dao
interface TransactionDao {

    @Query("SELECT * FROM transactions")
    fun getAll(): List<Transaction>

    @Insert
    fun insertAll(vararg transaction: Transaction)

    @Delete
    fun delete(vararg transaction: Transaction)

    @Update
    fun update(vararg transaction: Transaction)
}
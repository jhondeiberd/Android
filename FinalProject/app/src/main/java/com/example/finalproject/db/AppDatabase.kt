package com.example.finalproject.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.finalproject.db.dao.TransactionDao
import com.example.finalproject.entities.Transaction

@Database(entities = arrayOf(Transaction::class), version =1)
abstract class AppDatabase: RoomDatabase() {

    abstract fun transactionDao(): TransactionDao
}
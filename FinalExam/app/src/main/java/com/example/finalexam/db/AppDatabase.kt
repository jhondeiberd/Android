package com.example.finalexam.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.finalexam.db.dao.ProductDao
import com.example.finalexam.entities.Product
import java.util.concurrent.Executors

//@Database(entities = [Product::class], version =1)
//abstract class AppDatabase : RoomDatabase() {

    //TODO: Add DAOs here
//    abstract fun ProductDao(): ProductDao
//
//    companion object {
//        private const val NUMBER_OF_THREADS = 4
//        val databaseWriteExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS)
//
//        private var INSTANCE: AppDatabase? = null
//
//        fun getDatabaseInstance(context: Context): AppDatabase {
//            return INSTANCE ?: synchronized(this) {
//                val instance = Room.databaseBuilder(
//                    context.applicationContext,
//                    AppDatabase::class.java,
//                    "final_exam_database"
//                )
//                    .fallbackToDestructiveMigration()
//                    .build()
//
//                INSTANCE = instance
//
//                instance
//            }
//        }
//    }
//}
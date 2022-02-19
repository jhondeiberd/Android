package com.example.musicdiscogs.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.musicdiscogs.db.dao.AlbumDao
import com.example.musicdiscogs.entities.Album
import java.util.concurrent.Executors

//TODO: Add Entities and change version if you modified the database
@Database(entities = [Album::class], version =3)
abstract class AppDatabase : RoomDatabase(){

    //TODO: Add DAOs here
    abstract fun albumDao(): AlbumDao

    companion object {
        private const val NUMBER_OF_THREADS = 4
        val databaseWriteExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS)

        private var INSTANCE: AppDatabase? = null

        fun getDatabaseInstance(context: Context) : AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "albums_database")
                    .fallbackToDestructiveMigration()
                    .build()

                INSTANCE = instance

                instance
            }
        }
    }

}
package com.example.musicdiscogs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.example.musicdiscogs.RecycleView.DiscogsAdapter
import com.example.musicdiscogs.db.AppDatabase

class MainAlbumBD : AppCompatActivity() {

    private val discogsAdapter = DiscogsAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_album_bd)

        val database = AppDatabase.getDatabaseInstance(this)
        val albumDao = database.albumDao()

        AppDatabase.databaseWriteExecutor.execute {
            val album = albumDao.getAll()
            discogsAdapter.addData(album)
        }

        val recyclerView = findViewById<RecyclerView>(R.id.main_recycle_db)
        recyclerView.adapter = discogsAdapter
    }
}
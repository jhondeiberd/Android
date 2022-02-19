package com.example.musicdiscogs

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.example.musicdiscogs.RecycleView.DiscogsAdapter
import com.example.musicdiscogs.db.AppDatabase
import com.example.musicdiscogs.entities.Album
import com.squareup.picasso.Picasso

class MainAlbumDetails : AppCompatActivity() {

    private lateinit var detailImage: ImageView
    private lateinit var detailTitle: TextView
    private lateinit var detailGenre: TextView
    private lateinit var detailYear: TextView
    private lateinit var detailId: TextView
    private lateinit var add: Button
    private var detailData: Album? = null

    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_album_details)

        var albumDB = false

        detailImage = findViewById(R.id.main_detail_image)
        detailTitle = findViewById(R.id.main_detail_title)
        detailGenre = findViewById(R.id.main_detail_genre)
        detailYear = findViewById(R.id.main_detail_year)
        detailId = findViewById(R.id.main_detail_id)
        add = findViewById(R.id.main_add)

        val database = AppDatabase.getDatabaseInstance(this)
        val albumDao = database.albumDao()

        var album: Album? = null

        val intent = intent
        if (intent.hasExtra(DiscogsAdapter.DiscogsItemViewHolder.EXTRA_VALUE)) {
            detailData =
                intent.getSerializableExtra(DiscogsAdapter.DiscogsItemViewHolder.EXTRA_VALUE) as Album
        }

        if (detailData != null) {
            Picasso.get()
                .load(detailData?.image)
                .into(detailImage)
            detailTitle.setText(detailData?.title)
            detailGenre.setText(detailData?.type)
            detailYear.setText(detailData?.yearReleased)
            detailId.setText(detailData?.masterId)
        }

        fun addAlbumDB(view: View) {

        }

        add.setOnClickListener {
            if (albumDB == false) {
                AppDatabase.databaseWriteExecutor.execute {
                    album = Album(
                        detailData?.title,
                        detailData?.type,
                        detailData?.yearReleased,
                        detailData?.masterId,
                        detailData?.image.toString()
                    )
                    val id = albumDao.insert(album as Album)
                    album?.id = id
                }
                add.setText("DELETE")
                add.setBackgroundColor(com.google.android.material.R.color.error_color_material_dark)
                Toast.makeText(this, "Album Added", Toast.LENGTH_LONG).show()
                albumDB = true
            } else {
                AppDatabase.databaseWriteExecutor.execute {
                    albumDao.delete(album as Album)
                }
                add.setText("ADD")
                add.setBackgroundColor(R.color.teal_700)
                Toast.makeText(this, "Album deleted", Toast.LENGTH_LONG).show()
                albumDB = false
            }
        }
    }
}
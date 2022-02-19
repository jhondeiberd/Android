package com.example.musicdiscogs

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import androidx.recyclerview.widget.RecyclerView
import com.example.musicdiscogs.Network.DiscogsApi
import com.example.musicdiscogs.RecycleView.DiscogsAdapter
import com.example.musicdiscogs.entities.ListOfAlbums
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity(), retrofit2.Callback<ListOfAlbums> {
    private val discogsAdapter = DiscogsAdapter()

    lateinit var searchAlbum: TextView
    lateinit var search: Button
    lateinit var favorite: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.main_list_track)
        recyclerView.adapter = discogsAdapter

        searchAlbum = findViewById<EditText>(R.id.main_txt_search)
        search = findViewById(R.id.main_search)
        favorite = findViewById(R.id.main_favorite)

        search.setOnClickListener(this::onClickSearch)
        favorite.setOnClickListener(this::albumsTableDatabase)

        recyclerView.setHasFixedSize(true)

    }


    fun onClickSearch(view: View) {
        if (searchAlbum.text.toString() != "") {
            val executeApi = DiscogsApi.retrofitService.getSearchResults(
                "HqxUsNVvKyCcWxTEqQOq",
                "KiqejQWKGjWTcwxZPTTHxiEEzzfQyAod",
                searchAlbum.text.toString(), "canada"
            )
            executeApi.enqueue(this)
        } else {
            Toast.makeText(this, "Please, insert an artist to find", Toast.LENGTH_LONG).show()
        }
    }


    override fun onResponse(call: Call<ListOfAlbums>, response: Response<ListOfAlbums>) {
        searchAlbum.setText("")
        discogsAdapter.removeData()
        val dataApi = response.body()
        if (dataApi != null) {
            val albumsData = dataApi.albums

            if (albumsData.count() != 0) {
                discogsAdapter.addData(albumsData)
            } else {
                Toast.makeText(this, "Artist does not found", Toast.LENGTH_LONG).show()
            }
        }
    }


    override fun onFailure(call: Call<ListOfAlbums>, t: Throwable) {
        println(t)
    }

    private fun albumsTableDatabase(view: View){
        val intent = Intent(this, MainAlbumBD::class.java)
        startActivity(intent)
    }

}
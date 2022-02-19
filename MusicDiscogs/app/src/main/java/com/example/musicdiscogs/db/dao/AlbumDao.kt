package com.example.musicdiscogs.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.musicdiscogs.entities.Album

@Dao
interface AlbumDao {

    @Query("SELECT * FROM Album where id = :id")
    fun getAlbum(id: Long) : LiveData<Album>

    @Query("SELECT * FROM Album")
    fun getAll() : List<Album>

    @Insert
    fun insert(album: Album) : Long   //Id is returned.

    @Delete
    fun delete(vararg album: Album)

    @Update
    fun update(vararg album: Album)
}
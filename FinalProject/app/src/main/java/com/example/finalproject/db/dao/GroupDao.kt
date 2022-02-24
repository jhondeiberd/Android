package com.example.finalproject.db.dao

import androidx.room.*
import com.example.finalproject.entities.Group

@Dao
interface GroupDao {
    @Query("SELECT * FROM groups ORDER BY groupItem")
    fun getAll(): List<Group>

    @Insert
    fun insertAll(vararg group: Group)

    @Delete
    fun delete(vararg group: Group)

    @Update
    fun update(vararg group: Group)
}
package com.example.finalproject.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "groups")
class Group (
        @PrimaryKey(autoGenerate = true) val id: Int,
        val groupItem: String,
        val descriptionGroup: String,
) : Serializable {
}
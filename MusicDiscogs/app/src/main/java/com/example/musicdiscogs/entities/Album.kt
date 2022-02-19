package com.example.musicdiscogs.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable

val genre = StringBuilder();

@Entity
data class Album(
    @SerializedName("title") @ColumnInfo(name = "title") val title: String?,
    @SerializedName("type") @ColumnInfo(name = "type") val type:String?,
    @SerializedName("year") @ColumnInfo(name = "year_released") val yearReleased: String?,
    @SerializedName("master_id") @ColumnInfo(name = "master_id") val masterId: String?,
    @SerializedName("cover_image") @ColumnInfo(name = "cover_image") val image: String?,
): Serializable {
    @PrimaryKey(autoGenerate = true) var id: Long = 0
}
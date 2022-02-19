package com.example.musicdiscogs.entities

import com.google.gson.annotations.SerializedName

data class ListOfAlbums (
    @SerializedName("results") val albums :MutableList<Album>){
    //Other methods here
}
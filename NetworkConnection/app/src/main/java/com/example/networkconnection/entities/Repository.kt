package com.example.networkconnection.entities

import com.google.gson.annotations.SerializedName

class Repository(
    @SerializedName("full_name") val name : String?,
    val owner : User?

    ) {

        //Other methods here
    }
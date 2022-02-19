package com.example.finalexam.entities

import android.content.ClipDescription
import android.content.Context
import androidx.annotation.DrawableRes
import androidx.room.ColumnInfo
import androidx.room.PrimaryKey

class Product(
    val id: Int,
    val productName: String,
    val productDescription: String,
    val productPrice: Double,
    @DrawableRes val productImage: Int,

//    @PrimaryKey @ColumnInfo(name = "id") val id: Int,
//    @ColumnInfo(name = "product_name") val productName: String?,
//    @ColumnInfo(name = "product_description") val productDescription: String?,
//    @ColumnInfo(name = "product_price") val productPrice: Double?,
//    @ColumnInfo(name = "product_image") @DrawableRes val productImage: Int?,
) {
    constructor(context: Context,
                id: Int,
                productName: String,
                productDescription: String,
                productPrice: Double,
                @DrawableRes productImage: Int,

    )
            : this(id, productName, productDescription, productPrice, productImage)
}
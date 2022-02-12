package com.example.day6.entities

import android.content.Context
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes


data class Nature(
    @DrawableRes val image: Int,
    val title: String
) {
    constructor(context: Context, @DrawableRes image: Int, @StringRes titleId: Int)
            : this(image, context.resources.getString(titleId))
}
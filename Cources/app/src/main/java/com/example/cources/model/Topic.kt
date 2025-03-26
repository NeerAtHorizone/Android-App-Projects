package com.example.cources.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Topic(
    @StringRes val topic : Int,
    val count : Int,
    @DrawableRes val img : Int
)
package com.example.impl.componets

import androidx.annotation.DrawableRes

data class Page(
    val title: String,
    val description: String,
    @DrawableRes val image: Int
)
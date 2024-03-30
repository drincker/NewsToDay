package com.example.impl.componets

import androidx.annotation.DrawableRes
import com.exemple.impl.R

data class Page(
    val title: String,
    val discription: String,
    @DrawableRes val image: Int
)

val pages: List<Page> = listOf(
    Page(
        title = "Page 1",
        discription = "Blablabla1",
        image = R.drawable.image1
    ),
    Page(
        title = "Page 2",
        discription = "Blablabla2",
        image = R.drawable.image2
    ),
    Page(
        title = "Page 3",
        discription = "Blablabla3",
        image = R.drawable.image3
    )
)
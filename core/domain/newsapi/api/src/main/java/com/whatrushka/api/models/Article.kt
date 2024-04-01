package com.whatrushka.api.models

import com.whatrushka.api.models.static.Category
import kotlinx.serialization.Serializable

@Serializable
data class Article(
    val source: Source,
    val author: String?,
    val title: String,
    val description: String?,
    var category: Category? = null,
    val url: String,
    val urlToImage: String?,
    val publishedAt: String,
    val content: String?
)

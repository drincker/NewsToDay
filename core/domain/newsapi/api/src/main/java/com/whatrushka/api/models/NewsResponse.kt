package com.whatrushka.api.models

import com.whatrushka.api.models.Article
import kotlinx.serialization.Serializable

@Serializable
data class NewsResponse(
    val status: String,
    val totalResults: Int,
    val articles: List<Article>
)
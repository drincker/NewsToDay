package com.whatrushka.api.appbookmarks.models

import com.whatrushka.api.models.Article
import kotlinx.serialization.Serializable

@Serializable
data class Articles(
    val articles: List<Article> = emptyList()
) {

}

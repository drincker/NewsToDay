package com.whatrushka.api.appconfig.models

import com.whatrushka.api.models.Article
import com.whatrushka.api.models.static.Category
import com.whatrushka.api.models.static.Language
import kotlinx.serialization.Serializable

@Serializable
data class AppConfig(
    val isWelcome: Boolean = true,
    val language: Language = Language.EN,
    val favoriteCategories: Set<Category> = emptySet(),
    val articles: List<Article> = emptyList()
)
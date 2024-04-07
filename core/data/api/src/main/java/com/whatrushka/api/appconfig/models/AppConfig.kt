package com.whatrushka.api.appconfig.models

import com.whatrushka.api.models.static.Category
import com.whatrushka.api.models.static.Language
import kotlinx.serialization.Serializable

@Serializable
data class AppConfig(
    val isWelcome: Boolean = true,
    val language: Language = Language.RU,
    val favoriteCategories: Set<Category> = emptySet()
)
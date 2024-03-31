package com.whatrushka.api.appconfig.models

import com.whatrushka.api.models.static.Language
import kotlinx.serialization.Serializable

@Serializable
data class AppConfig(
    val language: Language = Language.RU
)
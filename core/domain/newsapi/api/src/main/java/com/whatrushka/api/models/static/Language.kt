package com.whatrushka.api.models.static

import kotlinx.serialization.Serializable

@Serializable
sealed class Language(val name: String, val fullName: String) {
    companion object {
        const val ApiName = "language"
    }

    @Serializable data object RU : Language("ru", "Russian")
    // TODO: Replace fullName to resourceID
    @Serializable data object EN : Language("en", "English")
}
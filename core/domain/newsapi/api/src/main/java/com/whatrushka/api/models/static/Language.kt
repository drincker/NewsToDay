package com.whatrushka.api.models.static

import kotlinx.serialization.Serializable

@Serializable
sealed class Language(val name: String, val fullName: String) {
    companion object {
        const val ApiName = "language"


        fun list() = listOf(
            RU,
            EN
        )
    }

    @Serializable
    data object RU : Language("ru", "Russian")

    @Serializable
    data object EN : Language("en", "English")
}
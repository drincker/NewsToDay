package com.whatrushka.api.models.static

sealed class Language(val name: String) {
    companion object {
        const val ApiName = "language"
    }

    data object RU : Language("ru")
    data object EN : Language("en")
}
package com.whatrushka.api.models.static

sealed class Category(val name: String) {
    companion object {
        const val ApiName = "category"
    }

    data object Business : Category("business")
    data object Entertainment : Category("entertainment")
    data object General : Category("general")
    data object Health : Category("health")
    data object Science : Category("science")
    data object Sports : Category("sports")
    data object Technology : Category("technology")
}
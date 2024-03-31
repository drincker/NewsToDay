package com.whatrushka.api.models.static

import kotlinx.serialization.Serializable

@Serializable
sealed class Category(val name: String) {
    companion object {
        const val ApiName = "category"

        fun list() = listOf(
            Business,
            Entertainment,
            General,
            Health,
            Science,
            Sports,
            Technology
        )

        fun filterList() = listOf(
            All,
            Business,
            Entertainment,
            General,
            Health,
            Science,
            Sports,
            Technology
        )
    }

    data object All : Category("All")

    data object Business : Category("business")
    data object Entertainment : Category("entertainment")
    data object General : Category("general")
    data object Health : Category("health")
    data object Science : Category("science")
    data object Sports : Category("sports")
    data object Technology : Category("technology")
}
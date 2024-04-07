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

    @Serializable
    data object All : Category("All")

    @Serializable
    data object Business : Category("business")
    @Serializable
    data object Entertainment : Category("entertainment")
    @Serializable
    data object General : Category("general")
    @Serializable
    data object Health : Category("health")
    @Serializable
    data object Science : Category("science")
    @Serializable
    data object Sports : Category("sports")
    @Serializable
    data object Technology : Category("technology")
}
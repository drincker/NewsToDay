package com.whatrushka.api.models.static

sealed class Category(open val name: String) {
    companion object {
        const val ApiName = "category"

        fun allCategories() = listOf(
            Random,
            Business,
            Entertainment,
            General,
            Health,
            Science,
            Sports,
            Technology
        )

        private fun categories() = listOf(
            Business,
            Entertainment,
            General,
            Health,
            Science,
            Sports,
            Technology
        )
    }

    data object Random : Category("") {
        override val name: String
            get() = Category.categories().random().name
    }

    data object Business : Category("business")
    data object Entertainment : Category("entertainment")
    data object General : Category("general")
    data object Health : Category("health")
    data object Science : Category("science")
    data object Sports : Category("sports")
    data object Technology : Category("technology")
}
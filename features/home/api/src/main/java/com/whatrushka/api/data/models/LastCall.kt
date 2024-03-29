package com.whatrushka.api.data.models

import com.whatrushka.api.models.static.Category

data class LastCall(
    val q: String = "",
    val category: Category = Category.Random
)
package com.whatrushka.api.data

import androidx.compose.runtime.MutableState
import com.whatrushka.api.models.static.Category

interface FilterService {
    fun getSelectedCategory(): Category

    fun getSelectedCategoryAsState(): MutableState<Category>

    fun getCategories(): List<Category>

    fun selectCategory(category: Category)

}
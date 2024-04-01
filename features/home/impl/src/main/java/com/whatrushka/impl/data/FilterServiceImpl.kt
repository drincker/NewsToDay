package com.whatrushka.impl.data

import androidx.compose.runtime.mutableStateOf
import com.whatrushka.api.data.FilterService
import com.whatrushka.api.models.static.Category

class FilterServiceImpl : FilterService {

    private var _selectedCategory = mutableStateOf<Category>(Category.All)

    override fun getSelectedCategory() = _selectedCategory.value

    override fun getSelectedCategoryAsState() = _selectedCategory

    override fun getCategories() = Category.filterList()

    override fun selectCategory(category: Category) {
        _selectedCategory.value = category
    }


}
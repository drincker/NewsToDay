package com.whatrushka.impl.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.whatrushka.api.data.FilterService
import com.whatrushka.api.models.static.Category
import com.whatrushka.impl.presentation.components.NewBox
import com.whatrushka.impl.presentation.components.Tag
import com.whatrushka.impl.data.HomeViewModel
import com.whatrushka.ui.components.ScreenAppBar
import com.whatrushka.ui.theme.NewsToDayType

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    viewModel: HomeViewModel,
    filterService: FilterService,
    modifier: Modifier = Modifier
) {
    val news = viewModel.getNewsAsState()
    val selectedCategory = filterService.getSelectedCategoryAsState()

    var q by remember { mutableStateOf("") }
    var active by remember { mutableStateOf(false) }

    LaunchedEffect(null) {
        viewModel.getNews(q)
    }

    Column {
        ScreenAppBar(
            title = "Browse",
            description = "Discover things of this world"
        )

        SearchBar(modifier = Modifier.fillMaxWidth(),
            query = q,
            onQueryChange = { q = it },
            onSearch = { active = false },
            active = active,
            onActiveChange = { active = it },
            placeholder = {
                Text(text = "Enter your query")
            },
            trailingIcon = {
                Icon(imageVector = Icons.Default.Search, contentDescription = null)
            }
        ) {}

        val onCategorySelected = { category: Category ->
            filterService.selectCategory(category)
        }

        LazyRow {
            Category.filterCategories().forEach {
                item {
                    Tag(it,
                        it == selectedCategory,
                        onCategorySelected
                    )

                    Spacer(Modifier.width(8.dp))
                }
            }
        }

        Spacer(Modifier.width(16.dp))

        Row {
            news.forEach {
                NewBox(it)
                Spacer(Modifier.width(8.dp))
            }
        }

        Row(
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                "Recommended for you",
                color = Color.Black,
                style = NewsToDayType.TitleMedium
            )
        }

        Column {

        }

    }
}
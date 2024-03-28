package com.whatrushka.impl.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.whatrushka.api.models.static.Category
import com.whatrushka.impl.presentation.components.Tag
import com.whatrushka.ui.components.ScreenAppBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier
) {
    Column {
        ScreenAppBar(
            title = "Browse",
            description = "Discover things of this world"
        )

        var text by remember { mutableStateOf("") }
        var active by remember { mutableStateOf(false) }

        SearchBar(modifier = Modifier.fillMaxWidth(),
            query = text,
            onQueryChange = {
                text = it
            },
            onSearch = {
                active = false
            },
            active = active,
            onActiveChange = {
                active = it
            },
            placeholder = {
                Text(text = "Enter your query")
            },
            trailingIcon = {
                Icon(imageVector = Icons.Default.Search, contentDescription = null)
            }
        ) {}

        Row {
            Category.allCategories().forEach {
                Tag(it)
                Spacer(Modifier.width(8.dp))
            }
        }

        Spacer(Modifier.width(16.dp))

        Row {

        }
    }
}
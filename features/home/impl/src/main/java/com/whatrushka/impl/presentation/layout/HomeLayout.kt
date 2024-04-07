package com.whatrushka.impl.presentation.layout

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.whatrushka.api.models.static.Category
import com.whatrushka.impl.data.HomeViewModel
import com.whatrushka.impl.navigation.HomeNavigator
import com.whatrushka.impl.presentation.components.NewBox
import com.whatrushka.impl.presentation.components.Tag
import com.whatrushka.ui.components.ScreenAppBar
import com.whatrushka.ui.theme.LightGrey
import com.whatrushka.ui.theme.NewsToDayType
import com.whatrushka.ui.theme.PrimaryGrey

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeLayout(
    viewModel: HomeViewModel,
    navigator: HomeNavigator,
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    val news = viewModel.getNewsAsState()
    val q = viewModel.getQAsState()
    val selectedCategory = viewModel.filterService.getSelectedCategoryAsState()

    LaunchedEffect(null) {
        viewModel.getNews()
    }

    Column(
        modifier
    ) {
        ScreenAppBar(
            title = "Browse",
            description = "Discover things of this world"
        )

        SearchBar(modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(15.dp),
            colors = SearchBarDefaults.colors(
                containerColor = LightGrey,
                inputFieldColors = TextFieldDefaults.colors(
                    focusedPlaceholderColor = PrimaryGrey,
                    unfocusedPlaceholderColor = PrimaryGrey,
                    unfocusedTextColor = PrimaryGrey,
                    focusedTextColor = PrimaryGrey
                )
            ),
            query = q.value,
            onQueryChange = { viewModel.setQ(it) },
            onSearch = {
                viewModel.getNews()
            },
            active = false,
            onActiveChange = {},
            placeholder = {
                Text(text = "Search news")
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = null,
                    tint = PrimaryGrey
                )
            }
        ) { }


        Spacer(Modifier.height(16.dp))

        LazyRow {
            Category.filterList().forEach {
                item {
                    Tag(
                        it,
                        selectedCategory.value,
                        Modifier.clickable {
                            viewModel.selectCategory(it)
                        }
                    )

                    Spacer(Modifier.width(8.dp))
                }
            }
        }

        Spacer(Modifier.height(16.dp))

        LazyRow {
            news.value.forEach {
                item {
                    NewBox(
                        it,
                        Modifier
                            .size(270.dp)
                            .clip(RoundedCornerShape(15.dp))
                            .clickable {
                                navigator.navigateToArticle(navController, it)
                            }
                    )

                    Spacer(Modifier.width(16.dp))
                }
            }
        }

        Spacer(Modifier.height(20.dp))

        Row(
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                "Recommended for you",
                color = Color.Black,
                style = NewsToDayType.TitleMedium
            )
        }

        Spacer(Modifier.height(16.dp))

        Column {

        }

    }
}
package com.example.impl.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.features.bookmarks.impl.R
import com.example.impl.navigation.BookmarksNavigator
import com.example.navigation.BookmarksRoute
import com.whatrushka.api.appconfig.AppConfigService
import com.whatrushka.api.models.Article
import com.whatrushka.ui.components.ScreenAppBar
import com.whatrushka.ui.components.navigation.ScaffoldWrapper
import com.whatrushka.ui.theme.LightGrey
import com.whatrushka.core.ui.R as coreR


@Composable
fun BookmarksScreen(
    navController: NavHostController,
    bookmarksService: AppConfigService,
    navigator: BookmarksNavigator,
    modifier: Modifier
) {
    val ballArticles = remember { mutableStateOf<List<Article>>(emptyList()) }
    LaunchedEffect(null) {
        ballArticles.value = bookmarksService.getPinned()
    }

    ScaffoldWrapper(BookmarksRoute, navController) {
        Column(modifier.padding(it)) {
            ScreenAppBar(title = "Bookmarks", description = "Saved articles to the library")
            if (ballArticles.value.isNotEmpty()) {
                LazyColumn {
                    items(ballArticles.value.size) { index ->
                        BookMarkCard(ballArticles.value[index]) { article ->
                            navigator.navigateToArticle(article)
                        }
                        Spacer(Modifier.height(16.dp))
                    }
                }
            } else {
                EmptyState()
            }
        }
    }
}

@Composable
fun EmptyState() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.book),
            contentDescription = null,
            modifier = Modifier.size(100.dp),
        )
        Text(
            text = "You haven't saved any articles yet. Start reading and bookmarking them now",
            style = TextStyle(
                fontSize = 16.sp,
                color = Color(0xFF333647), textAlign = TextAlign.Center,
                fontWeight = FontWeight.Medium
            ),
            modifier = Modifier.padding(start = 100.dp, end = 100.dp)
        )
    }
}

@Composable
fun BookMarkCard(
    article: Article,
    onClick: (Article) -> Unit
) {
    Row(
        Modifier
            .padding(0.dp, 16.dp)
            .clip(RoundedCornerShape(15.dp))
            .background(LightGrey)
            .clickable {
                onClick(article)
            }
    ) {
        AsyncImage(
            model = article.urlToImage,
            placeholder = painterResource(coreR.drawable.image_placeholder),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(96.dp)
                .clip(RoundedCornerShape(10.dp))
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column {
            Text(
                text = (article.category?.name ?: "No category"),
                style = TextStyle(
                    fontSize = 14.sp,
                    color = Color(0xFF7C82A1),
                ),
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = article.title,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                style = TextStyle(
                    fontSize = 16.sp,
                    color = Color(0xFF333647), fontWeight = FontWeight.Bold
                )
            )
        }
    }

}





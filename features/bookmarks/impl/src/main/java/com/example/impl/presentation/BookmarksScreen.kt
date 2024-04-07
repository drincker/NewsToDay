package com.example.impl.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.features.bookmarks.impl.R
import com.whatrushka.core.ui.R as coreR
import com.whatrushka.api.appbookmarks.AppArticlesService
import com.whatrushka.api.models.Article
import com.whatrushka.ui.components.ScreenAppBar


@Composable
fun BookmarksScreen(
    bookmarksService: AppArticlesService,
    modifier: Modifier
) {
    val ballArticles = remember { mutableStateOf<List<Article>>(emptyList()) }
    LaunchedEffect(null) {
        ballArticles.value = bookmarksService.getPinned()
    }

    Column(modifier) {
        Column(
            modifier = Modifier.padding(start = 20.dp, bottom = 30.dp, top = 30.dp),
            verticalArrangement = Arrangement.Bottom,
        ) {
            ScreenAppBar(title = "Bookmarks", description = "Saved articles to the library")

        }
        Spacer(modifier = Modifier.height(20.dp))
        if (ballArticles.value.isNotEmpty()) {
            LazyColumn {
                items(ballArticles.value.size) {
                    BookMarkCard(ballArticles.value[it])
                }
            }
        } else {
            NoOpigator()
        }

    }
}

@Composable
fun NoOpigator() {
    // Column {
    Column(
        modifier = Modifier.padding(start = 20.dp, bottom = 30.dp, top = 30.dp),
        verticalArrangement = Arrangement.Top,
    ) {
        Text(
            text = "Bookmarks",
            style = TextStyle(
                fontSize = 24.sp,
                color = Color(0xFF333647),
                fontWeight = FontWeight.Bold
            )
        )
        Text(
            text = "Saved articles to the library",
            //modifier = Modifier.padding(all = 4.dp),
            style = TextStyle(
                fontSize = 16.sp,
                textAlign = TextAlign.Center,
                color = Color(0xFF7C82A1)
            )
        )


    }
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
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
        // }
    }
}

@Composable
fun PreviewConversation() {

    NoOpigator()
    //Conversation(SampleData.conversationSample)
}

@Composable
fun BookMarkCard(tad: Article) {
    Row(modifier = Modifier.padding(start = 20.dp, end = 20.dp, bottom = 20.dp)) {
        tad.urlToImage?.let {
            AsyncImage(
                model = it,
                placeholder = painterResource(id = coreR.drawable.image_placeholder),
                contentDescription = null,
                modifier = Modifier
                    .size(96.dp)
                //.clip(CircleShape)
                //.border(1.5.dp, MaterialTheme.colorScheme.secondary, CircleShape)
            )
        }
        Spacer(modifier = Modifier.width(8.dp))
        Column() {
            tad.author?.let {
                Text(
                    text = it,
                    style = TextStyle(
                        fontSize = 14.sp,
                        color = Color(0xFF7C82A1),
                    ),
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            tad.publishedAt?.let {
                Text(
                    text = it,
                    //modifier = Modifier.padding(all = 4.dp),
                    style = TextStyle(
                        fontSize = 16.sp,
                        color = Color(0xFF333647), fontWeight = FontWeight.Bold
                    )
                )
            }
        }
    }
}





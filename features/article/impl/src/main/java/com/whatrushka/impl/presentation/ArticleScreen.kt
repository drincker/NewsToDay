package com.whatrushka.impl.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.whatrushka.api.models.Article
import com.whatrushka.api.models.Source
import com.whatrushka.core.ui.R
import com.whatrushka.ui.theme.NewsToDayType
import com.whatrushka.ui.theme.PrimaryGrey

@Preview
@Composable
fun ArticleScreenPreview() {
    ArticleScreen(
        modifier = Modifier.padding(16.dp),
        article = Article(
            Source("some", "some"),
            author = "John Doe",
            title = "The Gradle Error",
            description = "Lorem Ipsum",
            url = "https://google.com/",
            urlToImage = "https://mykaleidoscope.ru/x/uploads/posts/2022-10/1666389897_62-mykaleidoscope-ru-p-klassnaya-priroda-oboi-67.jpg",
            publishedAt = "2024-22-03",
            content = loremIpsum
        )
    )
}

@Composable
fun ArticleScreen(
    article: Article,
    modifier: Modifier = Modifier
) {
    val scrollState = rememberScrollState()

    Column(
        Modifier
            .verticalScroll(scrollState)
            .fillMaxSize()
            .background(Color(0xFFFFFFFF))
    ) {
        Box(
            Modifier
                .fillMaxWidth()
                .height(310.dp)
        ) {
            AsyncImage(
                contentDescription = null,
                model = article.urlToImage,
                placeholder = painterResource(R.drawable.icon_bookmark),
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )

            Box(
                Modifier
                    .fillMaxSize()
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(
                                Color(0x00FFFFFF),
                                Color(0x46000000),
                            )
                        )
                    )
            )

            Column(
                verticalArrangement = Arrangement.SpaceBetween,
                modifier = modifier.fillMaxSize()
            ) {

                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp)
                ) {
                    Icon(
                        contentDescription = null,
                        imageVector = ImageVector.vectorResource(R.drawable.icon_arrow_back),
                        modifier = Modifier.size(25.dp)
                    )
                    Column {
                        Icon(
                            contentDescription = null,
                            imageVector = ImageVector.vectorResource(R.drawable.icon_bookmark),
                            modifier = Modifier.size(25.dp)
                        )
                        Spacer(modifier = Modifier.height(20.dp))
                        Icon(
                            contentDescription = null,
                            imageVector = ImageVector.vectorResource(R.drawable.icon_arrow_share),
                            modifier = Modifier.size(25.dp)
                        )
                    }
                }

                Column {
                    Text(
                        article.title,
                        color = Color.White,
                        style = NewsToDayType.NewDescFull
                    )
                    Spacer(modifier = Modifier.padding(12.dp))
                    Column {
                        Text(
                            article.author ?: "Noname",
                            color = Color.White,
                            style = NewsToDayType.SemiCommon
                        )
                        Text(
                            "Author",
                            color = PrimaryGrey,
                            style = NewsToDayType.SemiLight
                        )
                    }
                }
            }
        }

        Column(
            modifier = modifier.fillMaxSize()
        ) {
            Text(
                article.description ?: "no desc",
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Medium
                )
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                article.content ?: "no content",
                style = TextStyle(
                    color = Color(0xFF666C8E),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal
                )
            )
        }
    }
}